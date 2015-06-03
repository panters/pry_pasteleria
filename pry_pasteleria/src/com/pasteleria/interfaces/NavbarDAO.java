package com.pasteleria.interfaces;

import java.util.List;

import com.pasteleria.bean.Navbar;

/**
 * 
 * @author Pantera
 *
 */
public interface NavbarDAO {

	List<Navbar> getNavbar(int rol);
	List<Navbar> getNavbarChildren(int rol,int father);
	String getNavBarWithRol(int rol);
	
}
