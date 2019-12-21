package com.cy.shopmarket.background.goodsmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.shopmarket.background.goodsmanager.dao.GoodsGoodsCarDao;
import com.cy.shopmarket.background.goodsmanager.service.GoodsGoodsCarService;
import com.cy.shopmarket.background.goodsmanager.vo.GoodsCarVo;
import com.cy.shopmarket.common.annotation.AddLoggingAnnotation;
import com.cy.shopmarket.common.config.PageProperties;
import com.cy.shopmarket.common.exception.ServiceException;
import com.cy.shopmarket.common.pojo.GoodsCar;
import com.cy.shopmarket.common.util.Assert;
import com.cy.shopmarket.common.vo.PageObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
@Service
public class GoodsGoodsCarServiceImpl implements GoodsGoodsCarService {

	@Autowired
	private GoodsGoodsCarDao goodsGoodsCarDao;
	@Autowired
	private PageProperties pageProperties;
	
	@AddLoggingAnnotation(operation = "修改购物车",operationId = 2)
	@Override
	public int updateCarObject(GoodsCar goodsCar) {
		Assert.isNull(goodsCar, "保存的对象不能为空!");
		int rows = goodsGoodsCarDao.updateCarObject(goodsCar);
		return rows;
	}
	
	@AddLoggingAnnotation(operation = "添加购物车",operationId = 3)
	@Override
	public int insertCarObject(GoodsCar goodsCar) {
		Assert.isNull(goodsCar, "保存的对象不能为空!");
		int rows = goodsGoodsCarDao.insertCarObject(goodsCar);
		
		if(rows==0) 
			throw new ServiceException("添加失败");
		return rows;
	}
	
	@Transactional(timeout = 20,
            readOnly = false,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Throwable.class,
            propagation = Propagation.REQUIRED)
	@AddLoggingAnnotation(operation = "删除购物车",operationId = 4)
	@Override
	public int deleteCarById(Integer id) {
		Assert.isValid(id!=null&&id>0, "请选择!");
		int rows = goodsGoodsCarDao.deleteCarByGoodId(id);
		return rows;
	}
	
	@AddLoggingAnnotation(operation = "其他操作")
	@Override
	public PageObject<GoodsCarVo> findPageObjects(
			String username, Integer pageCurrent){
		//1.参数校验
		Assert.isValid(pageCurrent!=null&&pageCurrent>=1, "页码值无效");
		//2.设置查询起始位置
		int pageSize=pageProperties.getPageSize();
		Page<GoodsCar> page=
		PageHelper.startPage(pageCurrent,pageSize);
		//3.查询当前页日志记录
		List<GoodsCarVo> records=goodsGoodsCarDao.findCarObjects(username);
		return new PageObject<GoodsCarVo>(records, (int)page.getTotal(), pageCurrent, pageSize);
	} 
}
