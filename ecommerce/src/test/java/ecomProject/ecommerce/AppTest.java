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

import ecomProject.ecommerce.dao.AddressDaoService;
import ecomProject.ecommerce.dao.CategoryDaoService;


import ecomProject.ecommerce.dao.SubCategoryDaoService;
import ecomProject.ecommerce.dao.UserDaoService;

import ecomProject.ecommerce.dao.products.LaptopDaoService;
import ecomProject.ecommerce.daoImpl.SubCategoryDaoServiceImpl;
import ecomProject.ecommerce.model.Address;
import ecomProject.ecommerce.model.Category;


import ecomProject.ecommerce.model.SubCategory;
import ecomProject.ecommerce.model.User;

import ecomProject.ecommerce.model.products.Laptop;


@SpringJUnitConfig(classes = {Persistanceconfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
		

		@Autowired
		private SubCategory subCategory;
		
		@Autowired
		private Laptop laptop;
	
		private Address address1;
	
		private Address address2;
		
		@Autowired
		private Category category;
		
		@Autowired
		private User user;
		
		@Autowired
		private SubCategoryDaoService subCategoryDaoService;
		@Autowired
		private CategoryDaoService categoryDaoService;
		@Autowired
		private  LaptopDaoService laptopDaoService;
		@Autowired
		private AddressDaoService addressDaoService;
		@Autowired
		private UserDaoService userDaoService;
	
	
		@Before
		public void setUp()
		{
			//AnnotationConfigApplicationContext annotationConfigApplicationContext= new AnnotationConfigApplicationContext(Persistanceconfig.class);
			
		
			user.setUserName("Akhil");
			user.setEmail("akhil@gmail.com");
			user.setMobile("6549871236");
			user.setPassword("123456");
			user.setRole("admin");
			
	       HashSet<Address> addresses=new HashSet<Address>();
	        address1=new Address();
			address1.setCity("New York");
			address1.setStreetName("Time sqare");
			address1.setPincode(5000098);
		     address1.setUser(user);
			addresses.add(address1);
			
			address2=new Address();
			address2.setCity("Mumbai");
			address2.setStreetName("Electronic street");
			address2.setPincode(500058);
			address2.setUser(user);
			addresses.add(address2);
			
			user.setAddresses(addresses);
		
		   

		}
		
		@Test
		public void addUserTest() {
			 assertEquals("user Insertion Failed",true,userDaoService.registerUser(user));
		}
	
  
}
