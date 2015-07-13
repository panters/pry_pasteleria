package com.pasteleria.interfaces;

import java.util.List;

import com.pasteleria.bean.Customer;
import com.pasteleria.bean.User;

public interface CustomerDAO {
	
	public List<Customer> list();
	public Customer find(User bean);
	public int updatePassword(Customer bean);
	public int create(Customer bean);
	public int register(String username,String apellidop,String apellidom,String documento,String nacimiento,String sexo,String email,String estadocivil,String telefono,String celular,String password);
	public int update(Customer bean);
	public int delete(Customer bean);
}
