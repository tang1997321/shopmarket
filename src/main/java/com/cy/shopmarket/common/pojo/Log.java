package com.cy.shopmarket.common.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Log implements Serializable {
	
	private static final long serialVersionUID = -66712378480046517L;
	private Integer id;
	private String username;
	private String operation;
	private String method;
	private String param;
	private Long time;
	private String ip;
	private Date createtime;
	
	private Integer operationId;
	//登录日志为1
	//修改日志为2
	//添加日志为3
	//删除日志为4
	//其他日志为5
}
