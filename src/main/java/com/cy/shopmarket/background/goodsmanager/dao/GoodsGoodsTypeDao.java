package com.cy.shopmarket.background.goodsmanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.shopmarket.common.pojo.GoodsType;

/**
 *	分类
 */
@Mapper
public interface GoodsGoodsTypeDao {
	
	int updateTypeOjbect(@Param("goodsType") GoodsType goodsType);
	
	int insertTypeObject(@Param("goodsType") GoodsType goodsType);
	
	int deleteTypeById(@Param("id") Integer id);
	
	@Select("select * from goods_type")
	List<GoodsType> findTypeObjects(@Param("username") String username);
}
