package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Navbar;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.NavbarDAO;
/**
 * 
 * @author Pantera
 *
 */
public class ServiceNavbar implements NavbarDAO{
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	NavbarDAO dao=factory.getNavbarDAO();
	
	
	@Override
	public List<Navbar> getNavbar(int rol) {
		return dao.getNavbar(rol);
	}

	@Override
	public List<Navbar> getNavbarChildren(int rol,int father) {
		return dao.getNavbarChildren(rol,father);
	}
	
	@Override
	public String getNavBarWithRol(int rol) {
		return dao.getNavBarWithRol(rol);
	}

	
}
