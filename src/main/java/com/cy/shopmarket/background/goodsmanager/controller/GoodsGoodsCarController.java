package com.cy.shopmarket.background.goodsmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.shopmarket.background.goodsmanager.service.GoodsGoodsCarService;
import com.cy.shopmarket.common.vo.JsonResult;

@RestController
@RequestMapping("goods/car/")
public class GoodsGoodsCarController {

	@Autowired
	private GoodsGoodsCarService goodsGoodsCarService;
	/*
	 * //改
	 * 
	 * @RequestMapping("doUpdateGoodsObject") public JsonResult
	 * updateGoodsObject(GoodsCar goodsCar) {
	 * goodsGoodsCarService.updateCarObject(goodsCar); return new
	 * JsonResult("更新成功"); }
	 * 
	 * //增
	 * 
	 * @RequestMapping("doInsertGoodObject") public JsonResult
	 * insertGoodObject(GoodsCar goodsCar) {
	 * goodsGoodsCarService.insertCarObject(goodsCar); return new
	 * JsonResult("添加成功"); }
	 */
	
	//删
	@RequestMapping("doDeleteObject")
	public JsonResult deleteGoodById(Integer id) {
		goodsGoodsCarService.deleteCarById(id);
		return new JsonResult("删除成功");
	}
	
	//查
	@RequestMapping("doGoodsCarObjects")
	public JsonResult findGoodsObjects(String username, Integer pageCurrent) {
		return new JsonResult(goodsGoodsCarService.findPageObjects(username,pageCurrent));
	}
}
