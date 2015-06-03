package com.pasteleria.interfaces;

import java.util.List;

import com.pasteleria.bean.Filling;
/**
 * 
 * @author Pantera
 *
 */
public interface FillingDAO {

	public List<Filling> list();
	public Filling find(Filling bean);
	public int create(Filling bean);
	public int update(Filling bean);
	public int delete(Filling bean);
}
