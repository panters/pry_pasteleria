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
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		Insumo list=null;
		try {
			list=(Insumo)session.selectOne("insumoxml.sql_find",bean.getIdinsumo());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return list;
	}

	@Override
	public int create(Insumo bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.insert("insumoxml.sql_insert",bean);
			session.commit();
			System.out.println(salida);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}

	@Override
	public int update(Insumo bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.update("insumoxml.sql_update",bean);
			session.commit();
			System.out.println(salida);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}

	@Override
	public int delete(Insumo bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.delete("insumoxml.sql_delete",bean.getIdinsumo());
			session.commit();
			System.out.println(salida);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}

	

}
