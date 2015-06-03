package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Rol;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.RolDAO;

public interface ServiceRol  {
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	RolDAO dao=factory.getRolDAO();


	public List<Rol> list();
	public Rol find(Rol bean);
	public int create(Rol bean);
	public int update(Rol bean);
	public int delete(Rol bean);

}
