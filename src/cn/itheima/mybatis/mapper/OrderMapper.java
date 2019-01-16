package cn.itheima.mybatis.mapper;

import java.util.List;

import cn.itheima.mybatis.pojo.Order;

public interface OrderMapper {
	public List<Order> selectOrdersList();
	
	// 一对一查询
	public List<Order> selectOrders();
}
