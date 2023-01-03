package cafe.items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpSession;

import cafe.dao.ProductDAO;
import cafe.entities.Product;

@Named
@RequestScoped
public class ProductBB {


		
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	ProductDAO productDAO;
		

	public List<Product> getList(){
		List<Product> list = null;
		
		Map<String,Object> searchParams = new HashMap<String, Object>();
		

		list = productDAO.getList(searchParams);
		
		return list;
	}
	

	public List<Product> getFullList(){
		return productDAO.getFullList();
	}

	
}
