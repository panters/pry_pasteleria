package com.pasteleria.interfaces;

import java.util.List;

import com.pasteleria.bean.Product;
/**
 * 
 * @author Pantera
 *
 */
public interface ProductDAO {

	public List<Product> list(boolean catalogo);
	public Product find(Product bean);
	public int create(Product bean);
	public int update(Product bean);
	public int delete(Product bean);
	public List<Product> filter(int idcategoria,int idcobertura,int idmasa,int idrelleno);
}
