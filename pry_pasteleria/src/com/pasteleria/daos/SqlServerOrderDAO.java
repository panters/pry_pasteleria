package com.pasteleria.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Order;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.OrderDAO;

public class SqlServerOrderDAO implements OrderDAO {
	
	SqlSessionFactory SQL_SESSION_FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> list() {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<Order> list=null;
		try {
			list=session.selectList("orderxml.sql_selectAll");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> list(String id) {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<Order> list=null;
		try {
			list=session.selectList("orderxml.sql_select", id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return list;
	}

	@Override
	public Order find(Order bean) {
			SqlSession session=SQL_SESSION_FACTORY.openSession();
			Order list=null;
			try {
				list=(Order) session.selectOne("orderxml.sql_find", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				session.close();
			}	
			return list;
	}

	@Override
	public String create(Order bean) {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		String idPedidoCabe=null;
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			//Parametros para registrar el Pedido
			map.put("idCliente",bean.getCliente().getIdUsuario());
			map.put("idEmpleado",bean.getEmpleado().getIdUsuario());
			map.put("total", bean.getTotal());
			map.put("formaCompra", bean.getFormaCompra().getIdforcom());
			map.put("idPedidoCabe",idPedidoCabe);
			//Registramos el Pedido
			session.selectOne("orderxml.sql_insert",map);
			//Obteemos el idPedidoGenerado
			idPedidoCabe=map.get("idPedidoCabe").toString();
			//confirmamos los cambios
			session.commit();			
			System.out.println(idPedidoCabe);
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return idPedidoCabe;
	}

	
	@Override
	public int update(Order bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.update("orderxml.sql_update",bean);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}

	@Override
	public int delete(Order bean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
