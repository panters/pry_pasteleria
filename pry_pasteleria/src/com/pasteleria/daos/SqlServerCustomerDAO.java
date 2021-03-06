package com.pasteleria.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Customer;
import com.pasteleria.bean.User;
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
	public Customer find(User bean) {
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
	public int register(String username, String apellidop, String apellidom,
			String documento, String nacimiento, String sexo, String email,
			String estadocivil, String telefono, String celular, String password) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username", username);
		map.put("apellidop", apellidop);
		map.put("apellidom", apellidom);
		map.put("documento", documento);
		map.put("nacimiento", nacimiento);
		map.put("sexo", sexo);
		map.put("email", email);
		map.put("estadocivil", estadocivil);
		map.put("telefono", telefono);
		map.put("celular", celular);
		map.put("password", password);
		
		try {
			salida=session.insert("customerxml.sql_register",map);
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

	@Override
	public int updatePassword(Customer bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.update("customerxml.sql_updatePassword",bean);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}

}
