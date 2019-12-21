package com.cy.shopmarket.background.systemmanager.controller;

import com.cy.shopmarket.background.systemmanager.service.SystemUserService;
import com.cy.shopmarket.background.systemmanager.vo.SystemUserRoleVo;
import com.cy.shopmarket.common.pojo.User;
import com.cy.shopmarket.common.vo.JsonResult;
import com.cy.shopmarket.common.vo.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("system/user/")
public class SystemUserController {
    @Autowired
    private SystemUserService systemUserService;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
        PageObject<SystemUserRoleVo> records = systemUserService.doFindObjects(username, pageCurrent);
        return new JsonResult(records);
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(User entity, Integer[] roleIds) {
        systemUserService.doSaveObject(entity, roleIds);
        return new JsonResult("save ok");
    }
    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id) {
        Map<String, Object> map = systemUserService.doFindById(id);
        return new JsonResult(map);
    }
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(User entity, Integer[] roleIds) {
        systemUserService.doUpdateById(entity, roleIds);
        return new JsonResult("update ok");
    }
    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id) {
        systemUserService.doDeleteObject(id);
        return new JsonResult("delete ok");
    }

}
