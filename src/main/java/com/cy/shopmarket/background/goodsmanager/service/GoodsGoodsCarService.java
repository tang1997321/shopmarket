package com.cy.shopmarket.background.goodsmanager.service;

import java.util.List;

import com.cy.shopmarket.common.pojo.GoodsCar;
import com.cy.shopmarket.background.goodsmanager.vo.GoodsCarVo;

public interface GoodsGoodsCarService {
	
	int updateCarObject(GoodsCar goodsCar);
	
	int insertCarObject(GoodsCar goodsCar);
	
	int deleteCarById(Integer id);
	
	List<GoodsCarVo> findCarObjects();
	
}
