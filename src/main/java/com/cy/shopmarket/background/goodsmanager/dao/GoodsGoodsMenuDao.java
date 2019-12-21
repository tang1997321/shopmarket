package com.cy.shopmarket.background.goodsmanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.shopmarket.common.pojo.Menu;

@Mapper
public interface GoodsGoodsMenuDao {
	
	int updateMenuOjbect(@Param("menu")Menu menu);
	
	int insertMenuObject(@Param("menu")Menu menu);
	
	int deleteMenuById(@Param("id")Integer id);
	
	List<Menu> findMenuObjects();
}
