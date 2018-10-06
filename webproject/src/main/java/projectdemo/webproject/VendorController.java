package projectdemo.webproject;

import java.security.Principal;
import java.util.Map;

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
import ecomProject.ecommerce.model.Vendor;

@Controller
public class VendorController {

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

	@GetMapping(value = { "vendorsignup" })
	public String signupVendor(Model model) {

		model.addAttribute("vendor", new Vendor());
		return "vendorsignup";
	}

	@PostMapping("vendorregisterprocess")
	public String singupVendorProcess(@ModelAttribute("vendor") Vendor vendor) {

		if ((vendorDaoService.getVendorByEmail(vendor.getVendor_email())) != null) {
			return "vendorsignup";
		} else {
			vendorDaoService.registerVendor(vendor);
			return "redirect:index";
		}
	}

	@GetMapping("vendorsignin")
	public String login() {
		return "vendorsignin";
	}

	/*@PostMapping("vendorloginprocess")
	public String loginVendor(HttpServletRequest request, HttpSession session, Model model) {

		if ((vendorDaoService.loginVendor(request.getParameter("vendor_email"),
				request.getParameter("vendor_password"))) != null) {

			Vendor vendor = vendorDaoService.loginVendor(request.getParameter("vendor_email"),
					request.getParameter("vendor_password"));

			session.setAttribute("vendorDetails", vendor);

			session.setAttribute("electronics", session.getAttribute("electronics"));
			session.setAttribute("mens", session.getAttribute("mens"));
			session.setAttribute("womens", session.getAttribute("womens"));

			return "redirect:vendorindex";

		} else {

			return "vendorsignin";
		}
	}*/

	@GetMapping("vendor/vendorindex")
	public ModelAndView openVendorIndex(HttpSession session,Principal principal) {
		ModelAndView modelAndView = new ModelAndView("vendorindex");
		
		Vendor vendor=vendorDaoService.getVendorByEmail(principal.getName());
		session.setAttribute("vendorDetails", vendor);
		return modelAndView;
	}

	@GetMapping(value = { "vendor/editvendorprofile" })
	public String editVendorprofile(HttpSession session, Model model) {
	
		model.addAttribute("vendor", session.getAttribute("vendorDetails"));
		return "editvendorprofile";
	}

	@PostMapping("vendor/editvendorprofileprocess")
	public String editVendorProfileProces(@ModelAttribute("vendor") Vendor vendor) {

		vendorDaoService.update(vendor);
		return "redirect:/vendor/vendorindex";
	}

	
	@GetMapping("vendor/vendorprofile")
	public String getVendorDetails() {
		
		return "vendorprofile";
	}
	
	@GetMapping("vendor/categories")
	public String getCategories(Map<String, Object> categories) {
		categories.put("categoryList", categoryDaoService.getCategories());

		return "categories";
	}

	 @GetMapping("vendor/support")
		public String vendorSupport() {
			return "support";
		}
	    @GetMapping("vendor/contact")
	   	public String vendorContact() {
	   		return "contact";
	   	}
}
