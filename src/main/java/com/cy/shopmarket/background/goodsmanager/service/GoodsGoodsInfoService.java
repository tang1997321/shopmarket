package com.cy.shopmarket.background.goodsmanager.service;

import java.util.List;

import com.cy.shopmarket.common.pojo.GoodsInfo;

/**
 *	商品业务层接口
 */
public interface GoodsGoodsInfoService {

	int updateGoodsObject(GoodsInfo goodsInfo);
	
	int insertGoodObject(GoodsInfo goodsInfo);
	
	int deleteGoodById(Integer id);
	
	List<GoodsInfo> findGoodsObjects();
}
