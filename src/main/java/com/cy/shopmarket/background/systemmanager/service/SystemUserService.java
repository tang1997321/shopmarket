package com.cy.shopmarket.background.systemmanager.service;

import com.cy.shopmarket.background.systemmanager.vo.SystemUserRoleVo;
import com.cy.shopmarket.common.pojo.User;
import com.cy.shopmarket.common.vo.PageObject;

import java.util.Map;

public interface SystemUserService {
	/**
	 * 查询所有用户
	 * @return
	 */
	PageObject<SystemUserRoleVo> doFindObjects(String username, Integer pageCurrent);
	/**
	 * 删除用户
	 */
	int doDeleteObject(Integer id);
	
	/**
	 * 增添用户
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int doSaveObject(User entity, Integer[] roleIds);
	
	/**
	 * 更新用户
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int doUpdateById(User entity, Integer[] roleIds);
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	Map<String, Object> doFindById(Integer id);
}
