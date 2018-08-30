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
	
	@GetMapping(value= {"index"})
	public ModelAndView indexPage()
	{
		ModelAndView modelAndView=new ModelAndView("index");
	    return modelAndView;
	}
	
	@GetMapping(value= {"/","signup"})
	public String signup(Model model)
	{
		model.addAttribute("vendor", new Vendor());
		return "signup";
	}
	
	@PostMapping("registerprocess")
	public String addVendor(@ModelAttribute("vendor")Vendor vendor) {
		if(vendorDaoService.addVendor(vendor)) {
			return "redirect:login";
		}
		else {
			return "signup";
		}
	}
	@GetMapping("login")
	public String login(Model model)
	{
		model.addAttribute("login", new Login());
		return "login";
	}
	@PostMapping("loginprocess")
	public  String  loginVendor(@ModelAttribute("login")Login login,Model model)
	{
	   if((vendorDaoService.login(login.getEmail(),login.getPassword()))!=null) {
		   
		    Vendor vendor=vendorDaoService.login(login.getEmail(),login.getPassword());
		      model.addAttribute("vendorDetails", vendor);
	          return "vendordetails";
		     // return "redirect:update";
		   
		      //return "home";
	   }
	   else {
		   return "redirect:login";
	   }
		
	}
	@GetMapping("update")
	public String update(Model model) {
		model.addAttribute("vendor",new  Vendor());
		return "update";
	}
	

	@PostMapping("updateprocess")
	public String updateProcess(@ModelAttribute("vendor")Vendor vendor) {
		if(vendorDaoService.updateVendor(vendor))
		{
			return "index";
			
		}
		else {
			return "home";
		}
	}	
}
