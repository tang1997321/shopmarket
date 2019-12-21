package com.cy.shopmarket.background.systemmanager.service.impl;

import com.cy.shopmarket.background.systemmanager.dao.SystemGoodsCarDao;
import com.cy.shopmarket.background.systemmanager.dao.SystemGoodsInfoDao;
import com.cy.shopmarket.background.systemmanager.dao.SystemUserDao;
import com.cy.shopmarket.background.systemmanager.dao.SystemUserRoleDao;
import com.cy.shopmarket.background.systemmanager.service.SystemUserService;
import com.cy.shopmarket.background.systemmanager.vo.SystemUserRoleVo;
import com.cy.shopmarket.common.pojo.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SystemSystemUserServiceImpl implements SystemUserService {
	@Autowired(required = false)
	private SystemUserDao systemUserDao;
	@Autowired(required = false)
	private SystemUserRoleDao systemUserRoleDao;
	@Autowired(required = false)
	private SystemGoodsInfoDao systemGoodsInfoDao;
	@Autowired(required = false)
	private SystemGoodsCarDao systemGoodsCarDao;
	
	/**
	 * 查询所有用户
	 *
	 * @return
	 */
	@Override
	public List<SystemUserRoleVo> doFindObjects(String username) {
		List<SystemUserRoleVo> result = systemUserDao.doFindObjects(username);
		return result;
	}
	
	@Transactional
	@Override
	public int doDeleteObjects(Integer id) {
		//查询用户的商品id
		List<Integer> goodIds = systemGoodsInfoDao.doFindObjectsByUserId(id);
		//根据商品id删除购物车中的商品
		systemGoodsCarDao.doDeleteObjectsByGoodIds(goodIds);
		systemGoodsCarDao.doDeleteObjectsByUserId(id);
		//根据用户id删除商品
		systemGoodsInfoDao.doDeleteByUserId(id);
		//删除用户和角色的关系
		systemUserRoleDao.doDeleteByUserId(id);
		//删除用户
		int rows = systemUserDao.doDeleteObjectById(id);
		return rows;
	}
	
	/**
	 * 保存用户数据
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	@Override
	public int doSaveObject(User entity, Integer[] roleIds) {
		String source = entity.getPassword();
		String salt= UUID.randomUUID().toString();
		SimpleHash sh = new SimpleHash("MD5", source, salt, 1);
		entity.setSalt(salt);
		entity.setPassword(sh.toHex());
		int rows= systemUserDao.doSaveObject(entity);
		systemUserRoleDao.insertObjects(entity.getId(),roleIds);
		return rows;
	}
	
	@Override
	public int doUpdateById(SystemUserRoleVo entity, Integer[] roleIds) {
		systemUserDao.doUpdateById(entity);
		systemUserRoleDao.doDeleteByUserId(entity.getId());
		systemUserRoleDao.insertObjects(entity.getId(),roleIds);
		return 0;
	}
	
	@Override
	public List<SystemUserRoleVo> doFindById(Integer id) {
		List<SystemUserRoleVo> result = systemUserDao.doFindById(id);
		return result;
	}
	
	
}
