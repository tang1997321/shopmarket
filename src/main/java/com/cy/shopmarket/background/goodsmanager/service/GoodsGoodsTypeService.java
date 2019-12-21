package com.cy.shopmarket.background.goodsmanager.service;

import com.cy.shopmarket.common.pojo.GoodsType;
import com.cy.shopmarket.common.vo.PageObject;


public interface GoodsGoodsTypeService {

	int updateTypeOjbect(GoodsType goodsType);

	int insertTypeObject(GoodsType goodsType);

	int deleteTypeById(Integer id);
	
	PageObject<GoodsType> findTypeObjects(String username, Integer pageCurrent);
}
