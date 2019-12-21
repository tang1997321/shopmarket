package com.cy.shopmarket.common.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class RoleMenu implements Serializable {
	
	private static final long serialVersionUID = -8558994828339221535L;
	private Integer id;
	private Integer roleId;
	private Integer menuId;
	
}
