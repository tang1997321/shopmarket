package com.cy.shopmarket.background.systemmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemGoodsCarDao {
	int doDeleteObjectsByGoodIds(@Param("goodIds") List<Integer> goodIds);
	
	int doDeleteObjectsByUserId(Integer id);
}
