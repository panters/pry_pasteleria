package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Order;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.OrderDAO;

public interface ServiceOrder {
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	OrderDAO dao=factory.getOrderDAO();
	
	public List<Order> list();
	public Order find(Order bean);
	public String create(Order bean);
	public int update(Order bean);
	public int delete(Order bean);

}
