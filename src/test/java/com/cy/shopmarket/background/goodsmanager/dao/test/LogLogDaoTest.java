package com.cy.shopmarket.background.goodsmanager.dao.test;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.shopmarket.background.logmanager.dao.LogLogDao;
import com.cy.shopmarket.common.pojo.Log;

@SpringBootTest
public class LogLogDaoTest {

	@Autowired(required = false)
	private LogLogDao logLogDao;
	
	@Test
	public void logFindObjectTest() {
		List<Log> list = logLogDao.findLogObject(1);
		list.forEach(a->System.out.println(a));
	}
	
	@Test
	public void logDeleteTest() {
		
		int rows = logLogDao.deleteObjects(1,2);
		System.out.println(rows);
	}
	
	@Test
	public void add() {
		Log l = new Log();
		l.setUsername("admin");
		l.setOperation("查询");
		l.setMethod("lsdjfl");
		l.setParam("add");
		l.setTime(3L);
		l.setIp("176.61.30.180");
		l.setCreatetime(new Date());
		l.setOperationId(1);
		int rows = logLogDao.insertLogAddObject(l);
		System.out.println(rows);
	}
}
