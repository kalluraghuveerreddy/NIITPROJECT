package projectdemo.webproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecomProject.ecommerce.dao.CategoryDaoService;
import ecomProject.ecommerce.dao.SubCategoryDaoService;

@Controller
public class ProductController {
	
	@Autowired
	private SubCategoryDaoService subCategoryDaoService;
	@Autowired
	private CategoryDaoService categoryDaoService;
	
	@PostMapping("subcategory")
	public String getSubCategory(@RequestParam("category")int category_id, Model model) {
		 
		model.addAttribute("subCategoryList",subCategoryDaoService.getSubcategory(category_id));
		model.addAttribute("categoryName",categoryDaoService.getCategoryById(category_id));
		return "subcategory";
		
	}
	@PostMapping("getModel")
	public String  addProducts() {
		
	}
	
}
