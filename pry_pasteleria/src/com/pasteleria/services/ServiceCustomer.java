package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Customer;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.CustomerDAO;

public class ServiceCustomer implements CustomerDAO {
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	CustomerDAO dao=factory.getCustomerDAO();

	@Override
	public List<Customer> list() {
		return dao.list();
	}

	@Override
	public Customer find(Customer bean) {
		return dao.find(bean);
	}

	@Override
	public int create(Customer bean) {
		return dao.create(bean);
	}

	@Override
	public int update(Customer bean) {
		return dao.update(bean);
	}

	@Override
	public int delete(Customer bean) {
		return dao.delete(bean);
	}

}
