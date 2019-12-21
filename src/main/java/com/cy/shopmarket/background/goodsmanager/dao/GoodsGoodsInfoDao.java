package com.cy.shopmarket.background.goodsmanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.shopmarket.common.pojo.GoodsInfo;


@Mapper
public interface GoodsGoodsInfoDao {
	/**
	 * 	修改商品
	 * @param goodsInfo
	 * @return	行数
	 */
	int updateGoodsObject(@Param("goodsInfo")GoodsInfo goodsInfo);
	
	/**
	 * 	添加商品
	 * @param goodsInfo
	 * @return	行数
	 */
	int insertGoodObject(@Param("goodsInfo")GoodsInfo goodsInfo,
						@Param("userId")Integer userId);
	
	/**
	 * 	根据id删除商品
	 * @param id
	 * @return 行数
	 */
	int deleteGoodById(@Param("id")Integer id);
	
	@Select("select count(*) from goods_info where is_exist=1")
	int getRowCount();
	
	/**
	 * 	查
	 */
	@Select
("select name,type_id,jpg,price,is_hot,user_id,createdtime from goods_info where is_exist=1")
	List<GoodsInfo> findGoodsObjects();
}
