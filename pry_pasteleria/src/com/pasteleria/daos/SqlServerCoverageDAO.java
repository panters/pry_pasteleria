package com.pasteleria.daos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Coverage;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.CoverageDAO;

public class SqlServerCoverageDAO implements CoverageDAO {
	
	SqlSessionFactory SQL_SESSION_FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;

	@SuppressWarnings("unchecked")
	@Override
	public List<Coverage> list() {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<Coverage> list=null;
		try {
			list=session.selectList("coveragexml.sql_select");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return list;
	}

	@Override
	public Coverage find(Coverage bean) {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		Coverage coverage=null;
		try {
			coverage=(Coverage) session.selectOne("coveragexml.sql_find",bean.getIdCobertura());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return coverage;
	}

	@Override
	public int create(Coverage bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.insert("coveragexml.sql_insert",bean);
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
	public int update(Coverage bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.update("coveragexml.sql_update",bean);
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
	public int delete(Coverage bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.delete("coveragexml.sql_delete",bean.getIdCobertura());
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
