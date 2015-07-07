package com.pasteleria.services;

import com.pasteleria.bean.User;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.UserDAO;

public class ServiceUser implements UserDAO {
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	UserDAO dao=factory.getUserDAO();

	
	@Override
	public User find(String login, String pasword) {
		return dao.find(login, pasword);
	}


	@Override
	public User find(String login) {
		return dao.find(login);
	}

}
