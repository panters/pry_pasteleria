package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Employed;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.EmployedDAO;

public class ServiceEmployed implements EmployedDAO {
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	EmployedDAO dao=factory.getEmployedDAO();

	@Override
	public List<Employed> list() {
		return dao.list();
	}

	@Override
	public Employed find(Employed bean) {
		return dao.find(bean);
	}

	@Override
	public int create(Employed bean) {
		return dao.create(bean);
	}

	@Override
	public int update(Employed bean) {
		return dao.update(bean);
	}

	@Override
	public int delete(Employed bean) {
		return dao.delete(bean);
	}

}
