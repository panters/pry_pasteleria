package com.pasteleria.interfaces;

import java.util.List;

import com.pasteleria.bean.Customer;

public interface CustomerDAO {
	
	public List<Customer> list();
	public Customer find(Customer bean);
	public int create(Customer bean);
	public int update(Customer bean);
	public int delete(Customer bean);
}
