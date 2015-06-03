package com.pasteleria.interfaces;

import java.util.List;

import com.pasteleria.bean.Coverage;

public interface CoverageDAO {
	
	public List<Coverage> list();
	public Coverage find(Coverage bean);
	public int create(Coverage bean);
	public int update(Coverage bean);
	public int delete(Coverage bean);
	
}
