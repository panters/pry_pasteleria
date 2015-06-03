package com.pasteleria.interfaces;

import java.util.List;

import com.pasteleria.bean.Rol;

public interface RolDAO {

	public List<Rol> list();
	public Rol find(Rol bean);
	public int create(Rol bean);
	public int update(Rol bean);
	public int delete(Rol bean);
}
