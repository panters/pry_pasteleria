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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Insumo bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Insumo bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Insumo bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Insumo> filter(int idcategoria, int idcobertura, int idmasa,
			int idrelleno) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
