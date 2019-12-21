package com.cy.shopmarket.common.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRole implements Serializable {
	
	private static final long serialVersionUID = -8155991979102455713L;
	private Integer id;
	private Integer userId;
	private Integer roleId;
	
}
