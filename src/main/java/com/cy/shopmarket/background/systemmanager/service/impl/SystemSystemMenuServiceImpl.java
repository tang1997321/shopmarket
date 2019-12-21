package com.cy.shopmarket.background.systemmanager.service.impl;

import java.util.List;

import com.cy.shopmarket.background.systemmanager.vo.SystemNodeVo;
import com.cy.shopmarket.common.exception.ServiceException;
import com.cy.shopmarket.common.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.shopmarket.background.systemmanager.dao.SystemMenuDao;
import com.cy.shopmarket.background.systemmanager.dao.SystemRoleMenuDao;
import com.cy.shopmarket.background.systemmanager.service.SystemMenuService;
import com.cy.shopmarket.common.annotation.AddLoggingAnnotation;
import com.cy.shopmarket.common.pojo.Menu;

@Service
public class SystemSystemMenuServiceImpl implements SystemMenuService {
    @Autowired(required = false)
    private SystemMenuDao systemMenuDao;
    @Autowired(required = false)
    private SystemRoleMenuDao systemRoleMenuDao;

    @AddLoggingAnnotation(operation = "其他操作")
    @Override
    public Menu doFindObjectById(Integer id) {
        Menu menu = systemMenuDao.doFindObjectById(id);
        return menu;
    }

    /**
     * 返回所有菜单,在前端分类
     *
     * @return
     */
    @AddLoggingAnnotation(operation = "其他操作")
    @Override
    public List<Menu> doFindObjects() {
        List<Menu> menus = systemMenuDao.doFindObjectById();
        if (menus == null || menus.size() == 0) {
            throw new ServiceException("没有对应的菜单信息");
        }
        return menus;
    }

    @AddLoggingAnnotation(operation = "添加操作", operationId = 3)
    @Override
    public int doSaveObject(Menu entity) {
        Assert.isNull(entity, "保存对象不能为空");
        Assert.isEmpty(entity.getName(), "菜单名不能为空");
        int rows = systemMenuDao.doSaveObject(entity);
        return rows;
    }


    @AddLoggingAnnotation(operation = "修改操作", operationId = 2)
    @Override
    public int doUpdateById(Menu entity) {
        Assert.isNull(entity, "保存对象不能为空");
        Assert.isEmpty(entity.getName(), "菜单名不能为空");
        int rows = systemMenuDao.doUpdateObject(entity);
        return rows;
    }

    @Transactional(timeout = 20,
            readOnly = false,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Throwable.class,
            propagation = Propagation.REQUIRED)
    @AddLoggingAnnotation(operation = "删除操作", operationId = 4)
    @Override
    public int doDeleteById(Integer id) {
        Assert.isValid(id != null && id > 0, "id值无效");
        int childCount = systemMenuDao.getChildCount(id);
        if (childCount > 0)
            throw new ServiceException("请先删除子菜单");
        systemRoleMenuDao.doDeleteByMenuId(id);
        int rows = systemMenuDao.doDeleteObjectById(id);
        if (rows == 0)
            throw new ServiceException("记录已经不存在");
        return rows;
    }

    @Override
    public List<SystemNodeVo> findZtreeMenuNodes() {
        return systemMenuDao.findZtreeMenuNodes();

    }
}
