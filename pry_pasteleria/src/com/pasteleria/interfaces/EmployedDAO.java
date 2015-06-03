package com.pasteleria.interfaces;

import java.util.List;

import com.pasteleria.bean.Employed;;

public interface EmployedDAO {

	public List<Employed> list();
	public Employed find(Employed bean);
	public int create(Employed bean);
	public int update(Employed bean);
	public int delete(Employed bean);
}
