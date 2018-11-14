package projectdemo.webproject;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ecomProject.ecommerce.dao.AdminDaoService;
import ecomProject.ecommerce.dao.CategoryDaoService;
import ecomProject.ecommerce.dao.CustomerDaoService;
import ecomProject.ecommerce.dao.ProductDaoService;
import ecomProject.ecommerce.dao.SubCategoryDaoService;
import ecomProject.ecommerce.dao.VendorDaoService;
import ecomProject.ecommerce.model.Customer;

@Controller
public class CustomerController {

	@Autowired
	private VendorDaoService vendorDaoService;
	@Autowired
	private CustomerDaoService customerDaoService;
	@Autowired
	private AdminDaoService adminDaoService;
	@Autowired
	private CategoryDaoService categoryDaoService;
	@Autowired
	private SubCategoryDaoService subCategoryDaoService;
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProductDaoService productDaoService;

	@GetMapping(value = { "customersignup" })
	public String signupCustomer(Model model) {
		model.addAttribute("customer", new Customer());

		return "customersignup";
	}

	@PostMapping("customerregisterprocess")
	public String singupCustomerProcess(@Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult) {

		if (!bindingResult.hasErrors()) {
			if ((customerDaoService.getCustomerByEmail(customer.getCustomer_email())) != null) {

				return "customersignup";
			} else {
				customerDaoService.registerCustomer(customer);
				return "redirect:index";
			}
		} else {
			return "customersignup";
		}
	}

	@GetMapping("customersignin")
	public String loginCustomer() {

		return "customersignin";
	}

	/*
	 * @PostMapping("customerloginprocess") public String
	 * loginCustomerProcess(HttpServletRequest request, HttpSession session, Model
	 * model) {
	 * 
	 * if ((customerDaoService.loginCustomer(request.getParameter("customer_email"),
	 * request.getParameter("customer_password"))) != null) {
	 * 
	 * Customer customer =
	 * customerDaoService.loginCustomer(request.getParameter("customer_email"),
	 * request.getParameter("customer_password"));
	 * 
	 * session.setAttribute("electronics", session.getAttribute("electronics"));
	 * session.setAttribute("mens", session.getAttribute("mens"));
	 * session.setAttribute("womens", session.getAttribute("womens"));
	 * 
	 * session.setAttribute("customerDetails", customer);
	 * 
	 * return "redirect:customerindex";
	 * 
	 * } else {
	 * 
	 * return "customersignin"; } }
	 */
	@GetMapping("customer/customerindex")
	public ModelAndView openCustomerIndex(Principal principal, HttpSession session, Model model,
			Map<String, Object> products) {

		products.put("productList", productDaoService.getAllProducts());

		Customer customer = customerDaoService.getCustomerByEmail(principal.getName());
		session.setAttribute("customerDetails", customer);

		session.setAttribute("electronics", subCategoryDaoService.getElectronics());
		session.setAttribute("books", subCategoryDaoService.getBooks());
		session.setAttribute("homeAppliances", subCategoryDaoService.getHomeAppliances());
		session.setAttribute("mens", subCategoryDaoService.getMen());
		session.setAttribute("womens", subCategoryDaoService.getWomen());
		session.setAttribute("kids", subCategoryDaoService.getKids());

		ModelAndView modelAndView = new ModelAndView("customerindex");
		return modelAndView;
	}

	@GetMapping("customer/customerprofile")
	public String getCustomerDetails() {
		return "customerprofile";
	}

	@GetMapping(value = { "customer/editcustomerprofile" })
	public String editCustomerProfile(HttpSession session, Model model) {
		model.addAttribute("customer", session.getAttribute("customerDetails"));
		return "editcustomerprofile";
	}

	@PostMapping("customer/editcustomerprofileprocess")
	public String editCustomerProfileProces(@ModelAttribute("customer") Customer customer) {

		customerDaoService.updateCustomer(customer);
		return "redirect:/customer/customerindex";
	}

	@GetMapping("customer/customersupport")
	public String support() {
		return "customersupport";
	}

	@GetMapping("customer/customercontact")
	public String contact() {
		return "customercontact";
	}

}
