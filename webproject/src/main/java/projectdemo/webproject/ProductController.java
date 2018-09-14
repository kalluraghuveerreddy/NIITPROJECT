package projectdemo.webproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecomProject.ecommerce.dao.CategoryDaoService;
import ecomProject.ecommerce.dao.ProductDaoService;
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
@MultipartConfig
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
	
	@Autowired
	private ProductDaoService productDaoService;
	
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
	public String addLaptopProcess(@ModelAttribute("laptop")Laptop laptop,HttpSession session,HttpServletRequest request) {
		
	  /*	laptop.setVendor((Vendor)session.getAttribute("vendor"));*/
	   List<NoOfProducts> noOfProducts=listOfProducts(laptop);
	   
	   
	   System.out.println(laptop);
		laptop.setNoOfProducts(noOfProducts);
		
		if(laptopDaoService.addLaptop(laptop)) {
			
			String contextPath=request.getRealPath("/");
			File file=new File(contextPath+"/resources/images/products/");
			   
			if(!file.exists())
			{
				file.mkdir();
			}
			
			System.out.println(file.getPath());
			FileOutputStream fileOutputStream=null;
			try {
				 fileOutputStream=new FileOutputStream(file.getPath()+"/"+laptop.getProduct_id()+".jpg");
				InputStream inputStream=laptop.getImage().getInputStream();
				byte[] imageBytes=new byte[inputStream.available()];
				inputStream.read(imageBytes);
				
				fileOutputStream.write(imageBytes);
				fileOutputStream.flush();		
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				 try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			  			
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
	public String addMobileProcess(@ModelAttribute("mobile")Mobile mobile,HttpServletRequest request) {
		
		  List<NoOfProducts> noOfProducts=listOfProducts(mobile);
		   
			laptop.setNoOfProducts(noOfProducts);
			
			if(mobileDaoService.addMobile(mobile)) {
			
				String contextPath=request.getRealPath("/");
				File file=new File(contextPath+"/resources/images/products/");
				System.out.println(file.getPath());
				if(!file.exists())
				{
					file.mkdirs();
				}
				
				
				FileOutputStream fileOutputStream=null;
				try {
					fileOutputStream=new FileOutputStream(file.getPath()+"/"+mobile.getProduct_id()+".jpg");
					InputStream inputStream=mobile.getImage().getInputStream();
					byte[] productImages=new byte[inputStream.available()];
					
					inputStream.read(productImages);
					fileOutputStream.write(productImages);
					fileOutputStream.flush();
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				finally {
					try {
						fileOutputStream.close();
					} catch (IOException e) {
					
						e.printStackTrace();
					}
				}
				
				return  "vendorindex";
				}
			   else {
				return  "getModel";
			   }
			
	}
	
	@PostMapping("refrigeratorprocess")
	public String addRefrigeratorProcess(@ModelAttribute("refrigerator")Refrigerator refrigerator) {
		
		refrigeratorDaoService.addRefrigerator(refrigerator);
		return "vendorindex";
	}
	
	@GetMapping("productdetails")
	public String getProducts(HttpSession session,Model model,Map<String,Object> products) {
		
		Vendor vendor=(Vendor)session.getAttribute("vendorDetails");
		products.put("productList", productDaoService.getAllProducts(vendor.getVendor_id()));

		return "productdetails";	
	}
	@GetMapping("viewproductspecifications/{product_id}")
	public String viewProducts(@PathVariable("product_id")int product_id,Model model) {

		String name=subCategoryDaoService.getSubCategoryId(productDaoService.getSubCategoryId(product_id)).getSubCategory_name();
		System.out.println(name);
		switch(name)
		{
		case "Mobile":model.addAttribute("mobile",mobileDaoService.getMobileDetails(product_id));
			return "mobilespecifications";
		               
		case "Laptop": model.addAttribute("laptop",laptopDaoService.getLaptopDetails(product_id));
			return "laptopspecifications";
			
		default:return "products";
       }
	}
			
}
	
