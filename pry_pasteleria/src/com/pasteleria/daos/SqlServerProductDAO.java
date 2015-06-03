package com.pasteleria.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Product;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.ProductDAO;

public class SqlServerProductDAO implements ProductDAO {

	SqlSessionFactory SQL_SESSION_FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> list() {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<Product> list=null;
		try {
			list=session.selectList("productxml.sql_select");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return list;
	}

	@Override
	public Product find(Product bean) {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		Product product=null;
		try {
			product=(Product) session.selectOne("productxml.sql_find",bean.getIdProducto());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return product;
	}

	@Override
	public int create(Product bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.insert("productxml.sql_insert",bean);
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
	public int update(Product bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.update("productxml.sql_update",bean);
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
	public int delete(Product bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.delete("productxml.sql_delete",bean.getIdProducto());
			session.commit();
			System.out.println(salida);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> filter(int idcategoria, int idcobertura, int idmasa,int idrelleno) {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<Product> list=null;	
		try {
			
			Map<String,String> map=new HashMap<String, String>();
			
			if (idcategoria==0)
				map.put("idCategoria","");
			else
				map.put("idCategoria",""+idcategoria);
			if (idcobertura==0)
				map.put("idCobertura","");
			else
				map.put("idCobertura",""+idcobertura);
			if (idmasa==0)
				map.put("idMasa","");
			else
				map.put("idMasa",""+idmasa);
			if (idrelleno==0)
				map.put("idRelleno","");
			else
				map.put("idRelleno",""+idrelleno);
			
			list=session.selectList("productxml.sql_filter",map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return list;
	}

}
