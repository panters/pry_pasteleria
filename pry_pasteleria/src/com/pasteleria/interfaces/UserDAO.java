package com.pasteleria.interfaces;


import com.pasteleria.bean.User;

public interface UserDAO {

	public User find(String login,String pasword);
	public User find(String login);
}
