package com.pasteleria.interfaces;

import java.util.List;

import com.pasteleria.bean.OrderDetail;
import com.pasteleria.factory.Factory;

public interface OrderDetailDAO {

	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	OrderDetailDAO dao=factory.getOrderDetailDAO();
	
	public List<OrderDetail> list(String id);
	public OrderDetail find(OrderDetail bean);
	public int create(OrderDetail bean);
	public int createfromList(String idPedido,List<OrderDetail> details);
	public int update(String idPedido,int i, int idEstado);
	public int delete(OrderDetail bean);
	
}
