package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Order;

public class HasServiceOrder implements ServiceOrder {

	@Override
	public List<Order> list() {
		return dao.list();
	}
	@Override
	public List<Order> list(String id) {
		// TODO Auto-generated method stub
		return dao.list(id);
	}	

	@Override
	public Order find(Order bean) {
		return dao.find(bean);
	}

	@Override
	public String create(Order bean) {
		return dao.create(bean);
	}

	@Override
	public int update(Order bean) {
		return dao.update(bean);
	}

	@Override
	public int delete(Order bean) {
		return dao.delete(bean);
	}

}
