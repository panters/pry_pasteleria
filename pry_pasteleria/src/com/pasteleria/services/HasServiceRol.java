package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Rol;

public class HasServiceRol implements ServiceRol {

	@Override
	public List<Rol> list() {
		return dao.list();
	}

	@Override
	public Rol find(Rol bean) {
		return dao.find(bean);
	}

	@Override
	public int create(Rol bean) {
		return dao.create(bean);
	}

	@Override
	public int update(Rol bean) {
		return dao.update(bean);
	}

	@Override
	public int delete(Rol bean) {
		return dao.delete(bean);
	}

}
