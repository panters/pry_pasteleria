package com.pasteleria.daos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Coverage;
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
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		Dough dough=null;
		try {
			dough=(Dough) session.selectOne("doughxml.sql_find",bean.getIdMasa());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return dough;
	}

	@Override
	public int create(Dough bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.insert("doughxml.sql_insert",bean);
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
	public int update(Dough bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.update("doughxml.sql_update",bean);
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
	public int delete(Dough bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.delete("doughxml.sql_delete",bean.getIdMasa());
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
