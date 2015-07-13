package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Insumo;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.InsumoDAO;

public class ServiceInsumo implements InsumoDAO{
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	InsumoDAO dao=factory.getInsumoDAO();

	@Override
	public List<Insumo> list() {
		return dao.list();
	}

	@Override
	public Insumo find(Insumo bean) {
		return dao.find(bean);
	}

	@Override
	public int create(Insumo bean) {
		return dao.create(bean);
	}

	@Override
	public int update(Insumo bean) {
		return dao.update(bean);
	}

	@Override
	public int delete(Insumo bean) {
		return dao.delete(bean);
	}



	
}
