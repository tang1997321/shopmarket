package com.cy.shopmarket.background.goodsmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.shopmarket.background.goodsmanager.dao.GoodsGoodsTypeDao;
import com.cy.shopmarket.background.goodsmanager.service.GoodsGoodsTypeService;
import com.cy.shopmarket.background.goodsmanager.vo.GoodsCarVo;
import com.cy.shopmarket.common.annotation.AddLoggingAnnotation;
import com.cy.shopmarket.common.config.PageProperties;
import com.cy.shopmarket.common.exception.ServiceException;
import com.cy.shopmarket.common.pojo.GoodsCar;
import com.cy.shopmarket.common.pojo.GoodsType;
import com.cy.shopmarket.common.util.Assert;
import com.cy.shopmarket.common.vo.PageObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class GoodsGoodsTypeServiceImpl implements GoodsGoodsTypeService {

	@Autowired
	private GoodsGoodsTypeDao goodsGoodsTypeDao;
	
	@Autowired
	private PageProperties pageProperties;
	@AddLoggingAnnotation(operation = "修改商品类型",operationId = 2)
	@Override
	public int updateTypeOjbect(GoodsType goodsType) {
		Assert.isNull(goodsType, "修改的对象不能为空");
		int rows = goodsGoodsTypeDao.updateTypeOjbect(goodsType);
		return rows;
	}
	
	@AddLoggingAnnotation(operation = "添加商品类型",operationId = 3)
	@Override
	public int insertTypeObject(GoodsType goodsType) {
		Assert.isNull(goodsType, "保存的对象不能为空");
		int rows = goodsGoodsTypeDao.insertTypeObject(goodsType);
		if(rows==0)
			throw new ServiceException("保存失败");
		return rows;
	}
	
	@Transactional(timeout = 20,
            readOnly = false,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Throwable.class,
            propagation = Propagation.REQUIRED)
	@AddLoggingAnnotation(operation = "删除商品类型" ,operationId = 4)
	@Override
	public int deleteTypeById(Integer id) {
		Assert.isValid(id!=null&&id>0, "请选择!");
		int rows = goodsGoodsTypeDao.deleteTypeById(id);
		if(rows==0)
			throw new ServiceException("记录可能已经不存在!");
		return rows;
	}
	
	@AddLoggingAnnotation(operation = "其它操作")
	@Override
	public PageObject<GoodsType> findTypeObjects(	String username, Integer pageCurrent) {
		
		//1.参数校验
				Assert.isValid(pageCurrent!=null&&pageCurrent>=1, "页码值无效");
				//2.设置查询起始位置
				int pageSize=pageProperties.getPageSize();
				Page<GoodsCar> page=
				PageHelper.startPage(pageCurrent,pageSize);
				//3.查询当前页日志记录
				List<GoodsType> records=goodsGoodsTypeDao.findTypeObjects(username);
				return new PageObject<GoodsType>(records, (int)page.getTotal(), pageCurrent, pageSize);
	}
}
