package com.pasteleria.daos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Customer;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.CustomerDAO;

public class SqlServerCustomerDAO implements CustomerDAO {
	
	SqlSessionFactory SQL_SESSION_FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> list() {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<Customer> list=null;
		try {
			list=session.selectList("customerxml.sql_select");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return list;
	}

	@Override
	public Customer find(Customer bean) {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		Customer customer=null;
		try {
			customer=(Customer) session.selectOne("customerxml.sql_find",bean.getIdUsuario());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return customer;
	}

	@Override
	public int create(Customer bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.insert("customerxml.sql_insert",bean);
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
	public int update(Customer bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.update("customerxml.sql_update",bean);
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
	public int delete(Customer bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.delete("customerxml.sql_delete",bean.getIdUsuario());
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
