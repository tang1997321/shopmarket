package com.cy.shopmarket.background.systemmanager.service.impl;

import com.cy.shopmarket.background.systemmanager.dao.SystemMenuDao;
import com.cy.shopmarket.background.systemmanager.dao.SystemRoleMenuDao;
import com.cy.shopmarket.background.systemmanager.service.SystemMenuService;
import com.cy.shopmarket.common.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemSystemMenuServiceImpl implements SystemMenuService {
	@Autowired(required = false)
	private SystemMenuDao systemMenuDao;
	@Autowired(required = false)
	private SystemRoleMenuDao systemRoleMenuDao;
	@Override
	public Menu doFindObjectById(Integer id) {
		Menu menu = systemMenuDao.doFindObjectById(id);
		return menu;
	}
	
	/**
	 * 返回所有菜单,在前端分类
	 * @return
	 */
	@Override
	public List<Menu> doFindObjects() {
		List<Menu> menus = systemMenuDao.doFindObjectById();
		return menus;
	}
	
	@Override
	public int doSaveObject(Menu entity) {
		int rows= systemMenuDao.doSaveObject(entity);
		return rows;
	}
	
	@Override
	public int doUpdateById(Menu entity) {
		systemMenuDao.doUpdateObject(entity);
		return 0;
	}
	
	@Override
	public int doDeleteById(Integer id) {
		systemRoleMenuDao.doDeleteByMenuId(id);
		systemMenuDao.doDeleteObjectById(id);
		return 0;
	}
}
