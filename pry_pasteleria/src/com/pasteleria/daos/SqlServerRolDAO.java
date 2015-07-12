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
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		Rol rol=null;
		try {
			rol=(Rol) session.selectOne("rolxml.sql_find",bean.getIdRol());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return rol;
	}

	@Override
	public int create(Rol bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.insert("rolxml.sql_insert",bean);
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
	public int update(Rol bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.update("rolxml.sql_update",bean);
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
	public int delete(Rol bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.delete("rolxml.sql_delete",bean.getIdRol());
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
