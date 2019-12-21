package com.cy.shopmarket.background.goodsmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.shopmarket.common.pojo.GoodsCar;
import com.cy.shopmarket.background.goodsmanager.service.GoodsGoodsCarService;
import com.cy.shopmarket.background.goodsmanager.vo.JsonResult;

@RestController
@RequestMapping("")
public class GoodsGoodsCarController {

	@Autowired
	private GoodsGoodsCarService goodsGoodsCarService;
	
	//改
	@RequestMapping("doUpdateGoodsObject")
	public JsonResult updateGoodsObject(GoodsCar goodsCar) {
		goodsGoodsCarService.updateCarObject(goodsCar);
		return new JsonResult("更新成功");
	}
	
	//增
	@RequestMapping("doInsertGoodObject")
	public JsonResult insertGoodObject(GoodsCar goodsCar) {
		goodsGoodsCarService.insertCarObject(goodsCar);
		return new JsonResult("添加成功");
	}
	
	//删
	@RequestMapping("doDeleteGoodById")
	public JsonResult deleteGoodById(Integer id) {
		goodsGoodsCarService.deleteCarById(id);
		return new JsonResult("删除成功");
	}
	
	//查
	@RequestMapping("doGoodsList")
	public JsonResult findGoodsObjects() {
		return new JsonResult(goodsGoodsCarService.findCarObjects());
	}
}
