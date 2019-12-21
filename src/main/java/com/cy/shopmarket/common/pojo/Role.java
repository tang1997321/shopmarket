package com.cy.shopmarket.common.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {
	private static final long serialVersionUID = -6575025057510181975L;
	private Integer id;
	private String name;
	private String note;
}
