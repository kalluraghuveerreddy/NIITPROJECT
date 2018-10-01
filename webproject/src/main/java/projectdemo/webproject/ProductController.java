package projectdemo.webproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
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
import com.sun.mail.handlers.image_gif;
import ecomProject.ecommerce.dao.CategoryDaoService;
import ecomProject.ecommerce.dao.ProductDaoService;
import ecomProject.ecommerce.dao.SubCategoryDaoService;
import ecomProject.ecommerce.dao.VendorDaoService;
import ecomProject.ecommerce.dao.products.AirConditionerDaoService;
import ecomProject.ecommerce.dao.products.KurtaDaoService;
import ecomProject.ecommerce.dao.products.LaptopDaoService;
import ecomProject.ecommerce.dao.products.MobileDaoService;
import ecomProject.ecommerce.dao.products.PantDaoService;
import ecomProject.ecommerce.dao.products.RefrigeratorDaoService;
import ecomProject.ecommerce.dao.products.ShirtDaoService;
import ecomProject.ecommerce.model.NoOfProducts;
import ecomProject.ecommerce.model.Product;
import ecomProject.ecommerce.model.SubCategory;
import ecomProject.ecommerce.model.Vendor;
import ecomProject.ecommerce.model.products.AirConditioner;
import ecomProject.ecommerce.model.products.Book;
import ecomProject.ecommerce.model.products.Kurta;
import ecomProject.ecommerce.model.products.Laptop;
import ecomProject.ecommerce.model.products.Mobile;
import ecomProject.ecommerce.model.products.Pant;
import ecomProject.ecommerce.model.products.Refrigerator;
import ecomProject.ecommerce.model.products.Shirt;

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
	
	@Autowired
	private AirConditionerDaoService airConditionerDaoService;
	
	@Autowired
	private ShirtDaoService shirtDaoService;
	@Autowired
	private PantDaoService pantDaoService;
	@Autowired
	private KurtaDaoService kurtaDaoService;
	
	
	
	@Autowired
	private ImageUpload ImageUpload;

	@GetMapping("vendor/subcategory/{category_id}")
	public String getSubCategory(@PathVariable("category_id") int category_id, Model model) {

		model.addAttribute("subCategoryList", subCategoryDaoService.getSubcategory(category_id));
		model.addAttribute("categoryName", categoryDaoService.getCategoryById(category_id));
		return "subcategory";

	}

	@PostMapping("vendor/getModel")
	public String addProducts(HttpServletRequest request, Model model, HttpSession session,Principal principal) {

		SubCategory subCategory = subCategoryDaoService.getSubCategoryId(Integer.parseInt(request.getParameter("subCategory_id")));
		model.addAttribute("subCategory_id", subCategory.getSubCategory_id());
		
		Vendor vendor=vendorDaoService.getVendorByEmail(principal.getName());

		/*Vendor vendor = (Vendor) session.getAttribute("vendorDetails");*/
		model.addAttribute("vendor_id", vendor.getVendor_id());

		switch (subCategory.getSubCategory_name()) {
		
		case "Laptop":

			model.addAttribute("laptop", new Laptop());

			return "laptop";

		case "Mobile":
			model.addAttribute("mobile", new Mobile());
			return "mobile";

		case "Refrigerator":
			model.addAttribute("refrigerator", new Refrigerator());
			return "refrigerator";
		case "Shirt":
			model.addAttribute("shirt", new Shirt());
			return "shirt";
			
		case "Pant":
			model.addAttribute("pant", new Pant());
			return "pant";
			
		case "AirConditioner":
			model.addAttribute("airconditioner", new AirConditioner());
			return "airconditioner";
		case "Kurta":
			model.addAttribute("kurta", new Kurta());
			return "kurta";
		case "Book":
			model.addAttribute("book", new Book());
			return "book";
		default:
			return "subcategory";
		}
	}

	@PostMapping("laptoprocess")
	public String addLaptopProcess(@ModelAttribute("laptop") Laptop laptop, HttpSession session,
			HttpServletRequest request) {

		
		List<NoOfProducts> noOfProducts = listOfProducts(laptop);

		System.out.println(laptop);
		laptop.setNoOfProducts(noOfProducts);

		if (laptopDaoService.addLaptop(laptop)) {

			ImageUpload.uploadImage(laptop, request);
			return "vendorindex";
		} else {
			return "laptop";
		}

	}

	private List<NoOfProducts> listOfProducts(Product product) {
		List<NoOfProducts> noOfProductsList = new ArrayList<NoOfProducts>();
		for (int i = 1; i <= product.getNumberOfProducts(); i++) {
			NoOfProducts noOfProducts = new NoOfProducts();
			noOfProducts.setProduct(product);
			noOfProductsList.add(noOfProducts);
		}
		return noOfProductsList;
	}

	@PostMapping("mobileprocess")
	public String addMobileProcess(@ModelAttribute("mobile") Mobile mobile, HttpServletRequest request) {

		List<NoOfProducts> noOfProducts = listOfProducts(mobile);

		mobile.setNoOfProducts(noOfProducts);

		if (mobileDaoService.addMobile(mobile)) {

		    ImageUpload.uploadImage(mobile, request);
			return "vendorindex";
		} else {
			return "mobile";
		}

	}
	
	@PostMapping("pantprocess")
	public String addPantProcess(@ModelAttribute("pant")Pant pant, HttpSession session,
			HttpServletRequest request) {

		
		List<NoOfProducts> noOfProducts = listOfProducts(pant);

		
		pant.setNoOfProducts(noOfProducts);

		if (pantDaoService.add(pant)) {

			ImageUpload.uploadImage(pant, request);
			return "vendorindex";
		} else {
			return "pant";
		}

	}
	
	@PostMapping("shirtprocess")
	public String addShirtProcess(@ModelAttribute("shirt")Shirt shirt, HttpSession session,
			HttpServletRequest request) {

		
		List<NoOfProducts> noOfProducts = listOfProducts(shirt);

		
		shirt.setNoOfProducts(noOfProducts);

		if (shirtDaoService.add(shirt)) {

			ImageUpload.uploadImage(shirt, request);
			return "vendorindex";
		} else {
			return "shirt";
		}

	}
	
	@PostMapping("kurtaprocess")
	public String addKurtaProcess(@ModelAttribute("kurta")Kurta kurta, HttpSession session,
			HttpServletRequest request) {

		
		List<NoOfProducts> noOfProducts = listOfProducts(kurta);

		
		kurta.setNoOfProducts(noOfProducts);

		if (kurtaDaoService.add(kurta)) {

			ImageUpload.uploadImage(kurta, request);
			return "vendorindex";
		} else {
			return "kurta";
		}

	}
	
	@PostMapping("airconditionerprocess")
	public String addKurtaProcess(@ModelAttribute("airconditioner")AirConditioner airConditioner, HttpSession session,
			HttpServletRequest request) {

		
		List<NoOfProducts> noOfProducts = listOfProducts(airConditioner);

		
		airConditioner.setNoOfProducts(noOfProducts);

		if (airConditionerDaoService.add(airConditioner)) {

			ImageUpload.uploadImage(airConditioner, request);
			return "vendorindex";
		} else {
			return "airConditioner";
		}

	}

	@PostMapping("refrigeratorprocess")
	public String addRefrigeratorProcess(@ModelAttribute("refrigerator") Refrigerator refrigerator,HttpServletRequest request) {
		
		List<NoOfProducts> noOfProducts = listOfProducts(refrigerator);

		
		refrigerator.setNoOfProducts(noOfProducts);
		if(refrigeratorDaoService.addRefrigerator(refrigerator)) {
			
			ImageUpload.uploadImage(refrigerator, request);
			return "vendorindex";
		}
		else {
			return "refrigerator";
		}
		
	}

	@GetMapping("vendor/productdetails")
	public String getProducts(HttpSession session, Model model, Map<String, Object> products) {

		Vendor vendor = (Vendor) session.getAttribute("vendorDetails");
		products.put("productList", productDaoService.getAllProducts(vendor.getVendor_id()));

		return "productdetails";
	}

	@GetMapping("viewproductspecifications/{product_id}")
	public String viewProducts(@PathVariable("product_id") int product_id, Model model) {

		String name = subCategoryDaoService.getSubCategoryId(productDaoService.getSubCategoryId(product_id))
				.getSubCategory_name();
		System.out.println(name);
		switch (name) {
		case "Mobile":
			model.addAttribute("mobile", mobileDaoService.getMobileDetails(product_id));
			return "mobilespecifications";

		case "Laptop":
			model.addAttribute("laptop", laptopDaoService.getLaptopDetails(product_id));
			return "laptopspecifications";
		case "AirConditioner":
			model.addAttribute("airconditioner", airConditionerDaoService.getAirConditioners(product_id));
			return "airconditionerspecifications";
		case "Refrigeraor":
			model.addAttribute("refrigerator", refrigeratorDaoService.getRefrigerator(product_id));
			return "refrigeratorspecifications";
		case "Shirt":
			model.addAttribute("shirt", shirtDaoService.getShirts(product_id));
			return "shirtspecifications";
		case "Pant":
			model.addAttribute("pant", pantDaoService.getPants(product_id));
			return "pantpecifications";
		case "Kurta":
			model.addAttribute("kurta", kurtaDaoService.getKurtas(product_id));
			return "kurtapecifications";

		default:
			return "productdetails";
		}
	}

	@GetMapping("vendor/editproductspecifications/{product_id}")
	public String editProducts(@PathVariable("product_id") int product_id, Model model,HttpServletRequest request) {

		String name = subCategoryDaoService.getSubCategoryId(productDaoService.getSubCategoryId(product_id))
				.getSubCategory_name();
		
		
		switch (name) {

		case "Mobile":
			model.addAttribute("contextPath",request.getContextPath());
			model.addAttribute("mobile", mobileDaoService.getMobileDetails(product_id));
			return "editmobilespecifications";

		case "Laptop":
			model.addAttribute("contextPath",request.getContextPath());
			model.addAttribute("laptop", laptopDaoService.getLaptopDetails(product_id));
			return "editlaptopspecifications";
		case "AirConditioner":
			model.addAttribute("contextPath",request.getContextPath());
			model.addAttribute("airconditioner", airConditionerDaoService.getAirConditioners(product_id));
			return "editairconditionerpecifications";
		case "Refrigerator":
			model.addAttribute("contextPath",request.getContextPath());
			model.addAttribute("refrigerator", refrigeratorDaoService.getRefrigerator(product_id));
			return "editrefrigeratorspecifications";
		case "Shirt":
			model.addAttribute("contextPath",request.getContextPath());
			model.addAttribute("shirt", shirtDaoService.getShirts(product_id));
			return "editshirtspecifications";
		case "Pant":
			model.addAttribute("contextPath",request.getContextPath());
			model.addAttribute("pant", pantDaoService.getPants(product_id));
			return "editpantspecifications";
		case "Kurta":
			model.addAttribute("contextPath",request.getContextPath());
			model.addAttribute("kurta", kurtaDaoService.getKurtas(product_id));
			return "editkurtaspecifications";

		default:
			return "productdetails";
		}
	}

	@PostMapping("editlaptopprocess")
	public String editLaptopProductDetails(@ModelAttribute("laptop") Laptop laptop,HttpServletRequest request) {
        if(!laptop.getImage().isEmpty()) {
        	ImageUpload.uploadImage(laptop, request);
        }
		laptopDaoService.updateLaptop(laptop);
		return "vendorindex";
	}

	@PostMapping("editmobileprocess")
	public String editMobileProductDetails(@ModelAttribute("mobile") Mobile mobile) {

		mobileDaoService.updateMobile(mobile);
		return "vendorindex";
	}

	@PostMapping("editairconditionerprocess")
	public String editLaptopProductDetails(@ModelAttribute("airconditioner")AirConditioner airConditioner,HttpServletRequest request) {
        if(!airConditioner.getImage().isEmpty()) {
        	ImageUpload.uploadImage(airConditioner, request);
        }
        airConditionerDaoService.update(airConditioner);
		return "vendorindex";
	}
	@PostMapping("editrefrigeratorprocess")
	public String editLaptopProductDetails(@ModelAttribute("refrigerator")Refrigerator refrigerator,HttpServletRequest request) {
        if(!refrigerator.getImage().isEmpty()) {
        	ImageUpload.uploadImage(refrigerator, request);
        }
        refrigeratorDaoService.updateRefrigerator(refrigerator);
		return "vendorindex";
	}
	@PostMapping("editshirtprocess")
	public String editLaptopProductDetails(@ModelAttribute("shirt")Shirt shirt,HttpServletRequest request) {
        if(!shirt.getImage().isEmpty()) {
        	ImageUpload.uploadImage(shirt, request);
        }
        shirtDaoService.update(shirt);
		return "vendorindex";
	}
	@PostMapping("editpantprocess")
	public String editLaptopProductDetails(@ModelAttribute("pant") Pant pant,HttpServletRequest request) {
        if(!pant.getImage().isEmpty()) {
        	ImageUpload.uploadImage(pant, request);
        }
		pantDaoService.update(pant);
		return "vendorindex";
	}
	@PostMapping("editkurtaprocess")
	public String editLaptopProductDetails(@ModelAttribute("kurta")Kurta kurta,HttpServletRequest request) {
        if(!kurta.getImage().isEmpty()) {
        	ImageUpload.uploadImage(kurta, request);
        }
        kurtaDaoService.update(kurta);
		return "vendorindex";
	}
	
	@GetMapping("products/{subCategory_id}")
	public String getProducts(@PathVariable("subCategory_id")int subCategory_id,Map<String,Object> products,HttpSession session) {
		
		session.setAttribute("electronics", subCategoryDaoService.getElectronics());
		session.setAttribute("books", subCategoryDaoService.getBooks());
		session.setAttribute("homeAppliances", subCategoryDaoService.getHomeAppliances());
		session.setAttribute("mens", subCategoryDaoService.getMen());
		session.setAttribute("womens", subCategoryDaoService.getWomen());
		session.setAttribute("kids", subCategoryDaoService.getKids());
		
		products.put("productList",productDaoService.getProducts(subCategory_id));
		
		
		return "product";
	}
	
	
}
