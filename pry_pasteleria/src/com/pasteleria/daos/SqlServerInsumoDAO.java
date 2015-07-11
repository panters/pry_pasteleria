package com.pasteleria.daos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Insumo;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.InsumoDAO;

public class SqlServerInsumoDAO implements InsumoDAO {
	
	SqlSessionFactory SQL_SESSION_FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;


	@SuppressWarnings("unchecked")
	@Override
	public List<Insumo> list() {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<Insumo> list=null;
		try {
			list=session.selectList("insumoxml.sql_select");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return list;
	}

	@Override
	public Insumo find(Insumo bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Insumo bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Insumo bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Insumo bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Insumo> filter(int idcategoria, int idcobertura, int idmasa,
			int idrelleno) {
		// TODO Auto-generated method stub
		return null;
	}

}
