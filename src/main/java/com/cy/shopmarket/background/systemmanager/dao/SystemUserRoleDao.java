package com.cy.shopmarket.background.systemmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemUserRoleDao {
	int doDeleteByUserId(@Param("id") Integer id);
	
	int insertObjects(@Param("userId") Integer userId, @Param("roleIds") Integer[] roleIds);
	
	int doDeleteByRoleId(Integer id);

	List<Integer> findRoleIdsByUserIds(Integer id);
}
