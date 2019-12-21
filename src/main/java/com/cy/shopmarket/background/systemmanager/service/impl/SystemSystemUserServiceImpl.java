package com.cy.shopmarket.background.systemmanager.service.impl;

import com.cy.shopmarket.background.systemmanager.dao.SystemGoodsCarDao;
import com.cy.shopmarket.background.systemmanager.dao.SystemGoodsInfoDao;
import com.cy.shopmarket.background.systemmanager.dao.SystemUserDao;
import com.cy.shopmarket.background.systemmanager.dao.SystemUserRoleDao;
import com.cy.shopmarket.background.systemmanager.service.SystemUserService;
import com.cy.shopmarket.background.systemmanager.vo.SystemUserRoleVo;
import com.cy.shopmarket.common.annotation.AddLoggingAnnotation;
import com.cy.shopmarket.common.config.PageProperties;
import com.cy.shopmarket.common.exception.ServiceException;
import com.cy.shopmarket.common.pojo.User;
import com.cy.shopmarket.common.util.Assert;
import com.cy.shopmarket.common.vo.PageObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	@Autowired
	private PageProperties pageProperties;

	/**
	 * 查询所有用户
	 *
	 * @return
	 */
	@AddLoggingAnnotation(operation = "其他操作")
	@Override
	public PageObject<SystemUserRoleVo> doFindObjects(String username, Integer pageCurrent) {
		Assert.isValid(pageCurrent != null && pageCurrent > 0, "当前页码值无效");
		System.out.println(username);
		int rowCount = systemUserDao.getRowCount(username);
		if (rowCount == 0)
			throw new ServiceException("没有找到对应记录");
		int pageSize = pageProperties.getPageSize();
		Page<Object> page = PageHelper.startPage(pageCurrent, pageSize);
		List<SystemUserRoleVo> result = systemUserDao.doFindObjects(username);
		System.out.println(result);
		return new PageObject<>(result, pageCurrent, (int) page.getTotal(), pageSize);
	}

	@Transactional(timeout = 20,
			readOnly = false,
			isolation = Isolation.READ_COMMITTED,
			rollbackFor = Throwable.class,
			propagation = Propagation.REQUIRED)
	@AddLoggingAnnotation(operation = "删除操作", operationId = 4)
	@Override
	public int doDeleteObject(Integer id) {
		System.out.println(id);
		Assert.isValid(null != id && id > 0, "id值不合法");
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
	 *
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	@AddLoggingAnnotation(operation = "添加操作", operationId = 3)
	@Override
	public int doSaveObject(User entity, Integer[] roleIds) {
		Assert.isNull(entity, "保存对象不能为空");
		Assert.isEmpty(entity.getPassword(), "密码不能为空");
		Assert.isEmpty(entity.getUsername(), "用户名不能为空");
		Assert.isEmpty(roleIds, "至少要为用户分配角色");
		String source = entity.getPassword();
		String salt = UUID.randomUUID().toString();
		SimpleHash sh = new SimpleHash("MD5", source, salt, 1);
		entity.setSalt(salt);
		entity.setPassword(sh.toHex());
		int rows = systemUserDao.doSaveObject(entity);
		systemUserRoleDao.insertObjects(entity.getId(), roleIds);
		return rows;
	}

	@AddLoggingAnnotation(operation = "修改操作", operationId = 2)
	@Override
	@Transactional
	public int doUpdateById(User entity, Integer[] roleIds) {
		Assert.isNull(entity, "保存对象不能为空");
		Assert.isEmpty(entity.getUsername(), "用户名不能为空");
		Assert.isEmpty(roleIds, "至少要为其分配角色");
		int rows = systemUserDao.doUpdateById(entity);
		systemUserRoleDao.doDeleteByUserId(entity.getId());
		systemUserRoleDao.insertObjects(entity.getId(), roleIds);
		return rows;
	}

	@AddLoggingAnnotation(operation = "其他操作")
	@Override
	public Map<String, Object> doFindById(Integer id) {
		Assert.isValid(id != null && id > 0, "参数数据不合法");
		User user = systemUserDao.doFindById(id);
		Assert.isNull(user, "此用户已经不存在");
		List<Integer> roleIds = systemUserRoleDao.findRoleIdsByUserIds(id);
		HashMap<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roleIds", roleIds);
		return map;
	}


}
