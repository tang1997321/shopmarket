package com.cy.shopmarket.background.goodsmanager.service;

import com.cy.shopmarket.background.goodsmanager.vo.GoodsCarVo;
import com.cy.shopmarket.common.pojo.GoodsCar;
import com.cy.shopmarket.common.vo.PageObject;

public interface GoodsGoodsCarService {
	
	int updateCarObject(GoodsCar goodsCar);
	
	int insertCarObject(GoodsCar goodsCar);
	
	int deleteCarById(Integer id);
	
	PageObject<GoodsCarVo> findPageObjects(String username, Integer pageCurrent);
	
}
