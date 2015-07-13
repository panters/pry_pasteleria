package com.pasteleria.daos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Category;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.CategoryDAO;

public class SqlServerCategoryDAO implements CategoryDAO {
	
	SqlSessionFactory SQL_SESSION_FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<Category> list=null;
		try {
			list=session.selectList("categoryxml.sql_select");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return list;
	}

	@Override
	public Category find(Category bean) {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		Category category=null;
		try {
			category=(Category) session.selectOne("categoryxml.sql_find",bean.getIdCategoria());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return category;
	}

	@Override
	public int create(Category bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.insert("categoryxml.sql_insert",bean);
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
	public int update(Category bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.update("categoryxml.sql_update",bean);
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
	public int delete(Category bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.delete("categoryxml.sql_delete",bean.getIdCategoria());
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
