package com.cy.shopmarket.common.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Menu implements Serializable {
	private static final long serialVersionUID = -2752722789528889059L;
	private Integer id;
	private String name;
	private Integer parentId;
	private String url;
	private String permissions;
}
