package com.cy.shopmarket.background.systemmanager.dao;

import com.cy.shopmarket.common.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemRoleDao {
	
	List<Role> doFindObjectById();
	
	Role doFindObjectById(Integer id);
	
	int doDeleteById(Integer id);
	
	int doUpdateById(@Param("entity") Role entity);
	
	int doSaveObject(@Param("entity") Role entity);
}