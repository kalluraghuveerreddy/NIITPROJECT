package projectdemo.webproject;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecomProject.ecommerce.dao.SubCategoryDaoService;

@Controller
public class IndexController {

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
	public ModelAndView openIndex(HttpSession session) {

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

}
