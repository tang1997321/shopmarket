package com.cy.shopmarket.common.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsType implements Serializable {
	
	private static final long serialVersionUID = -5400275040910527512L;
	private Integer id;
	private String name;
	private Integer parentId;
	
	
}
