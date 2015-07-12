package com.pasteleria.util;


import java.util.List;

import com.pasteleria.bean.*;
import com.pasteleria.daos.SqlServerInsumoDAO;
import com.pasteleria.services.HasServiceOrder;
import com.pasteleria.services.ServiceInsumo;
import com.pasteleria.services.ServiceUser;

public class Test {

	
	public static void main(String[] args) {
	   
		
		List<Insumo> lst=new ServiceInsumo().list();
		
//        List<OrderDetail> listpd;
//			
//		listpd=new HasServiceOrderDetail().list("P00001");
//		Iterator<OrderDetail> it0=listpd.iterator();
//		long inicio=System.currentTimeMillis();
//		while (it0.hasNext()) {
//			OrderDetail c=it0.next();
//			System.out.println(c.getProducto().getDescripcion());
//		}		   
//		System.out.println((System.currentTimeMillis()-inicio));	    		
//		
//		
		
	/*
	User user=new ServiceUser().find("leonxandercs@gmail.com","123456");
	System.out.println(user.getNombre());
	System.out.println("-------------------------------");
	List<Category>lista=new ServiceCategory().list();
	Iterator<Category> it=lista.iterator();
	long inicio=System.currentTimeMillis();
	while (it.hasNext()) {
		Category c=it.next();
		System.out.println(c.getDescripcion());
	}
	System.out.println((System.currentTimeMillis()-inicio));	
	
	System.out.println("-------------------------------");
	List<Coverage>lista1=new ServiceCoverage().list();
	Iterator<Coverage> it0=lista1.iterator();
	while (it0.hasNext()) {
		Coverage c=it0.next();
		System.out.println(c.getDescripcion());
	}
	System.out.println((System.currentTimeMillis()-inicio));	
	
	System.out.println("-------------------------------");
	List<Dough>lista2=new ServiceDough().list();
	Iterator<Dough> it1=lista2.iterator();
	while (it1.hasNext()) {
		Dough c=it1.next();
		System.out.println(c.getDescripcion());
	}
	System.out.println((System.currentTimeMillis()-inicio));
	
	
	System.out.println("-------------------------------");
	List<Filling>lista3=new ServiceFilling().list();
	Iterator<Filling> it3=lista3.iterator();
	while (it3.hasNext()) {
		Filling c=it3.next();
		System.out.println(c.getDescripcion());
	}
	System.out.println((System.currentTimeMillis()-inicio));
	*/
	/*	*/
//		List<Product>lista3=new ServiceProduct().list();
//		Iterator<Product> it3=lista3.iterator();
//		while (it3.hasNext()) {
//			Product c=it3.next();
//			System.out.println(c.getIdProducto()+" "+c.getDescripcion()+" "+c.getPrecio());
//			System.out.println(c.getCategoria().getIdCategoria()+" "+c.getCategoria().getDescripcion());
//			System.out.println(c.getCobertura().getIdCobertura()+" "+c.getCobertura().getDescripcion());
//			System.out.println(c.getMasa().getIdMasa()+" "+c.getMasa().getDescripcion());
//			System.out.println(c.getRelleno().getIdRelleno()+" "+c.getRelleno().getDescripcion());
//		}
	
	/*
		List<Employed> empleados=new ServiceEmployed().list();
		for (Employed employed : empleados) {
			System.out.println(employed.getIdUsuario());
			System.out.println(employed.getNombre());
			System.out.println(employed.getActivo());
			System.out.println(employed.getFecha_ingreso());
			System.out.println(employed.getSueldo());
			System.out.println(employed.getFecha_salida());
		}
		System.out.println("---------------------");
		List<Customer> clientes=new ServiceCustomer().list();
		for (Customer customer : clientes) {
			System.out.println(customer.getIdUsuario());
			System.out.println(customer.getNombre());
			System.out.println(customer.getFecha_registro());
		}
	*/
		/*
		Employed employed=new Employed();
		employed.setNombre("lizzet");
		employed.setApe_pa("chavez");
		employed.setApe_ma("simbron");
		employed.setDni("46529017");
		employed.setFec_nacimiento("25-02-1981");
		employed.setSexo("F");
		employed.setEmail("lichi@gmail.com");
		employed.setEstado_civil("C");
		employed.setTelefono("5292210");
		employed.setCelular("954191116");
		employed.setSueldo(2500.00);
		employed.setActivo("1");
		employed.setLogin("lichi@gmail.com");
		employed.setPassword("123456");
		employed.setIdUsuario("E0003");
		employed.setRol(new Rol(4,""));
		
		//int salida=new ServiceEmployed().create(employed);
		//Employed e=new ServiceEmployed().find(employed);
		 System.out.println(e.getNombre());
		 System.out.println(e.getFecha_ingreso());
		 System.out.println(e.getRol().getDescripcion());
	*/
		/*
		Customer customer=new Customer();
		customer.setNombre("Ana");
		customer.setApe_pa("Simbron");
		customer.setApe_ma("Cayetano");
		customer.setDni("34529017");
		customer.setFec_nacimiento("25-02-1962");
		customer.setSexo("F");
		customer.setEmail("alinasc@gmail.com");
		customer.setEstado_civil("C");
		customer.setTelefono("5292210");
		customer.setCelular("954191116");
		customer.setLogin(customer.getEmail());
		customer.setPassword("123456");
		customer.setRol(new Rol(2,""));
		customer.setIdUsuario("C0002");
		
		//int salida=new ServiceCustomer().create(customer);
		Customer c=new ServiceCustomer().find(customer);
		System.out.println(c.getNombre());
		System.out.println(c.getRol().getDescripcion());*/
		
		/*Coverage c=new Coverage();
		c.setIdCobertura(7);
		c.setDescripcion("Sin cobertura");
		
		int salida=new ServiceCoverage().update(c);*/
		/*
		List<Product> productos=new ServiceProduct().filter(0,0,0,1);
		for (Product product : productos) {
			System.out.println(product.getDescripcion());
		}*/
			
		/*  try {
				Order o=new Order();
				Customer c=new Customer();
				c.setIdUsuario("C0002");
				o.setCliente(c);
				
				OrderDetail od=new OrderDetail();
				od.setPedidoCabe(new Order("P00001"));
				od.setProducto(new Product(2));
				od.setPrecioUnidad(70.00);
				od.setDedicatoria("feliz ucmpleaños");
				od.setNombre_agasajado("Alexander Chavez");
				od.setFec_requerimiento("10/10/2015");
				
				
				OrderDetail od1=new OrderDetail();
				od1.setPedidoCabe(new Order("P00001"));
				od1.setProducto(new Product(2));
				od1.setPrecioUnidad(70.00);
				od1.setDedicatoria("feliz ucmpleaños");
				od1.setNombre_agasajado("Alexander Chavez");
				od1.setFec_requerimiento("10/10/2015");
				
				
				OrderDetail od2=new OrderDetail();
				od2.setPedidoCabe(new Order("P00001"));
				od2.setProducto(new Product(2));
				od2.setPrecioUnidad(70.00);
				od2.setDedicatoria("feliz ucmpleaños");
				od2.setNombre_agasajado("Alexander Chavez");
				od2.setFec_requerimiento("10/10/2015");
				
				
				List<OrderDetail> l=new ArrayList<OrderDetail>();
				l.add(od);
				l.add(od1);
				l.add(od2);
				o.setOrderDetail(l);
				
				//int salida=new HasServiceOrderDetail().create(od);
				//System.out.println(salida);
				
				String s=new HasServiceOrder().create(o);
				int salida=new HasServiceOrderDetail().createfromList(s,o.getOrderDetail());
				System.out.println(salida);
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			*/
		/**/

		
	}

	
}



