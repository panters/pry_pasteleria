package com.pasteleria.daos;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.User;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.UserDAO;

public class SqlServerUserDAO implements UserDAO {
	
	SqlSessionFactory FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;

	@Override
	public User find(String login, String pasword) {
		
		SqlSession session=FACTORY.openSession();
		User user=null;
		try {
			Map<String, String> map=new HashMap<String,String>();
			map.put("login",login);
			map.put("password", pasword);
			user=(User) session.selectOne("userxml.sql_find",map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return user;
	}

}
