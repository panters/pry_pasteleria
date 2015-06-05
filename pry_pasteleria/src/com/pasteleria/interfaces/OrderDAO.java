package com.pasteleria.interfaces;

import java.util.List;

import com.pasteleria.bean.Order;

public interface OrderDAO {

	public List<Order> list();
	public List<Order> list(String id);
	public Order find(Order bean);
	public String create(Order bean);
	public int update(Order bean);
	public int delete(Order bean);
	
}
