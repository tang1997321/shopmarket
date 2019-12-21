package com.cy.shopmarket.background.systemmanager.service.impl;

import com.cy.shopmarket.background.systemmanager.dao.SystemRoleDao;
import com.cy.shopmarket.background.systemmanager.dao.SystemRoleMenuDao;
import com.cy.shopmarket.background.systemmanager.dao.SystemUserRoleDao;
import com.cy.shopmarket.background.systemmanager.service.SystemRoleService;
import com.cy.shopmarket.background.systemmanager.vo.CheckBox;
import com.cy.shopmarket.common.annotation.AddLoggingAnnotation;
import com.cy.shopmarket.common.config.PageProperties;
import com.cy.shopmarket.common.exception.ServiceException;
import com.cy.shopmarket.common.pojo.Role;
import com.cy.shopmarket.common.util.Assert;
import com.cy.shopmarket.common.vo.PageObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SystemSystemRoleServiceImpl implements SystemRoleService {
	@Autowired(required = false)
	private SystemRoleDao systemRoleDao;
	@Autowired(required = false)
	private SystemUserRoleDao systemUserRoleDao;
	@Autowired(required = false)
	private SystemRoleMenuDao systemRoleMenuDao;
	@Autowired
	private PageProperties pageProperties;
	@AddLoggingAnnotation(operation = "其他操作")
	@Override
	public PageObject<Role> doFindObjects(String name, Integer pageCurrent) {
		Assert.isValid(pageCurrent != null && pageCurrent > 0, "页码值无效");
		int rowCount = systemRoleDao.doGetRowCounts(name);
		if (rowCount == 0)
			throw new ServiceException("记录不存在");
		int pageSize = pageProperties.getPageSize();
		Page<Object> page = PageHelper.startPage(pageCurrent, pageSize);
		List<Role> records = systemRoleDao.doFindObjects(name);
		System.out.println(records);
		return new PageObject<>(records, pageCurrent, (int) page.getTotal(), pageSize);
	}
	
	@AddLoggingAnnotation(operation = "其他操作")
	@Override
	public Role doFindById(Integer id) {
		Assert.isValid(id != null && id > 0, "id的值不合法");
		Role entity = systemRoleDao.doFindObjectById(id);
		if (entity == null)
			throw new ServiceException("此记录已经不存在");
		return entity;
	}
	
	@Transactional(timeout = 20,
            readOnly = false,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Throwable.class,
            propagation = Propagation.REQUIRED)
	@AddLoggingAnnotation(operation = "删除操作",operationId = 4)
	@Override
	public int doDeleteById(Integer id) {
		Assert.isValid(id != null && id > 0, "请先选择");
		//删除用户和角色的关系
		systemUserRoleDao.doDeleteByRoleId(id);
		//删除角色和菜单的关系
		systemRoleMenuDao.doDeleteByRoleId(id);
		int rows = systemRoleDao.doDeleteById(id);
		if (rows == 0)
			throw new ServiceException("记录不存在");
		return rows;
	}
	
	@AddLoggingAnnotation(operation = "修改操作",operationId = 2)
	@Override
	public int doUpdateById(Role entity, Integer[] menuIds) {
		Assert.isNull(entity, "保存对象不能为空");
		Assert.isEmpty(entity.getName(), "角色名不允许为空");
		Assert.isEmpty(menuIds, "必须为角色分配权限");
		int rows= systemRoleDao.doUpdateById(entity);
		systemRoleMenuDao.doDeleteByMenuId(entity.getId());
		systemRoleMenuDao.doSaveObjects(entity.getId(),menuIds);
		return rows;
	}
	
	@AddLoggingAnnotation(operation = "添加操作",operationId = 3)
	@Override
	public int doSaveObject(Role entity, Integer[] menuIds) {
		Assert.isNull(entity, "保存对象不能为空");
		Assert.isEmpty(entity.getName(), "角色名不允许为空");
		Assert.isEmpty(menuIds, "必须为角色分配权限");
		int rows= systemRoleDao.doSaveObject(entity);
		systemRoleMenuDao.doSaveObjects(entity.getId(),menuIds);
		return rows;
	}

	@Override
	public List<CheckBox> findObjects() {
		return systemRoleDao.findObjects();
	}
}
