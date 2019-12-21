package com.cy.shopmarket.background.systemmanager.service;

import com.cy.shopmarket.background.systemmanager.vo.CheckBox;
import com.cy.shopmarket.common.pojo.Role;
import com.cy.shopmarket.common.vo.PageObject;

import java.util.List;

public interface SystemRoleService {
	PageObject<Role> doFindObjects(String name, Integer pageCurrent);
	
	Role doFindById(Integer id);
	
	int doDeleteById(Integer Id);
	
	int doUpdateById(Role entity, Integer[] menuIds);
	
	int doSaveObject(Role entity, Integer[] menuIds);

    List<CheckBox> findObjects();
}
