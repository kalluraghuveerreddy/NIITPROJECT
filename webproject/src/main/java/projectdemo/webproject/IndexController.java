package projectdemo.webproject;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecomProject.ecommerce.dao.ProductDaoService;
import ecomProject.ecommerce.dao.SubCategoryDaoService;

@Controller
public class IndexController {

	@Autowired
	private SubCategoryDaoService subCategoryDaoService;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ProductDaoService productDaoService;

	@GetMapping(value = { "/" })
	public ModelAndView indexPage(Model model,HttpSession session, Map<String, Object> products) {

		ModelAndView modelAndView = new ModelAndView("index");

		products.put("productList", productDaoService.getAllProducts());
		
		session.setAttribute("electronics", subCategoryDaoService.getElectronics());
		session.setAttribute("books", subCategoryDaoService.getBooks());
		session.setAttribute("homeAppliances", subCategoryDaoService.getHomeAppliances());
		session.setAttribute("mens", subCategoryDaoService.getMen());
		session.setAttribute("womens", subCategoryDaoService.getWomen());
		session.setAttribute("kids", subCategoryDaoService.getKids());

		return modelAndView;
	}

	@GetMapping("index")
	public ModelAndView openIndex(HttpSession session,Map<String, Object> products) {
		
		products.put("productList", productDaoService.getAllProducts());
		session.setAttribute("electronics", subCategoryDaoService.getElectronics());
		session.setAttribute("books", subCategoryDaoService.getBooks());
		session.setAttribute("homeAppliances", subCategoryDaoService.getHomeAppliances());
		session.setAttribute("mens", subCategoryDaoService.getMen());
		session.setAttribute("womens", subCategoryDaoService.getWomen());
		session.setAttribute("kids", subCategoryDaoService.getKids());

		ModelAndView modelAndView = new ModelAndView("index");

		return modelAndView;
	}
	@GetMapping("contact")
	public ModelAndView opensupport(HttpSession session) {

		ModelAndView modelAndView = new ModelAndView("contact");

		return modelAndView;
	}
	@GetMapping("support")
	public ModelAndView opencontact(HttpSession session) {

		ModelAndView modelAndView = new ModelAndView("support");

		return modelAndView;
	}
	
	@PostMapping("search")
	public String search(HttpServletRequest request,Model model,HttpSession session, Map<String,Object> products) {
		
		String item=request.getParameter("searchItem");
		System.out.println(item);
		products.put("itemsList",productDaoService.getProducts(item));
		
		return "searchitem";
	}

}
