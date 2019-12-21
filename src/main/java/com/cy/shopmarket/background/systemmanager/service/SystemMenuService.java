package com.cy.shopmarket.background.systemmanager.service;

import com.cy.shopmarket.background.systemmanager.vo.SystemNodeVo;
import com.cy.shopmarket.common.pojo.Menu;

import java.util.List;

public interface SystemMenuService {
	Menu doFindObjectById(Integer id);
	
	List<Menu> doFindObjects();
	
	int doSaveObject(Menu entity);
	
	int doUpdateById(Menu entity);
	
	int doDeleteById(Integer id);

	List<SystemNodeVo> findZtreeMenuNodes();

}
