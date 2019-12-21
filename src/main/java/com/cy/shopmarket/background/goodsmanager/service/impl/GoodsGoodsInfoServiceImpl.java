package com.cy.shopmarket.background.goodsmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.shopmarket.background.goodsmanager.dao.GoodsGoodsCarDao;
import com.cy.shopmarket.background.goodsmanager.dao.GoodsGoodsInfoDao;
import com.cy.shopmarket.background.goodsmanager.service.GoodsGoodsInfoService;
import com.cy.shopmarket.common.annotation.AddLoggingAnnotation;
import com.cy.shopmarket.common.config.PageProperties;
import com.cy.shopmarket.common.exception.ServiceException;
import com.cy.shopmarket.common.pojo.GoodsCar;
import com.cy.shopmarket.common.pojo.GoodsInfo;
import com.cy.shopmarket.common.util.Assert;
import com.cy.shopmarket.common.vo.PageObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
/**
 *	商品业务层实现类
 */
@Service
public class GoodsGoodsInfoServiceImpl implements GoodsGoodsInfoService {

	@Autowired
	private GoodsGoodsInfoDao goodsGoodsInfoDao;

	@Autowired
	private GoodsGoodsCarDao goodsGoodsCarDao;
	
	@Autowired
	private PageProperties pageProperties;

	//改
	@AddLoggingAnnotation(operation = "修改商品",operationId = 2)
	@Override
	public int updateGoodsObject(GoodsInfo goodsInfo) {
		//1.判定
		Assert.isEmpty(goodsInfo.getName(), "商品名不能为空!");
		Assert.isNull(goodsInfo.getTypeId(), "商品类型不能为空!");
		Assert.isEmpty(goodsInfo.getJpg(), "商品图片不能为空!");
		Assert.isNull(goodsInfo.getIsHot(), "商品是否热销不能为空!");
		if(goodsInfo.getIsHot()!=0||goodsInfo.getIsHot()!=1)
			throw new ServiceException("商品热销只能为0或1");
		Assert.isNull(goodsInfo.getPrice(), "商品价格不能为空!");
		//2.1修改自身表数据
		int rows = goodsGoodsInfoDao.updateGoodsObject(goodsInfo);
		//2.2删除关系表数据
		goodsGoodsCarDao.deleteCarByGoodId(goodsInfo.getId());
		//2.3添加关系表数据
		GoodsCar goodsCar = new GoodsCar(goodsInfo.getId(), goodsInfo.getUserId(), goodsInfo.getIsHot()) ;
		goodsGoodsCarDao.updateCarObject(goodsCar);
		return rows;
	}
	
	//增
	@AddLoggingAnnotation(operation = "添加商品",operationId = 3)
	@Override
	public int insertGoodObject(GoodsInfo goodsInfo) {
		//1.判定
		Assert.isEmpty(goodsInfo.getName(), "商品名不能为空!");
		Assert.isNull(goodsInfo.getTypeId(), "商品类型不能为空!");
		Assert.isEmpty(goodsInfo.getJpg(), "商品图片不能为空!");
		Assert.isNull(goodsInfo.getIsHot(), "商品是否热销不能为空!");
		if(goodsInfo.getIsHot()!=0||goodsInfo.getIsHot()!=1)
			throw new ServiceException("商品热销只能为0或1");
		Assert.isNull(goodsInfo.getPrice(), "商品价格不能为空!");
		//2.1增加自身表中数据
		int rows = goodsGoodsInfoDao.insertGoodObject(goodsInfo, goodsInfo.getUserId());
		//2.2添加关系表数据
		GoodsCar goodsCar = new GoodsCar(goodsInfo.getId(), goodsInfo.getUserId(), goodsInfo.getIsHot()) ;
		goodsGoodsCarDao.insertCarObject(goodsCar);
		//3.返回结果
		return rows;
	}

	//删
	@Transactional(timeout = 20,
            readOnly = false,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Throwable.class,
            propagation = Propagation.REQUIRED)
	@AddLoggingAnnotation(operation = "删除商品",operationId = 4)
	@Override
	public int deleteGoodById(Integer id) {
		//1.判定
		Assert.isValid(id!=null&&id>0, "请选择!");
		//2.1删除关系表数据
		goodsGoodsCarDao.deleteCarByGoodId(id);
		//2.2删除自身数据
		int rows = goodsGoodsInfoDao.deleteGoodById(id);
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}

	//查
	@AddLoggingAnnotation(operation = "其它操作")
	@Override
	public PageObject<GoodsInfo> findGoodsObjects(
			String username, Integer pageCurrent){
		//1.参数校验
		Assert.isValid(pageCurrent!=null&&pageCurrent>=1, "页码值无效");
		//2.设置查询起始位置
		int pageSize=pageProperties.getPageSize();
		Page<GoodsCar> page=
		PageHelper.startPage(pageCurrent,pageSize);
		//3.查询当前页日志记录
		List<GoodsInfo> records=goodsGoodsInfoDao.findGoodsObjects(username);
		return new PageObject<GoodsInfo>(records, (int)page.getTotal(), pageCurrent, pageSize);
	} 
}
