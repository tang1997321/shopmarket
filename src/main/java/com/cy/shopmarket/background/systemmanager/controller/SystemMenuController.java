package com.cy.shopmarket.background.systemmanager.controller;

import com.cy.shopmarket.background.systemmanager.service.SystemMenuService;
import com.cy.shopmarket.common.pojo.Menu;
import com.cy.shopmarket.common.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("system/menu/")
public class SystemMenuController {
    @Autowired
    private SystemMenuService systemMenuService;

    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects() {
        List<Menu> menus = systemMenuService.doFindObjects();
        System.out.println(menus);
        return new JsonResult(menus);
    }

    @RequestMapping("doFindZtreeMenuNodes")
    public JsonResult doFindZtreeMenuNodes() {
        return new JsonResult(
                systemMenuService.findZtreeMenuNodes());
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(Menu entity) {
        System.out.println(entity);
        systemMenuService.doSaveObject(entity);
        return new JsonResult("save ok");
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(Menu entity) {
        System.out.println(entity);
        systemMenuService.doUpdateById(entity);
        return new JsonResult("update ok");
    }
    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        System.out.println(id);
        systemMenuService.doDeleteById(id);
        return new JsonResult("delete ok");
    }
}
