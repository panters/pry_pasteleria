package com.pasteleria.factory;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pasteleria.daos.SqlServerCategoryDAO;
import com.pasteleria.daos.SqlServerCoverageDAO;
import com.pasteleria.daos.SqlServerCustomerDAO;
import com.pasteleria.daos.SqlServerDoughDAO;
import com.pasteleria.daos.SqlServerEmployedDAO;
import com.pasteleria.daos.SqlServerFillingDAO;
import com.pasteleria.daos.SqlServerNavbarDAO;
import com.pasteleria.daos.SqlServerOrderDAO;
import com.pasteleria.daos.SqlServerOrderDetailDAO;
import com.pasteleria.daos.SqlServerProductDAO;
import com.pasteleria.daos.SqlServerRolDAO;
import com.pasteleria.daos.SqlServerStatusDAO;
import com.pasteleria.daos.SqlServerUserDAO;
import com.pasteleria.interfaces.CategoryDAO;
import com.pasteleria.interfaces.CoverageDAO;
import com.pasteleria.interfaces.CustomerDAO;
import com.pasteleria.interfaces.DoughDAO;
import com.pasteleria.interfaces.EmployedDAO;
import com.pasteleria.interfaces.FillingDAO;
import com.pasteleria.interfaces.NavbarDAO;
import com.pasteleria.interfaces.OrderDAO;
import com.pasteleria.interfaces.OrderDetailDAO;
import com.pasteleria.interfaces.ProductDAO;
import com.pasteleria.interfaces.RolDAO;
import com.pasteleria.interfaces.StatusDAO;
import com.pasteleria.interfaces.UserDAO;
/**
 * 
 * @author Pantera
 *
 */
public class SqlServerFactory extends Factory {
	
	static SqlSessionFactory sqlsessionFactory=null;
	
	static
	{
		try 
		{
			Reader reader = Resources.getResourceAsReader("com/pasteleria/mybatis/config/mybatis-config.xml");
			sqlsessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}
	
	/* Constante.de.SqlSessionFactory.para.reutilizarla.en.los.Daos*/
	public static final SqlSessionFactory SQL_SESSION_FACTORY=sqlsessionFactory;


	
	
	@Override
	public StatusDAO getStatusDAO() {
		return new SqlServerStatusDAO();
	}

	@Override
	public NavbarDAO getNavbarDAO() {
		return new SqlServerNavbarDAO();
	}

	@Override
	public UserDAO getUserDAO() {
		return new SqlServerUserDAO();
	}
	
	@Override
	public CustomerDAO getCustomerDAO() {
		return new SqlServerCustomerDAO();
	}

	@Override
	public EmployedDAO getEmployedDAO() {
		return new SqlServerEmployedDAO();
	}
	
	@Override
	public CategoryDAO getCategoryDAO() {
		return new SqlServerCategoryDAO();
	}

	@Override
	public CoverageDAO getCoverageDAO() {
		return new SqlServerCoverageDAO();
	}

	@Override
	public DoughDAO getDoughDAO() {
		return new SqlServerDoughDAO();
	}

	@Override
	public FillingDAO getFillingDAO() {
		return new SqlServerFillingDAO();
	}

	@Override
	public ProductDAO getProductDAO() {
		return new SqlServerProductDAO();
	}

	@Override
	public RolDAO getRolDAO() {
		return new SqlServerRolDAO();
	}

	@Override
	public OrderDAO getOrderDAO() {
		return new SqlServerOrderDAO();
	}

	@Override
	public OrderDetailDAO getOrderDetailDAO() {
		return new SqlServerOrderDetailDAO();
	}


}
