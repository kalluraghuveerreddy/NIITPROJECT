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

	@GetMapping(value = { "/" })
	public ModelAndView indexPage(HttpSession session) {

		ModelAndView modelAndView = new ModelAndView("index");

		session.setAttribute("electronics", subCategoryDaoService.getElectronics());
		session.setAttribute("books", subCategoryDaoService.getBooks());
		session.setAttribute("homeAppliances", subCategoryDaoService.getHomeAppliances());
		session.setAttribute("mens", subCategoryDaoService.getMen());
		session.setAttribute("womens", subCategoryDaoService.getWomen());
		session.setAttribute("kids", subCategoryDaoService.getKids());

		return modelAndView;
	}

	@GetMapping("index")
	public ModelAndView openIndex() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	

	@GetMapping("adminsignin")
	public String loginAdmin() {
		return "adminsignin";
	}

	@PostMapping("adminloginprocess")
	public String loginAdminProcess(HttpServletRequest request, HttpSession session) {
		
		
		if ((adminDaoService.login(request.getParameter("email"), request.getParameter("password"))) != null) {

			AdminPerson adminPerson = adminDaoService.login(request.getParameter("email"),
					request.getParameter("password"));
			session.setAttribute("adminDetails", adminPerson);

			return "redirect:adminindex";

		} else {

			return "adminsignin";
		}
		
	}
	

	@GetMapping("adminindex")
	public ModelAndView openAdminIndex() {
		ModelAndView modelAndView = new ModelAndView("adminindex");
		return modelAndView;
	}

	

	@GetMapping("adminprofile")
	public String getAdminDetails() {
		return "adminprofile";
	}

	@GetMapping("accept/{vendor_id}")
	public String acceptUser(@PathVariable("vendor_id") int vendor_id) {

		Vendor vendor = vendorDaoService.getVendorById(vendor_id);
		vendor.setStatus(true);
		vendorDaoService.update(vendor);
		return "redirect:/vendordetails";

	}

	@GetMapping("reject/{user_id}")
	public String rejectUser(@PathVariable("vendor_id") int vendor_id) {

		Vendor vendor = vendorDaoService.getVendorById(vendor_id);
		vendor.setStatus(false);
		vendorDaoService.update(vendor);
		return "redirect:/vendordetails";

	}

	@GetMapping("categories")
	public String getCategories(Map<String, Object> categories) {
		categories.put("categoryList", categoryDaoService.getCategories());

		return "categories";
	}
	


}
