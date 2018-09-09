package ecomProject.ecommerce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ecomProject.ecommerce.dao.VendorAddressDaoService;
import ecomProject.ecommerce.dao.CategoryDaoService;


import ecomProject.ecommerce.dao.SubCategoryDaoService;
import ecomProject.ecommerce.dao.UserDaoService;
import ecomProject.ecommerce.dao.VendorDaoService;
import ecomProject.ecommerce.dao.products.LaptopDaoService;
import ecomProject.ecommerce.daoImpl.SubCategoryDaoServiceImpl;
import ecomProject.ecommerce.model.VendorAddress;
import ecomProject.ecommerce.model.Category;


import ecomProject.ecommerce.model.SubCategory;
import ecomProject.ecommerce.model.Customer;
import ecomProject.ecommerce.model.Vendor;
import ecomProject.ecommerce.model.products.Laptop;


@SpringJUnitConfig(classes = {Persistanceconfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
		

		@Autowired
		private SubCategory subCategory;
		
		private VendorAddress address1;
	
		private VendorAddress address2;
		
		@Autowired
		private Category category;
		
		@Autowired
		private Customer customer;
		
		@Autowired
		private Vendor vendor;
		
		@Autowired
		private SubCategoryDaoService subCategoryDaoService;
		@Autowired
		private CategoryDaoService categoryDaoService;
		@Autowired
		private  LaptopDaoService laptopDaoService;
		@Autowired
		private VendorAddressDaoService addressDaoService;
		@Autowired
		private UserDaoService customerDaoService;
		@Autowired
		private VendorDaoService vendorDaoService;
	
	
		@Before
		public void setUp()
		{
			//AnnotationConfigApplicationContext annotationConfigApplicationContext= new AnnotationConfigApplicationContext(Persistanceconfig.class);
			
		
			customer.setUserName("Akhil");
			customer.setEmail("akhil@gmail.com");
			customer.setMobile("6549871236");
			customer.setPassword("123456");
			
			
			vendor.setVendor_name("ashok");
			vendor.setVendor_mobile("9874563310");
			vendor.setVendor_email("ashok@gmail.com");
			vendor.setVendor_password("12345");
			vendor.setCompany_name("flipkart");
		
		
		}
		
		@Test
		public void  registerVendorTest() {
			 assertEquals("vendor Insertion Failed",true,vendorDaoService.registerVendor(vendor));
		}
		
	
  
}
