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

import ecomProject.ecommerce.dao.UserDaoService;

import ecomProject.ecommerce.model.Login;
import ecomProject.ecommerce.model.User;


   @Controller
 public class IndexController {
	   
	   
	@Autowired
	private UserDaoService userDaoService;
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping(value= {"/"})
	public ModelAndView indexPage()
	{
		ModelAndView modelAndView=new ModelAndView("index");
	    return modelAndView;
	}
	
	@GetMapping(value= {"register"})
	public String signup(Model model)
	{
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("registerprocess")
	public String registerVendor(@ModelAttribute("user")User user) {
	
		if((userDaoService.getUserDetailsByEmail(user.getEmail()))!=null) {
		
			 return "signup";
		}
		else {
			userDaoService.registerUser(user);
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
	public  String  loginUser(@ModelAttribute("login")Login login,HttpSession session)
	{
	   if((userDaoService.loginUser(login.getEmail(),login.getPassword()))!=null) {
		   
		   User user=userDaoService.loginUser(login.getEmail(),login.getPassword());
		   
		   session.setAttribute("userDetails",user);
		   
		    // return "redirect:userprofile";
		   
		   if(user.getRole().equalsIgnoreCase("admin")) {
			   return  "adminindex";
		   }else 
		   if(user.getRole().equalsIgnoreCase("vendor")) {
			   return  "vendorindex";
		   } else
		  
			   return  "customerindex";
		   
	   }
	   else {
		   
		   return "login";
	   }
	}
	

	@GetMapping(value= {"edit"})
	public String updateUser(HttpSession httpSession,Model model)
	{
		model.addAttribute("user", httpSession.getAttribute("userDetails"));
		return "edit";
	}
	
	@PostMapping("updateprocess")
	public String userUpdateProcess(@ModelAttribute("user")User user,HttpSession session) {

		    session.setAttribute("userDetails", user);
			userDaoService.updateUser(user);
			
			  if(user.getRole().equalsIgnoreCase("admin")) {
				   return  "adminindex";
			   }else 
			   if(user.getRole().equalsIgnoreCase("vendor")) {
				   return  "vendorindex";
			   } else
			  
				   return  "customerindex";
		
	}
	
	@GetMapping("userdetails")
	public String getUserDetails(Map<String ,Object> user) {
		user.put("userList", userDaoService.getVendorDetails());
		return "userdetails";
	}
	
	@GetMapping("userprofile")
	public String getUserDetails() {
		return "userprofile";
	}
	
	@GetMapping("accept/{user_id}")
	public String acceptUser(@PathVariable("user_id")int user_id) {
		
		User user=userDaoService.getUserDetails(user_id);
		user.setStatus(true);
		userDaoService.updateUser(user);
		return "adminindex";
		
	}
	
	@GetMapping("reject/{user_id}")
	public String rejectUser(@PathVariable("user_id")int user_id) {
		
		User user=userDaoService.getUserDetails(user_id);
		user.setStatus(false);
		userDaoService.updateUser(user);
		return "adminindex";
		
	}
	
	
}
