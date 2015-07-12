package com.pasteleria.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Category;
import com.pasteleria.bean.Coverage;
import com.pasteleria.bean.Filling;
import com.pasteleria.services.HasServiceRol;
import com.pasteleria.services.ServiceCategory;
import com.pasteleria.services.ServiceCoverage;
import com.pasteleria.services.ServiceFilling;

@ParentPackage(value="cloudedleopard")
public class CategoryAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private List<Category> categorias;
	private Category categoria;
	
	@Action(value="listCategory",results={@Result(name="success",type="json")})
	public String list(){
		categorias=new ServiceCategory().list();
		return SUCCESS;
	}
	
	@Action(value="findCategory",results={@Result(name="success",type="json")})
	public String find(){
		categoria=new ServiceCategory().find(categoria);
		return SUCCESS;
	}
	
	@Action(value="createCategory",results={@Result(name="success",type="json")})
	public String create(){
		if (categoria.getIdCategoria()==0) 
			new ServiceCategory().create(categoria);
		else
			new ServiceCategory().update(categoria);
		return SUCCESS;
	}
	
	@Action(value="deleteCategory",results={@Result(name="success",type="tiles",location="mcategory")})
	public String delete(){
		new ServiceCategory().delete(categoria);
		return SUCCESS;
	}

	public List<Category> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Category> categorias) {
		this.categorias = categorias;
	}

	public Category getCategoria() {
		return categoria;
	}

	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}
	
}
