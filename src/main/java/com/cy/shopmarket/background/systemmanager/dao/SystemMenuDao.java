package com.cy.shopmarket.background.systemmanager.dao;

import com.cy.shopmarket.common.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemMenuDao {
	Menu doFindObjectById(Integer id);
	
	List<Menu> doFindObjectById();
	
	int doSaveObject(@Param("entity") Menu entity);
	
	int doUpdateObject(@Param("entity") Menu entity);
	
	int doDeleteObjectById(Integer id);
}
