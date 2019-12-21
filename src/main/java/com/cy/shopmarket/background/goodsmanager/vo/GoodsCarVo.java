package com.cy.shopmarket.background.goodsmanager.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class
GoodsCarVo implements Serializable{
	private static final long serialVersionUID = -6597576584012487094L;
	private Integer id;//商品id
	private String jpg;//商品图片路径
	private Double price;//价格
	private String name;//商品名
	private String username;
}
