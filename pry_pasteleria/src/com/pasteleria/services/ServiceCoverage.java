package com.pasteleria.services;

import java.util.List;

import com.pasteleria.bean.Coverage;
import com.pasteleria.factory.Factory;
import com.pasteleria.interfaces.CoverageDAO;
/**
 * 
 * @author Pantera
 *
 */
public class ServiceCoverage implements CoverageDAO {
	
	Factory factory=Factory.getTipo(Factory.TIPO_SQLSERVER);
	CoverageDAO dao=factory.getCoverageDAO();
	
	@Override
	public List<Coverage> list() {
		return dao.list();
	}

	@Override
	public Coverage find(Coverage bean) {
		return dao.find(bean);
	}

	@Override
	public int create(Coverage bean) {
		return dao.create(bean);
	}

	@Override
	public int update(Coverage bean) {
		return dao.update(bean);
	}

	@Override
	public int delete(Coverage bean) {
		return dao.delete(bean);
	}

}
