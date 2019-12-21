package com.cy.shopmarket.background.logmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.shopmarket.common.pojo.Log;
import com.cy.shopmarket.common.exception.ServiceException;
import com.cy.shopmarket.common.util.Assert;
import com.cy.shopmarket.background.logmanager.dao.LogLogDao;
import com.cy.shopmarket.background.logmanager.service.LogLogService;

@Service
public class LogLogServiceImpl implements LogLogService {
	@Autowired
	private LogLogDao logLogDao;

	@Override
	public int insertLogAddObject(Log log) {
		return logLogDao.insertLogAddObject(log);
	}
	
	@Override
	public List<Log> findLogObject(Integer operation_id) {
		//参数校验
		Assert.isValid(operation_id!=null&&operation_id>=1, "无效值");
		
		//查询日志记录
		List<Log> records = logLogDao.findLogObject(operation_id);
		return records;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		//检验
		Assert.isValid(ids!=null&&ids.length>0, "请先选择");
		int rows = logLogDao.deleteObjects(ids);
		if (rows==0) {
			throw new ServiceException("记录可能不存在了");
		}
		return rows;
	}

}
