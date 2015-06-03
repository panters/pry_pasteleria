package com.pasteleria.interfaces;

import java.util.List;
import com.pasteleria.bean.Category;
/**
 * 
 * @author Pantera
 *
 */
public interface CategoryDAO {

	public List<Category> list();
	public Category find(Category bean);
	public int create(Category bean);
	public int update(Category bean);
	public int delete(Category bean);
}
