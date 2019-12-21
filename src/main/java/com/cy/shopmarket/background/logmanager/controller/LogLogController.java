package com.cy.shopmarket.background.logmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.shopmarket.background.goodsmanager.vo.JsonResult;
import com.cy.shopmarket.background.logmanager.service.LogLogService;


@RestController
@RequestMapping("/admin/")
public class LogLogController {
	@Autowired
	private LogLogService logLogService;
	//查询
	@RequestMapping("dologList")
	public JsonResult doFindPageObjects(
			Integer operationId) {
		
		return new JsonResult(logLogService.findLogObject(operationId));
	}
	//删除
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer...ids) {
		logLogService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}
	
}