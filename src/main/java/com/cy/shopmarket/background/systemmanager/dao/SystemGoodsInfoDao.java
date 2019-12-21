package com.cy.shopmarket.background.systemmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemGoodsInfoDao {
	//根据用户id查询商品id
	List<Integer> doFindObjectsByUserId(@Param("userId") Integer userId);
	//基于用户id删除商品信息
	int doDeleteByUserId(Integer id);
}
