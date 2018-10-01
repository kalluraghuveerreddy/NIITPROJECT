package projectdemo.webproject;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
import ecomProject.ecommerce.model.Product;
import ecomProject.ecommerce.model.products.Laptop;

@Controller
public class CartController {
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

	/*@GetMapping("/customer/addtocart")
	public String addToCart(Principal principal, HttpServletRequest request) {

		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int quantity = Integer.parseInt(request.getParameter("noOfProducts"));
		int unitPrice = productDaoService.getProduct(product_id).getProduct_price();
		Product product = productDaoService.getProduct(product_id);
		
	}*/
}
