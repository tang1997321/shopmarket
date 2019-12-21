package com.cy.shopmarket.background.systemmanager.controller;

import com.cy.shopmarket.background.systemmanager.service.SystemRoleService;
import com.cy.shopmarket.common.pojo.Role;
import com.cy.shopmarket.common.pojo.User;
import com.cy.shopmarket.common.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("system/role/")
public class SystemRoleController {
    @Autowired
    private SystemRoleService systemRoleService;
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String name, Integer pageCurrent){
        return new JsonResult(systemRoleService.doFindObjects(name, pageCurrent));
    }
    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(Role entity,Integer[] menuIds){
        systemRoleService.doSaveObject(entity,menuIds);
        return new JsonResult("save ok");
    }
    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id){
        Role role = systemRoleService.doFindById(id);
        return new JsonResult(role);
    }
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(Role entity,Integer[] menuIds){
        systemRoleService.doUpdateById(entity,menuIds);
        return new JsonResult("update ok");
    }
    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        systemRoleService.doDeleteById(id);
        return new JsonResult("delete ok");
    }
    @RequestMapping("doFindRoles")
    public JsonResult doFindRoles(){
        return new JsonResult(systemRoleService.findObjects());
    }

}
