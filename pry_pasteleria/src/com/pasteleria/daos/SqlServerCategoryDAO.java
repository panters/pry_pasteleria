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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Category bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Category bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Category bean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
