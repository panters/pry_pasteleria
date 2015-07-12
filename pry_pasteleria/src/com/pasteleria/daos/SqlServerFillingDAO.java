package com.pasteleria.daos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Coverage;
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
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		Filling filling=null;
		try {
			filling=(Filling) session.selectOne("fillingxml.sql_find",bean.getIdRelleno());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return filling;
	}

	@Override
	public int create(Filling bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.insert("fillingxml.sql_insert",bean);
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
	public int update(Filling bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.update("fillingxml.sql_update",bean);
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
	public int delete(Filling bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.delete("fillingxml.sql_delete",bean.getIdRelleno());
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
