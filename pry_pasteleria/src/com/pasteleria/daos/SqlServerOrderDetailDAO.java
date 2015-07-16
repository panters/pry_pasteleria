package com.pasteleria.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Order;
import com.pasteleria.bean.OrderDetail;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.OrderDetailDAO;

public class SqlServerOrderDetailDAO implements OrderDetailDAO {

	SqlSessionFactory SQL_SESSION_FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> list(String id) {
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		List<OrderDetail> list=null;
		
		try {
			list=session.selectList("orderDetailxml.sql_select",id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return list;
		
	}

	@Override
	public OrderDetail find(OrderDetail bean) {
		// TODO Auto-generated method stub
		return null;
	}
		
	@Override
	public int create(OrderDetail bean) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			salida=session.insert("orderDetailxml.sql_insert",bean);
			session.commit();
			System.out.println(salida);
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}
	
	
	public int createfromList(String idPedido,List<OrderDetail> details) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		try {
			
				System.out.println(details.size());
				
				if (details!=null && details.size()>0) {
					
					for (OrderDetail obj :details) {
						
						obj.setPedidoCabe(new Order(idPedido));
						obj.setPrecioUnidad(obj.getProducto().getPrecio());
						
						System.out.println(obj.getPedidoCabe().getIdPedidoCabe()+
								obj.getProducto().getIdProducto()+
								obj.getPrecioUnidad()+
								obj.getDedicatoria()+
								obj.getNombre_agasajado()+
								obj.getFec_requerimiento()
								);
						
						
						salida=session.insert("orderDetailxml.sql_insert",obj);
						
						if(salida<=0){
							System.out.println("error en orderDetail");
							session.rollback();
							return -1;
						}
					}
					
					session.commit();
					
				}else{
					System.out.println("Lista vacía");
					return 0;
				}
			System.out.println(salida);
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}
	
	
	@Override
	public int update(String idPedido,int i, int idEstado) {
		int salida=0;
		SqlSession session=SQL_SESSION_FACTORY.openSession();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("idPedido", idPedido);
		map.put("estado", idEstado);
		map.put("indice", i);
		
		
		try {
			salida=session.update("orderDetailxml.sql_update",map);
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
	public int delete(OrderDetail bean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
