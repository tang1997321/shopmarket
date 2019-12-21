package com.cy.shopmarket.background.systemmanager.service;

import com.cy.shopmarket.common.pojo.Role;

import java.util.List;

public interface SystemRoleService {
	List<Role> doFindObjects();
	
	Role doFindById(Integer id);
	
	int doDeleteById(Integer Id);
	
	int doUpdateById(Role entity);
	
	int doSaveObject(Role entity);
}
