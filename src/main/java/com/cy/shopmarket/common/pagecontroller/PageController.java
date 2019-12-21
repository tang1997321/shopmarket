
package com.cy.shopmarket.common.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/admin")
	public String doGoodsUI() {
		return "starter";
	}
	
	@RequestMapping("/admin/{module}/{moduleUI}")
	public String doModuleUI(@PathVariable String moduleUI) {
		return "admin/" + moduleUI;
	}

	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
}
