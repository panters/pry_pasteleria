package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Filling;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.FillingDAO;
/**
 * 
 * @author Pantera
 *
 */
public class ServiceFilling implements FillingDAO {
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	FillingDAO dao=factory.getFillingDAO();
	
	@Override
	public List<Filling> list() {
		return dao.list();
	}

	@Override
	public Filling find(Filling bean) {
		return dao.find(bean);
	}

	@Override
	public int create(Filling bean) {
		return dao.create(bean);
	}

	@Override
	public int update(Filling bean) {
		return dao.update(bean);
	}

	@Override
	public int delete(Filling bean) {
		return dao.delete(bean);
	}

}
