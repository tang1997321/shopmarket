package com.cy.shopmarket.background.logmanager.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cy.shopmarket.common.pojo.Log;


public interface LogLogService {
	
	int insertLogAddObject(Log log);
	
	List<Log> findLogObject(Integer operationId);
	
	int deleteObjects(@Param("ids")Integer...ids);
}
