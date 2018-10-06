package projectdemo.webproject;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ecomProject.ecommerce.dao.AdminDaoService;
import ecomProject.ecommerce.dao.CategoryDaoService;
import ecomProject.ecommerce.dao.CustomerDaoService;
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

	@GetMapping(value = { "customersignup" })
	public String signupCustomer(Model model) {
		model.addAttribute("customer", new Customer());

		return "customersignup";
	}

	@PostMapping("customerregisterprocess")
	public String singupVendorProcess(@ModelAttribute("customer") Customer customer) {

		if ((customerDaoService.getCustomerByEmail(customer.getCustomer_email())) != null) {

			return "customersignup";
		} else {
			customerDaoService.registerCustomer(customer);
			return "redirect:index";
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
	public ModelAndView openCustomerIndex(Principal principal, HttpSession session) {

		ModelAndView modelAndView = new ModelAndView("customerindex");

		Customer customer = customerDaoService.getCustomerByEmail(principal.getName());
		session.setAttribute("customerDetails", customer);
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

	
    @GetMapping("customer/support")
	public String support() {
		return "support";
	}
    @GetMapping("customer/contact")
   	public String contact() {
   		return "contact";
   	}

}
