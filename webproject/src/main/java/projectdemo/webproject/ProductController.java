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

import com.sun.mail.handlers.image_gif;

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
	
	@Autowired
	private ImageUpload ImageUpload;

	@PostMapping("subcategory")
	public String getSubCategory(@RequestParam("category") int category_id, Model model) {

		model.addAttribute("subCategoryList", subCategoryDaoService.getSubcategory(category_id));
		model.addAttribute("categoryName", categoryDaoService.getCategoryById(category_id));
		return "subcategory";

	}

	@PostMapping("getModel")
	public String addProducts(HttpServletRequest request, Model model, HttpSession session) {

		SubCategory subCategory = subCategoryDaoService.getSubCategoryId(Integer.parseInt(request.getParameter("subCategory_id")));
		model.addAttribute("subCategory_id", subCategory.getSubCategory_id());

		Vendor vendor = (Vendor) session.getAttribute("vendorDetails");
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

	@PostMapping("refrigeratorprocess")
	public String addRefrigeratorProcess(@ModelAttribute("refrigerator") Refrigerator refrigerator) {

		refrigeratorDaoService.addRefrigerator(refrigerator);
		return "vendorindex";
	}

	@GetMapping("productdetails")
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

		default:
			return "productdetails";
		}
	}

	@GetMapping("editproductspecifications/{product_id}")
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

}
