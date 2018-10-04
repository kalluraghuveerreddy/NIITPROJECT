package projectdemo.webproject;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ecomProject.ecommerce.dao.AdminDaoService;
import ecomProject.ecommerce.dao.CategoryDaoService;
import ecomProject.ecommerce.dao.CustomerDaoService;
import ecomProject.ecommerce.dao.SubCategoryDaoService;
import ecomProject.ecommerce.dao.VendorDaoService;
import ecomProject.ecommerce.model.AdminPerson;
import ecomProject.ecommerce.model.Vendor;

@Controller
public class AdminController {
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

	@GetMapping("adminsignin")
	public ModelAndView loginAdmin(HttpSession session) {

		ModelAndView modelAndView = new ModelAndView("adminsignin");

		return modelAndView;
	}

	// below code was commented bcz we used Spring security instead of this 
	
	/*@PostMapping("adminloginprocess")
	public String loginAdminProcess(HttpServletRequest request, HttpSession session) {

		if ((adminDaoService.login(request.getParameter("email"), request.getParameter("password"))) != null) {

			AdminPerson adminPerson = adminDaoService.login(request.getParameter("email"),
					request.getParameter("password"));
			session.setAttribute("adminDetails", adminPerson);

			return "redirect:adminindex";

		} else {

			return "adminsignin";
		}

	}*/

	@GetMapping("/admin/adminindex")
	public ModelAndView openAdminIndex(HttpSession session,Principal principal) {
		ModelAndView modelAndView = new ModelAndView("adminindex");
		session.setAttribute("electronics", subCategoryDaoService.getElectronics());
		session.setAttribute("books", subCategoryDaoService.getBooks());
		session.setAttribute("homeAppliances", subCategoryDaoService.getHomeAppliances());
		session.setAttribute("mens", subCategoryDaoService.getMen());
		session.setAttribute("womens", subCategoryDaoService.getWomen());
		session.setAttribute("kids", subCategoryDaoService.getKids());
		AdminPerson  adminPerson=adminDaoService.getAdminDetailsByEmail(principal.getName());
		session.setAttribute("adminDetails", adminPerson);
		return modelAndView;
	}

	@GetMapping("admin/adminprofile")
	public String getAdminDetails() {
		return "adminprofile";
	}

	@GetMapping("admin/accept/{vendor_id}")
	public String acceptUser(@PathVariable("vendor_id") int vendor_id) {

		Vendor vendor = vendorDaoService.getVendorById(vendor_id);
		vendor.setStatus(true);
		vendorDaoService.update(vendor);
		return "redirect:/admin/vendordetails";

	}

	@GetMapping("admin/reject/{user_id}")
	public String rejectUser(@PathVariable("vendor_id") int vendor_id) {

		Vendor vendor = vendorDaoService.getVendorById(vendor_id);
		vendor.setStatus(false);
		vendorDaoService.update(vendor);
		return "redirect:/admin/vendordetails";

	}

	@GetMapping("admin/vendordetails")
	public String getVendorDetails(Map<String, Object> vendors) {
		vendors.put("vendorList", adminDaoService.getAllVendors());
		return "vendordetails";
	}
}
