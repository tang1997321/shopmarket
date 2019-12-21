package com.cy.shopmarket.background.logmanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.shopmarket.common.pojo.Log;
@Mapper
public interface LogLogDao {

	/**
	 * 	切面添加日志
	 * @param log
	 * @return
	 */
	int insertLogAddObject(Log log);
	
	/**
	 * 基于条件查询所有的日志
	 * @return
	 */

	List<Log> findLogObject(Integer operationId);

	/**
	 * 基于记录id执行删除业务
	 * @param ids
	 * @return rows
	 */
	int deleteObjects(@Param("ids")Integer...ids);
}
