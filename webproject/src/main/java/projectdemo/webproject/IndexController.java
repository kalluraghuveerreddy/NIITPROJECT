package projectdemo.webproject;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecomProject.ecommerce.dao.AdminDaoService;
import ecomProject.ecommerce.dao.CategoryDaoService;
import ecomProject.ecommerce.dao.CustomerDaoService;
import ecomProject.ecommerce.dao.SubCategoryDaoService;
import ecomProject.ecommerce.dao.VendorDaoService;

import ecomProject.ecommerce.model.Vendor;
import ecomProject.ecommerce.model.AdminPerson;
import ecomProject.ecommerce.model.Customer;


 @Controller
 public class IndexController {
	   
	   
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
	
	@GetMapping(value= {"/"})
	public ModelAndView indexPage()
	{
		ModelAndView modelAndView=new ModelAndView("index");
	    return modelAndView;
	}
	
	@GetMapping(value= {"vendorsignup"})
	public String signupVendor(Model model)
	{
		model.addAttribute("vendor", new Vendor());
		
		return "vendorsignup";
	}
	
	@PostMapping("vendorregisterprocess")
	public String singupVendorProcess(@ModelAttribute("vendor")Vendor vendor) {
	
		if((vendorDaoService.getVendorByEmail(vendor.getVendor_email()))!=null) {
		
			 return "vendorsignup";
		}
		else {
			vendorDaoService.registerVendor(vendor);
			return "index";
		}
	}
	
	@GetMapping("vendorsignin")
	public String login()
	{
		return "vendorsignin";
	}
	
	@PostMapping("vendorloginprocess")
	public  String  loginVendor(HttpServletRequest request,HttpSession session)
	{
		
	   if((vendorDaoService.loginVendor(request.getParameter("vendor_email"),request.getParameter("vendor_password")))!=null) {
		   
		   Vendor vendor=vendorDaoService.loginVendor(request.getParameter("vendor_email"),request.getParameter("vendor_password"));
		   
		   session.setAttribute("vendorDetails",vendor);
		   
		    return "vendorindex";
		 
	   }
	   else {
		   
		   return "vendorsignin";
	   }
	}
	
	
	@GetMapping(value= {"customersignup"})
	public String signupCustomer(Model model)
	{
		model.addAttribute("customer", new Customer());
		
		return "customersignup";
	}
	
	@PostMapping("customerregisterprocess")
	public String singupVendorProcess(@ModelAttribute("customer")Customer customer) {
	
		if((customerDaoService.getCustomerByEmail(customer.getCustomer_email()))!=null) {
		
			 return "customersignup";
		}
		else {
			customerDaoService.registerCustomer(customer);
			return "index";
		}
	}
	
	@GetMapping("customersignin")
	public String loginCustomer()
	{
		
		return "customersignin";
	}
	
	@PostMapping("customerloginprocess")
	public  String  loginCustomerProcess(HttpServletRequest request,HttpSession session)
	{
		
	   if((customerDaoService.loginCustomer(request.getParameter("customer_email"),request.getParameter("customer_password")))!=null) {
		   
		   Customer customer=customerDaoService.loginCustomer(request.getParameter("customer_email"),request.getParameter("customer_password"));
		   
		   session.setAttribute("customerDetails",customer);
		   
		    return "customerindex";
		 
	   }
	   else {
		   
		   return "customersignin";
	   }
	}
	
	@GetMapping("adminsignin")
	public String loginAdmin()
	{
		
		return "adminsignin";
	}
	
	@PostMapping("adminloginprocess")
	public  String  loginAdminProcess(HttpServletRequest request,HttpSession session)
	{
		
	   if((adminDaoService.login(request.getParameter("email"),request.getParameter("password")))!=null) {
		   
		   AdminPerson adminPerson=adminDaoService.login(request.getParameter("email"),request.getParameter("password"));
		   
		   session.setAttribute("adminDetails",adminPerson);
		   
		    return "adminindex";
		 
	   }
	   else {
		   
		   return "adminsignin";
	   }
	}
	

	@GetMapping(value= {"editvendor"})
	public String editVendorprofile(HttpSession httpSession,Model model)
	{
		model.addAttribute("vendor", httpSession.getAttribute("vendorDetails"));
		return "editvendorprofile";
	}
	
	@PostMapping("vendoreditprofileprocess")
	public String editVendorProfileProces(@ModelAttribute("vendor")Vendor vendor){
		
		vendorDaoService.update(vendor);
		return "vendorindex";
	}
	
	@PostMapping("vendorupdateprocess")
	public String vendorUpdateProcess(@ModelAttribute("vendor")Vendor vendor,HttpSession session) {

		    session.setAttribute("vendorDetails", vendor);
			vendorDaoService.update(vendor);
		    return  "vendorindex";
			 
	}
	
	@GetMapping("vendordetails")
	public String getVendorDetails(Map<String ,Object> vendors) {
		vendors.put("vendorList", vendorDaoService.getAllVendorDetails());
		return "vendordetails";
	}
	
	@GetMapping("vendorprofile")
	public String getVendorDetails() {
		return "vendorprofile";
	}
	
	@GetMapping("customerprofile")
	public String getCustomerDetails() {
		return "customerprofile";
	}
	
	@GetMapping("adminprofile")
	public String getAdminDetails() {
		return "adminprofile";
	}
	
	@GetMapping("accept/{vendor_id}")
	public String acceptUser(@PathVariable("vendor_id")int vendor_id) {
		
		Vendor vendor=vendorDaoService.getVendorById(vendor_id);
		vendor.setStatus(true);
		vendorDaoService.update(vendor);
		return "redirect:/vendordetails";
		
	}
	
	@GetMapping("reject/{user_id}")
	public String rejectUser(@PathVariable("vendor_id")int vendor_id) {
		
		Vendor vendor=vendorDaoService.getVendorById(vendor_id);
		vendor.setStatus(false);
		vendorDaoService.update(vendor);
		return "redirect:/vendordetails";
		
	}
	
	@GetMapping("categories")
	public String getCategories(Map<String,Object> categories) {
		categories.put("categoryList", categoryDaoService.getCategories());
		return "categories";
	}
}
