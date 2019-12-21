package com.cy.shopmarket.background.goodsmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.shopmarket.common.pojo.GoodsInfo;
import com.cy.shopmarket.background.goodsmanager.service.GoodsGoodsInfoService;
import com.cy.shopmarket.common.vo.JsonResult;

@RestController
@RequestMapping("goods/info/")
public class GoodsGoodsInfoController {

	@Autowired
	private GoodsGoodsInfoService goodsGoodsInfoService;
	
	//改
	@RequestMapping("doUpdateGoodsObject")
	public JsonResult updateGoodsObject(GoodsInfo goodsInfo) {
		goodsGoodsInfoService.updateGoodsObject(goodsInfo);
		return new JsonResult("更新成功");
	}
	
	//增
	@RequestMapping("doInsertGoodObject")
	public JsonResult insertGoodObject(GoodsInfo goodsInfo) {
		goodsGoodsInfoService.insertGoodObject(goodsInfo);
		return new JsonResult("添加成功");
	}
	
	//删
	@RequestMapping("doDeleteGoodById")
	public JsonResult deleteGoodById(Integer id) {
		goodsGoodsInfoService.deleteGoodById(id);
		return new JsonResult("删除成功");
	}
	
	//查
	@RequestMapping("doFindObjects")
	public JsonResult findGoodsObjects(String username, Integer pageCurrent) {
		return new JsonResult(goodsGoodsInfoService.findGoodsObjects(username,pageCurrent));
	}
}
