package projectdemo.webproject;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ecomProject.ecommerce.dao.CategoryDaoService;
import ecomProject.ecommerce.dao.SubCategoryDaoService;
import ecomProject.ecommerce.dao.VendorDaoService;
import ecomProject.ecommerce.dao.products.LaptopDaoService;
import ecomProject.ecommerce.dao.products.MobileDaoService;
import ecomProject.ecommerce.dao.products.RefrigeratorDaoService;
import ecomProject.ecommerce.model.NoOfProducts;
import ecomProject.ecommerce.model.Product;
import ecomProject.ecommerce.model.SubCategory;
import ecomProject.ecommerce.model.Vendor;
import ecomProject.ecommerce.model.products.Laptop;
import ecomProject.ecommerce.model.products.Mobile;
import ecomProject.ecommerce.model.products.Refrigerator;

@Controller
public class ProductController {
	
	@Autowired
	private Laptop laptop;
	
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
	@Autowired
	private VendorDaoService vendorDaoService;
	
	@PostMapping("subcategory")
	public String getSubCategory(@RequestParam("category")int category_id, Model model) {
		 
		model.addAttribute("subCategoryList",subCategoryDaoService.getSubcategory(category_id));
		model.addAttribute("categoryName",categoryDaoService.getCategoryById(category_id));
		return "subcategory";
		
	}
	@PostMapping("getModel")
	public String  addProducts(HttpServletRequest request,Model model,HttpSession session) {
		
	   
		SubCategory subCategory=subCategoryDaoService.getSubCategoryId(Integer.parseInt(request.getParameter("subCategory_id")));
		model.addAttribute("subCategory_id",subCategory.getSubCategory_id());
		
		Vendor vendor=(Vendor)session.getAttribute("vendorDetails");
		model.addAttribute("vendor_id",vendor.getVendor_id());
		
	  switch(subCategory.getSubCategory_name()) 
		{
		  case "Laptop": 
		  						
		  						  model.addAttribute("laptop" ,new Laptop());
		  					      
		  return "laptop";
		  
		  case "Mobile": model.addAttribute("mobile" ,new Mobile());
		   return "mobile";
		   
		  case "Refrigerator": model.addAttribute("refrigerator" ,new Refrigerator());
		   return "refrigerator";
		default: return "subcategory";
		}
	}
	@PostMapping("laptoprocess")
	public String addLaptopProcess(@ModelAttribute("laptop")Laptop laptop,HttpSession session) {
		
	/*	laptop.setVendor((Vendor)session.getAttribute("vendor"));*/
	   List<NoOfProducts> noOfProducts=listOfProducts(laptop);
	   
		laptop.setNoOfProducts(noOfProducts);
		
		if(laptopDaoService.addLaptop(laptop)) {
			
			return  "vendorindex";
			}
		   else {
			return  "getModel";
		   }
		
	}
	
	private List<NoOfProducts> listOfProducts(Product product)
	{
		List<NoOfProducts> noOfProductsList=new ArrayList<NoOfProducts>();
		for(int i=1;i<=product.getNumberOfProducts();i++)
		{
			NoOfProducts noOfProducts=new NoOfProducts();
			noOfProducts.setProduct(product);
			noOfProductsList.add(noOfProducts);
		}	
		return noOfProductsList;
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
	
	@GetMapping("productdetails")
	public String getProducts(HttpSession session,Model model) {
		Vendor vendor=(Vendor)session.getAttribute("vendorDetails");
		List<Product> products=vendorDaoService.getProducts(vendor.getVendor_id());
	    session.setAttribute("products",products);
		return "productdetails";	
	}
}
