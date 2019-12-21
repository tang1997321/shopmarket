package com.cy.shopmarket.background.systemmanager.dao;

import com.cy.shopmarket.background.systemmanager.vo.SystemUserRoleVo;
import com.cy.shopmarket.common.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 	用户模块
 */
@Mapper
public interface SystemUserDao {
	//根据用户名查询用户
	List<SystemUserRoleVo> doFindObjects(String username);
	int doDeleteObjectById(Integer id);
	
	int doSaveObject(@Param("entity") User entity);
	
	List<SystemUserRoleVo> doFindById(Integer id);
	
	int doUpdateById(@Param("entity") SystemUserRoleVo entity);
}
