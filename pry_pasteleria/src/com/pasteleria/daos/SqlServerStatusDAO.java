package com.pasteleria.daos;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Status;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.StatusDAO;

public class SqlServerStatusDAO implements StatusDAO {
	
	SqlSessionFactory FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Status> list() {
		
		SqlSession session=FACTORY.openSession();
		List<Status> list=null;
		try 
		{
			list=(List<Status>)session.selectList("statusxml.sql_select");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return list;
	}

}
