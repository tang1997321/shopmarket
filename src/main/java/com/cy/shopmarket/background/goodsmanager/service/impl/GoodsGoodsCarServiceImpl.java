package com.cy.shopmarket.background.goodsmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.shopmarket.background.goodsmanager.dao.GoodsGoodsCarDao;
import com.cy.shopmarket.background.goodsmanager.service.GoodsGoodsCarService;
import com.cy.shopmarket.background.goodsmanager.vo.GoodsCarVo;
import com.cy.shopmarket.common.annotation.AddLoggingAnnotation;
import com.cy.shopmarket.common.exception.ServiceException;
import com.cy.shopmarket.common.pojo.GoodsCar;
import com.cy.shopmarket.common.util.Assert;
@Service
public class GoodsGoodsCarServiceImpl implements GoodsGoodsCarService {

	@Autowired
	private GoodsGoodsCarDao goodsGoodsCarDao;
	
	@AddLoggingAnnotation(operation = "修改购物车")
	@Override
	public int updateCarObject(GoodsCar goodsCar) {
		Assert.isNull(goodsCar, "保存的对象不能为空!");
		int rows = goodsGoodsCarDao.updateCarObject(goodsCar);
		return rows;
	}
	
	@AddLoggingAnnotation(operation = "添加购物车")
	@Override
	public int insertCarObject(GoodsCar goodsCar) {
		Assert.isNull(goodsCar, "保存的对象不能为空!");
		int rows = goodsGoodsCarDao.insertCarObject(goodsCar);
		
		if(rows==0) 
			throw new ServiceException("添加失败");
		return rows;
	}
	
	@AddLoggingAnnotation(operation = "删除购物车")
	@Override
	public int deleteCarById(Integer id) {
		Assert.isValid(id!=null&&id>0, "请选择!");
		int rows = goodsGoodsCarDao.deleteCarByGoodId(id);
		return rows;
	}
	
	@AddLoggingAnnotation(operation = "其他操作")
	@Override
	public List<GoodsCarVo> findCarObjects() {
		
		return goodsGoodsCarDao.findCarObjects();
	}

}
