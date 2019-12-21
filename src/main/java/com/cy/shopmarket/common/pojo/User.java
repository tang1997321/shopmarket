package com.cy.shopmarket.common.pojo;

import lombok.Data;

@Data
public class User {
	private Integer id;
	private String username;
	private String password;
	private String phone;
	private String salt;
	private String addr;
	private Double money;
	private String jpg;
}
