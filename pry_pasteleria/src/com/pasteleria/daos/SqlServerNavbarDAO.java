package com.pasteleria.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.pasteleria.bean.Navbar;
import com.pasteleria.factory.SqlServerFactory;
import com.pasteleria.interfaces.NavbarDAO;
/**
 * 
 * @author Pantera
 *
 */
public class SqlServerNavbarDAO implements NavbarDAO {
	
	SqlSessionFactory FACTORY=SqlServerFactory.SQL_SESSION_FACTORY;
	ResourceBundle rb=ResourceBundle.getBundle("com/pasteleria/resources/navbarStyles");


	@SuppressWarnings("unchecked")
	@Override
	public List<Navbar> getNavbar(int rol) {
		
		SqlSession session=FACTORY.openSession();
		List<Navbar> list=null;
		try {
			list=session.selectList("navbarxml.sql_select_fathers",rol);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Navbar> getNavbarChildren(int rol,int father) {
		
		SqlSession session=FACTORY.openSession();
		List<Navbar> list=null;
		try {
			Map<String, Integer> map=new HashMap<String,Integer>();
			map.put("rol", rol);
			map.put("father",father);
			
			list=session.selectList("navbarxml.sql_select_children",map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public String getNavBarWithRol(int rol){
		StringBuilder sb=new StringBuilder(rb.getString("styleinicio")+"<ul class=\"nav navbar-nav\">");
		
		for (Navbar menuBean :getNavbar(rol)) {
			
			if (menuBean.getUrl().equals("#") && menuBean.getPadre()==0) {
				List<Navbar> submenu=getNavbarChildren(rol,menuBean.getIdMenu());
				if (submenu.size()>0) {
					sb.append(rb.getString("styleParentOpen")+menuBean.getDescripcion()+rb.getString("styleParentClose"));
					sb.append("<ul class=\"dropdown-menu\" role=\"menu\">");
					for (Navbar menuBean2 : submenu) {
						sb.append("<li><a href="+menuBean2.getUrl()+">"+menuBean2.getDescripcion()+"</a></li>");
					}
					sb.append("</ul></li>");
				}else{
					sb.append("<li><a href="+menuBean.getUrl()+">"+menuBean.getDescripcion()+"</a></li>");
				}
			}else{			
				sb.append("<li><a href="+menuBean.getUrl()+">"+menuBean.getDescripcion()+"</a></li>");
			}
			
		}
		sb.append("</ul>");
		if (rol==1) {
			sb.append(rb.getString("styleNavRightNotLoggedIn"));
		}else{
			sb.append(rb.getString("styleNavRight"));
		}
		sb.append(rb.getString("stylefin"));
		return String.valueOf(sb);
	}
	
	
	@Override
	public String getNavBarWithEmployeds(int rol) {
		
		StringBuilder sb=new StringBuilder(rb.getString("styleinicioAdmin"));
		
		for (Navbar menuBean :getNavbar(rol)) {
			
			if (menuBean.getUrl().equals("#") && menuBean.getPadre()==0) {
				List<Navbar> submenu=getNavbarChildren(rol,menuBean.getIdMenu());
				if (submenu.size()>0) {
					sb.append("<li class=\"treeview\">");
					sb.append("<a href=\"#\">"+menuBean.getIcono()+"<span>"+menuBean.getDescripcion()+"</span><i class=\"fa fa-angle-left pull-right\"></i></a>");
					
					sb.append("<ul class=\"treeview-menu\">");
					for (Navbar menuBean2 : submenu) {
						sb.append("<li><a href="+menuBean2.getUrl()+">"+menuBean2.getIcono()+menuBean2.getDescripcion()+"</a></li>");
					}
					sb.append("</ul></li>");
				}else{
					//sb.append("<li><a href="+menuBean.getUrl()+">"+menuBean.getIcono()+"<span>&nbsp;&nbsp;"+menuBean.getDescripcion()+"</span></a></li>");
				}
			}else{			
				sb.append("<li><a href="+menuBean.getUrl()+">"+menuBean.getIcono()+"<span>&nbsp;&nbsp;"+menuBean.getDescripcion()+"</span></a></li>");
			}
			
		}
		
		sb.append(rb.getString("stylefinAdmin"));
		return String.valueOf(sb);
	}
	

	public static void main(String[] args) {
		String menu=new SqlServerNavbarDAO().getNavBarWithEmployeds(4);
		System.out.println(menu);
	}

	
	
	
}
