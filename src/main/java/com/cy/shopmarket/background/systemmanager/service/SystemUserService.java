package com.cy.shopmarket.background.systemmanager.service;

import com.cy.shopmarket.background.systemmanager.vo.SystemUserRoleVo;
import com.cy.shopmarket.common.pojo.User;

import java.util.List;

public interface SystemUserService {
	/**
	 * 查询所有用户
	 * @return
	 */
	List<SystemUserRoleVo> doFindObjects(String username);
	/**
	 * 删除用户
	 */
	int doDeleteObjects(Integer id);
	
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
	int doUpdateById(SystemUserRoleVo entity, Integer[] roleIds);
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	List<SystemUserRoleVo> doFindById(Integer id);
}
