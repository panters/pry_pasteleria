package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Dough;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.DoughDAO;
/**
 * 
 * @author Pantera
 *
 */
public class ServiceDough implements DoughDAO {
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	DoughDAO dao=factory.getDoughDAO();
	
	@Override
	public List<Dough> list() {
		return dao.list();
	}

	@Override
	public Dough find(Dough bean) {
		return dao.find(bean);
	}

	@Override
	public int create(Dough bean) {
		return dao.create(bean);
	}

	@Override
	public int update(Dough bean) {
		return dao.update(bean);
	}

	@Override
	public int delete(Dough bean) {
		return dao.delete(bean);
	}

}
