package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Customer;
import com.pasteleria.bean.User;
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
	public Customer find(User bean) {
		return dao.find(bean);
	}

	@Override
	public int create(Customer bean) {
		return dao.create(bean);
	}
	
	@Override
	public int register(String username, String apellidop, String apellidom,
			String documento, String nacimiento, String sexo, String email,
			String estadocivil, String telefono, String celular, String password) {
		return dao.register(username, apellidop, apellidom, documento, nacimiento, sexo, email, estadocivil, telefono, celular, password);
	}

	@Override
	public int update(Customer bean) {
		return dao.update(bean);
	}

	@Override
	public int delete(Customer bean) {
		return dao.delete(bean);
	}

	@Override
	public int updatePassword(Customer bean) {
		return dao.updatePassword(bean);
	}

}
