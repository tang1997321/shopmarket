package com.cy.shopmarket.background.goodsmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.shopmarket.common.pojo.GoodsType;
import com.cy.shopmarket.background.goodsmanager.dao.GoodsGoodsTypeDao;
import com.cy.shopmarket.background.goodsmanager.service.GoodsGoodsTypeService;
import com.cy.shopmarket.common.annotation.AddLoggingAnnotation;
import com.cy.shopmarket.common.exception.ServiceException;
import com.cy.shopmarket.common.util.Assert;

@Service
public class GoodsGoodsTypeServiceImpl implements GoodsGoodsTypeService {

	@Autowired
	private GoodsGoodsTypeDao goodsGoodsTypeDao;
	
	@AddLoggingAnnotation(operation = "修改商品类型")
	@Override
	public int updateTypeOjbect(GoodsType goodsType) {
		Assert.isNull(goodsType, "修改的对象不能为空");
		int rows = goodsGoodsTypeDao.updateTypeOjbect(goodsType);
		return rows;
	}
	
	@AddLoggingAnnotation(operation = "添加商品类型")
	@Override
	public int insertTypeObject(GoodsType goodsType) {
		Assert.isNull(goodsType, "保存的对象不能为空");
		int rows = goodsGoodsTypeDao.insertTypeObject(goodsType);
		if(rows==0)
			throw new ServiceException("保存失败");
		return rows;
	}
	
	@AddLoggingAnnotation(operation = "删除商品类型" )
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
	public List<GoodsType> findTypeObjects() {
		
		return goodsGoodsTypeDao.findTypeObjects();
	}
}
