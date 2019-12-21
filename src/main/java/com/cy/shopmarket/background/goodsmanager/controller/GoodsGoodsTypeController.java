package com.cy.shopmarket.background.goodsmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.shopmarket.common.pojo.GoodsType;
import com.cy.shopmarket.background.goodsmanager.service.GoodsGoodsTypeService;
import com.cy.shopmarket.common.vo.JsonResult;

@RestController
@RequestMapping("goods/type/")
public class GoodsGoodsTypeController {

	@Autowired
	private GoodsGoodsTypeService goodsGoodsTypeService;
	//改
	@RequestMapping("doUpdateTypeOjbect")
	public JsonResult insertTypeObject(GoodsType goodsType) {
		return new JsonResult(goodsGoodsTypeService.insertTypeObject(goodsType));
	}
	//增
	@RequestMapping("doInsertTypeObject")
	public JsonResult updateTypeOjbect(GoodsType goodsType) {
		return new JsonResult(goodsGoodsTypeService.updateTypeOjbect(goodsType));
	}
	//删
	@RequestMapping("doDeleteTypeById")
	public JsonResult deleteTypeById(Integer id) {
		goodsGoodsTypeService.deleteTypeById(id);
		return new JsonResult("删除成功");
	}
	//查
	@RequestMapping("doFindPageObjects")
	public JsonResult findTypeObjects(String username, Integer pageCurrent) {
		return new JsonResult(goodsGoodsTypeService.findTypeObjects(username,pageCurrent));
	}
}
