package com.cy.shopmarket.background.goodsmanager.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class GoodsInfoVo implements Serializable {

    private static final long serialVersionUID = -7007175004893301396L;
    private Integer id;
    private String name;
    private Integer typeId;
    private String jpg;
    private Double price;
    private Integer isHot;
    private String userId;
    private Date createdtime;
}
