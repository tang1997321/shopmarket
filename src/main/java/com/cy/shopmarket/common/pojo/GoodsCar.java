package com.cy.shopmarket.common.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsCar implements Serializable {
	
	private static final long serialVersionUID = 4160184898669847691L;
	
	private Integer id;
	private Integer userId;
	private Integer goodsId;
	private Integer iscommit;
	public GoodsCar() {}
	public GoodsCar(Integer userId, Integer goodsId, Integer iscommit) {
		super();
		this.userId = userId;
		this.goodsId = goodsId;
		this.iscommit = iscommit;
	}
	
}
