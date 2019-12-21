package com.cy.shopmarket.common.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GoodsInfo implements Serializable {
	
	private static final long serialVersionUID = 3776790432173516423L;
	private Integer id;
	private String name;
	private Integer typeId;
	private String jpg;
	private Double price;
	private Integer isHot;
	private Integer userId;
	private Date createdtime;
	
}
