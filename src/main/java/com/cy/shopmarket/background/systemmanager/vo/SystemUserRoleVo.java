package com.cy.shopmarket.background.systemmanager.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SystemUserRoleVo implements Serializable {
	private static final long serialVersionUID = 4675280183847973227L;
	private Integer id;
	private String username;
	private String role;
	private String phone;
	private String addr;
	private String money;
	private String jpg;
}
