package com.cy.shopmarket.background.goodsmanager.service;


import com.cy.shopmarket.common.pojo.GoodsInfo;
import com.cy.shopmarket.common.vo.PageObject;

/**
 *	商品业务层接口
 */
public interface GoodsGoodsInfoService {

	int updateGoodsObject(GoodsInfo goodsInfo);
	
	int insertGoodObject(GoodsInfo goodsInfo);
	
	int deleteGoodById(Integer id);
	
	PageObject<GoodsInfo> findGoodsObjects(String username, Integer pageCurrent);
}
