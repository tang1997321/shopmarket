
package com.cy.shopmarket.background.goodsmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodsPageController {
	@RequestMapping("/admin")
	public String doGoodsUI() {
		return "admin/admin-index";
	}
	
	@RequestMapping("/admin/{module}")
	public String doModuleUI(@PathVariable String module) {
		return "admin/" + module;
	}
	
	@RequestMapping("/doPage")
	 public String doPageUI() {
		 return "common/page";
	 }
}
