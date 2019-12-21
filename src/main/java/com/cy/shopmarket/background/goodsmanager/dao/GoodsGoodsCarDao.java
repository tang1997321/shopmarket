package com.cy.shopmarket.background.goodsmanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.shopmarket.common.pojo.GoodsCar;
import com.cy.shopmarket.background.goodsmanager.vo.GoodsCarVo;

@Mapper
public interface GoodsGoodsCarDao {
	
	int updateCarObject(@Param("goodsCar")GoodsCar goodsCar);

	int insertCarObject(@Param("goodsCar")GoodsCar goodsCar);
	
	int deleteCarByGoodId(@Param("id")Integer id);
	
	List<GoodsCarVo> findCarObjects();
}
