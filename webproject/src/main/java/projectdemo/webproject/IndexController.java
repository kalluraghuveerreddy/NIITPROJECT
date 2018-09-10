package projectdemo.webproject;

import java.util.Date;
import java.util.Map;

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

import ecomProject.ecommerce.dao.CustomerDaoService;

import ecomProject.ecommerce.dao.VendorDaoService;
import ecomProject.ecommerce.model.Login;
import ecomProject.ecommerce.model.Vendor;
import ecomProject.ecommerce.model.Customer;


 @Controller
 public class IndexController {
	   
	   
	@Autowired
	private VendorDaoService vendorDaoService;
	@Autowired
	private CustomerDaoService customerDaoService;
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
	
	@PostMapping("registerprocess")
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
	public String login(Model model)
	{
		model.addAttribute("login", new Login());
		return "vendorsignin";
	}
	
	@PostMapping("loginprocess")
	public  String  loginVendor(@ModelAttribute("login")Login login,HttpSession session)
	{
		
	   if((vendorDaoService.loginVendor(login.getEmail(),login.getPassword()))!=null) {
		   
		   Vendor vendor=vendorDaoService.loginVendor(login.getEmail(),login.getPassword());
		   
		   session.setAttribute("vendorDetails",vendor);
		   
		    return "redirect:vendorindex";
		 
	   }
	   else {
		   
		   return "vendorsignin";
	   }
	}
	

	/*@GetMapping(value= {"editvendor"})
	public String updateVendor(HttpSession httpSession,Model model)
	{
		model.addAttribute("vendor", httpSession.getAttribute("vendorDetails"));
		return "editvendor";
	}
	
	@PostMapping("vendorupdateprocess")
	public String vendorUpdateProcess(@ModelAttribute("vendor")Vendor vendor,HttpSession session) {

		    session.setAttribute("vendorDetails", vendor);
			vendorDaoService.update(vendor);
		    return  "vendorindex";
			 
	}
	
	@GetMapping("userdetails")
	public String getVendorDetails(Map<String ,Object> user) {
		user.put("vendorList", vendorDaoService.getAllVendorDetails());
		return "vendordetails";
	}
	
	@GetMapping("vendorprofile")
	public String getVendorDetails() {
		return "vendorprofile";
	}
	
	@GetMapping("accept/{user_id}")
	public String acceptUser(@PathVariable("user_id")int vendor_id) {
		
		Vendor vendor=vendorDaoService.getVendorById(vendor_id);
		vendor.setStatus(true);
		vendorDaoService.update(vendor);
		return "redirect:/vendordetails";
		
	}
	
	@GetMapping("reject/{user_id}")
	public String rejectUser(@PathVariable("user_id")int vendor_id) {
		
		Vendor vendor=vendorDaoService.getVendorById(vendor_id);
		vendor.setStatus(false);
		vendorDaoService.update(vendor);
		return "redirect:/vendordetails";
		
	}*/
}
