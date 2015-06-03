package com.pasteleria.daos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Filling;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.FillingDAO;

public class SqlServerFillingDAO implements FillingDAO {

	SqlSessionFactory SQL_SESSION_FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Filling> list() {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<Filling> list=null;
		try {
			list=session.selectList("fillingxml.sql_select");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return list;
	}

	@Override
	public Filling find(Filling bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Filling bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Filling bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Filling bean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
