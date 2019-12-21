package com.cy.shopmarket.background.goodsmanager.service;

import java.util.List;

import com.cy.shopmarket.common.pojo.GoodsType;


public interface GoodsGoodsTypeService {

	int updateTypeOjbect(GoodsType goodsType);

	int insertTypeObject(GoodsType goodsType);

	int deleteTypeById(Integer id);
	
	List<GoodsType> findTypeObjects();
}
