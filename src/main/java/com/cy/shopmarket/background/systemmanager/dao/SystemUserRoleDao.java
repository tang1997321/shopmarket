package com.cy.shopmarket.background.systemmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SystemUserRoleDao {
	int doDeleteByUserId(@Param("id") Integer id);
	
	int insertObjects(@Param("userId") Integer userId, Integer[] roleIds);
	
	int doDeleteByRoleId(Integer id);
}
