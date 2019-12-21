package com.cy.shopmarket.background.systemmanager.service.impl;

import com.cy.shopmarket.background.systemmanager.dao.SystemRoleDao;
import com.cy.shopmarket.background.systemmanager.dao.SystemRoleMenuDao;
import com.cy.shopmarket.background.systemmanager.dao.SystemUserRoleDao;
import com.cy.shopmarket.background.systemmanager.service.SystemRoleService;
import com.cy.shopmarket.common.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemSystemRoleServiceImpl implements SystemRoleService {
	@Autowired(required = false)
	private SystemRoleDao systemRoleDao;
	@Autowired(required = false)
	private SystemUserRoleDao systemUserRoleDao;
	@Autowired(required = false)
	private SystemRoleMenuDao systemRoleMenuDao;
	
	@Override
	public List<Role> doFindObjects() {
		List<Role> list = systemRoleDao.doFindObjectById();
		return list;
	}
	
	@Override
	public Role doFindById(Integer id) {
		Role entity = systemRoleDao.doFindObjectById(id);
		return entity;
	}
	
	@Override
	public int doDeleteById(Integer id) {
		//删除用户和角色的关系
		int rows = systemUserRoleDao.doDeleteByRoleId(id);
		if (rows==0)
		//删除角色和菜单的关系
		rows= systemRoleMenuDao.doDeleteByRoleId(id);
		if (rows==0)
		rows = systemRoleDao.doDeleteById(id);
		if (rows==0){}
		return rows;
	}
	
	@Override
	public int doUpdateById(Role entity) {
		int rows= systemRoleDao.doUpdateById(entity);
		return 0;
	}
	
	@Override
	public int doSaveObject(Role entity) {
		int rows= systemRoleDao.doSaveObject(entity);
		return 0;
	}
}
