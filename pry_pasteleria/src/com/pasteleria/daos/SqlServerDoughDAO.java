package com.pasteleria.daos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Dough;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.DoughDAO;

public class SqlServerDoughDAO implements DoughDAO {
	
	SqlSessionFactory SQL_SESSION_FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Dough> list() {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<Dough> list=null;
		try {
			list=session.selectList("doughxml.sql_select");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public Dough find(Dough bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Dough bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Dough bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Dough bean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
