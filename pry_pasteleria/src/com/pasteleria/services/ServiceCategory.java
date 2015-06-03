package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Category;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.CategoryDAO;
/**
 * 
 * @author Pantera
 *
 */
public class ServiceCategory implements CategoryDAO {
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	CategoryDAO dao=factory.getCategoryDAO();

	@Override
	public List<Category> list() {
		return dao.list();
	}

	@Override
	public Category find(Category bean) {
		return dao.find(bean);
	}

	@Override
	public int create(Category bean) {
		return dao.create(bean);
	}

	@Override
	public int update(Category bean) {
		return dao.update(bean);
	}

	@Override
	public int delete(Category bean) {
		return dao.delete(bean);
	}

}
