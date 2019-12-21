package com.cy.shopmarket.background.systemmanager.dao;

import com.cy.shopmarket.background.systemmanager.vo.CheckBox;
import com.cy.shopmarket.common.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SystemRoleDao {

	List<Role> doFindObjectById();

	Role doFindObjectById(Integer id);

	int doDeleteById(Integer id);

	int doUpdateById(@Param("entity") Role entity);

	int doSaveObject(@Param("entity") Role entity);

	int doGetRowCounts(@Param("name") String name);

	List<Role> doFindObjects(String name);

	@Select("select id,name from role")
	List<CheckBox> findObjects();

}