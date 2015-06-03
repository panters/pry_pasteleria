package com.pasteleria.interfaces;

import java.util.List;

import com.pasteleria.bean.Dough;
/**
 * 
 * @author Pantera
 *
 */
public interface DoughDAO {

	public List<Dough> list();
	public Dough find(Dough bean);
	public int create(Dough bean);
	public int update(Dough bean);
	public int delete(Dough bean);
}
