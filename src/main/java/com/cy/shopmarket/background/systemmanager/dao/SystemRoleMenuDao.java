package com.cy.shopmarket.background.systemmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SystemRoleMenuDao {

	int doDeleteByMenuId(Integer id);

	int doDeleteByRoleId(Integer id);

	int doSaveObjects(@Param("roleId") Integer roleId,
					  @Param("menuIds") Integer[] menuIds);
}
