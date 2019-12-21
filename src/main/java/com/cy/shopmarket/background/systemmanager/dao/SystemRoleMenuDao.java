package com.cy.shopmarket.background.systemmanager.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemRoleMenuDao {
	
	int doDeleteByMenuId(Integer id) ;
	
	int doDeleteByRoleId(Integer id);
}
