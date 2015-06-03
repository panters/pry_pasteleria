package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Status;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.StatusDAO;
/**
 * 
 * @author Pantera
 *
 */
public class ServiceStatus implements StatusDAO{
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	StatusDAO dao=factory.getStatusDAO();

	
	
	@Override
	public List<Status> list() {
		return dao.list();
	}

	
}
