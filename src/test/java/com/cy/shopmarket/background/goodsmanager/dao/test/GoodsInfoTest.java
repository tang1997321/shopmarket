package com.cy.shopmarket.background.goodsmanager.dao.test;

import java.util.List;

import com.cy.shopmarket.background.goodsmanager.dao.GoodsGoodsInfoDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.shopmarket.common.pojo.GoodsInfo;
import com.cy.shopmarket.background.goodsmanager.dao.GoodsGoodsCarDao;
import com.cy.shopmarket.background.goodsmanager.vo.GoodsCarVo;

@SpringBootTest
public class GoodsInfoTest {
	
	@Autowired
	private GoodsGoodsInfoDao goodsGoodsInfoDao;
	@Autowired
	private GoodsGoodsCarDao goodsGoodsCarDao;
	

	@Test
	public void findGoodsOjbectsTest() {
		List<GoodsInfo> list = goodsGoodsInfoDao.findGoodsObjects();
		list.forEach(a->System.out.println(a));
	}
	
	@Test
	public void deleteGoodById() {
		int rows = goodsGoodsInfoDao.deleteGoodById(2);
		System.out.println(rows);
	}
	
	@Test
	public void getRowCouont() {
		int rows = goodsGoodsInfoDao.getRowCount();
		System.out.println(rows);
	}
	
	@Test
	public void findCarObject() {
		List<GoodsCarVo> list = goodsGoodsCarDao.findCarObjects();
		list.forEach(a->System.out.println(a));
	}
	

}
