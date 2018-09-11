package projectdemo.webproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecomProject.ecommerce.dao.CategoryDaoService;
import ecomProject.ecommerce.dao.SubCategoryDaoService;
import ecomProject.ecommerce.dao.products.LaptopDaoService;
import ecomProject.ecommerce.dao.products.MobileDaoService;
import ecomProject.ecommerce.dao.products.RefrigeratorDaoService;
import ecomProject.ecommerce.model.products.Laptop;
import ecomProject.ecommerce.model.products.Mobile;
import ecomProject.ecommerce.model.products.Refrigerator;

@Controller
public class ProductController {
	
	@Autowired
	private LaptopDaoService laptopDaoService;
	@Autowired
	private MobileDaoService mobileDaoService;
	@Autowired
	private RefrigeratorDaoService refrigeratorDaoService;
	@Autowired
	private SubCategoryDaoService subCategoryDaoService;
	@Autowired
	private CategoryDaoService categoryDaoService;
	
	@PostMapping("subcategory")
	public String getSubCategory(@RequestParam("category")int category_id, Model model) {
		 
		model.addAttribute("subCategoryList",subCategoryDaoService.getSubcategory(category_id));
		model.addAttribute("categoryName",categoryDaoService.getCategoryById(category_id));
		return "subcategory";
		
	}
	@PostMapping("getModel")
	public String  addProducts(HttpServletRequest request,Model model) {
		
		switch(request.getParameter("subCategory_name")) 
		{
		  case "Laptop": model.addAttribute("laptop" ,new Laptop());
		  return "laptop";
		  
		  case "Mobile": model.addAttribute("mobile" ,new Mobile());
		   return "mobile";
		   
		  case "Refrigerator": model.addAttribute("refrigerator" ,new Refrigerator());
		   return "refrigerator";
		default: return "subcategory";
		}
	}
	@PostMapping("laptoprocess")
	public String addLaptopProcess(@ModelAttribute("laptop")Laptop laptop) {
		
		laptopDaoService.addLaptop(laptop);
		return "vendorindex";
	}
	
	@PostMapping("mobileprocess")
	public String addMobileProcess(@ModelAttribute("mobile")Mobile mobile) {
		
		mobileDaoService.addMobile(mobile);
		return "vendorindex";
	}
	
	@PostMapping("refrigeratorprocess")
	public String addRefrigeratorProcess(@ModelAttribute("refrigerator")Refrigerator refrigerator) {
		
		refrigeratorDaoService.addRefrigerator(refrigerator);
		return "vendorindex";
	}
}
