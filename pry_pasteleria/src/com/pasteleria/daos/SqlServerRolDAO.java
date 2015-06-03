package com.pasteleria.daos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Rol;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.RolDAO;

public class SqlServerRolDAO implements RolDAO {
	
	SqlSessionFactory SQL_SESSION_FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;

	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> list() {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<Rol> list=null;
		try {
			list=session.selectList("rolxml.sql_select");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return list;
	}

	@Override
	public Rol find(Rol bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Rol bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Rol bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Rol bean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
