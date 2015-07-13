package com.pasteleria.interfaces;

import java.util.List;

import com.pasteleria.bean.Insumo;;


public interface InsumoDAO {

	public List<Insumo> list();
	public Insumo find(Insumo bean);
	public int create(Insumo bean);
	public int update(Insumo bean);
	public int delete(Insumo bean);
	
}
