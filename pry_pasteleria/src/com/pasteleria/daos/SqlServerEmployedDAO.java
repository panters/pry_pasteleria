package com.pasteleria.daos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Employed;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.EmployedDAO;

public class SqlServerEmployedDAO implements EmployedDAO {
	
	SqlSessionFactory SQL_SESSION_FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employed> list() {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<Employed> list=null;
		try {
			list=session.selectList("employedxml.sql_select");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return list;
	}

	@Override
	public Employed find(Employed bean) {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		Employed employed=null;
		try {
			employed=(Employed) session.selectOne("employedxml.sql_find",bean.getIdUsuario());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return employed;
	}

	@Override
	public int create(Employed bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.insert("employedxml.sql_insert",bean);
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
	public int update(Employed bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.update("employedxml.sql_update",bean);
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
	public int delete(Employed bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.delete("employedxml.sql_delete",bean.getIdUsuario());
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
