package projectdemo.webproject;

import java.util.Date;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ecomProject.ecommerce.dao.VendorDaoService;
import ecomProject.ecommerce.model.Login;
import ecomProject.ecommerce.model.Vendor;

   @Controller
 public class IndexController {
	   
	   
	@Autowired
	private VendorDaoService vendorDaoService;
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@GetMapping(value= {"/"})
	public ModelAndView indexPage()
	{
		ModelAndView modelAndView=new ModelAndView("index");
	    return modelAndView;
	}
	
	@GetMapping(value= {"signup"})
	public String signup(Model model)
	{
		model.addAttribute("vendor", new Vendor());
		return "signup";
	}
	
	@PostMapping("registerprocess")
	public String registerVendor(@ModelAttribute("vendor")Vendor vendor) {
	
		if((vendorDaoService.getVendorByEmail(vendor.getVendor_email()))!=null) {
		
			 return "redirect:signup";
			
		}
		else {
			vendorDaoService.register(vendor);
			return "redirect:login";
		}
	}
	
	@GetMapping("login")
	public String login(Model model)
	{
		model.addAttribute("login", new Login());
		return "login";
	}
	@PostMapping("loginprocess")
	public  String  loginVendor(@ModelAttribute("login")Login login,HttpSession session)
	{
	   if((vendorDaoService.login(login.getEmail(),login.getPassword()))!=null) {
		   
		      Vendor vendor=vendorDaoService.login(login.getEmail(),login.getPassword());
		      session.setAttribute("vendorDetails", vendor);
	          return "redirect:vendordetails";
	         
	    }
	    else {
		   return "redirect:login";
	     }
	}
	
	@GetMapping("vendordetails")
	public String vendorDetails() {
		
	   return "vendordetails";
	}

	@GetMapping("updatevendor")
	public String updateVendor() {
		return "redirect:updatelogin";
	}
	
	@GetMapping("updatelogin")
	public String updatelogin(Model model)
	{
		model.addAttribute("login", new Login());
		return "updatelogin";
	}
	@PostMapping("updateloginprocess")
	public  String  updateloginVendor(@ModelAttribute("login")Login login,HttpSession session)
	{
	   if((vendorDaoService.login(login.getEmail(),login.getPassword()))!=null) {
		   
		      Vendor vendor=vendorDaoService.login(login.getEmail(),login.getPassword());
		      session.setAttribute("vendorDetails", vendor);
	          return "redirect:update";
	         
	    }
	    else {
		   return "redirect:updatelogin";
	     }
	}
	
	@GetMapping(value= {"update"})
	public String updatevendor(Model model)
	{
		model.addAttribute("vendor", new Vendor());
		return "update";
	}
	
	@PostMapping("updateprocess")
	public String updateProcessVendor(@ModelAttribute("vendor")Vendor vendor) {
	
		/*if((vendorDaoService.getVendorByEmail(vendor.getVendor_email()))!=null) {
		
			 return "redirect:signup";
			
		}*/
		//else {
			vendorDaoService.updateVendor(vendor);
			return "redirect:login";
		//}
	}
	
}
