package com.cy.shopmarket.background.goodsmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.shopmarket.common.pojo.GoodsCar;
import com.cy.shopmarket.common.pojo.GoodsInfo;
import com.cy.shopmarket.background.goodsmanager.dao.GoodsGoodsCarDao;
import com.cy.shopmarket.background.goodsmanager.dao.GoodsGoodsInfoDao;
import com.cy.shopmarket.background.goodsmanager.service.GoodsGoodsInfoService;
import com.cy.shopmarket.common.annotation.AddLoggingAnnotation;
import com.cy.shopmarket.common.exception.ServiceException;
import com.cy.shopmarket.common.util.Assert;
/**
 *	商品业务层实现类
 */
@Service
public class GoodsGoodsInfoServiceImpl implements GoodsGoodsInfoService {

	@Autowired
	private GoodsGoodsInfoDao goodsGoodsInfoDao;

	@Autowired
	private GoodsGoodsCarDao goodsGoodsCarDao;

	//改
	@AddLoggingAnnotation(operation = "修改商品")
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
	@AddLoggingAnnotation(operation = "添加商品")
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
	@AddLoggingAnnotation(operation = "删除商品")
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
	public List<GoodsInfo> findGoodsObjects() {
//		int rows = goodsGoodsInfoDao.getRowCount();
		return goodsGoodsInfoDao.findGoodsObjects();
	}
}
