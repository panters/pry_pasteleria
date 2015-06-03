package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Product;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.ProductDAO;

public class ServiceProduct implements ProductDAO {
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	ProductDAO dao=factory.getProductDAO();

	@Override
	public List<Product> list() {
		return dao.list();
	}

	@Override
	public Product find(Product bean) {
		return dao.find(bean);
	}

	@Override
	public int create(Product bean) {
		return dao.create(bean);
	}

	@Override
	public int update(Product bean) {
		return dao.update(bean);
	}

	@Override
	public int delete(Product bean) {
		return dao.delete(bean);
	}

	@Override
	public List<Product> filter(int idcategoria, int idcobertura, int idmasa, int idrelleno) {
		return dao.filter(idcategoria, idcobertura, idmasa, idrelleno);
	}

}
