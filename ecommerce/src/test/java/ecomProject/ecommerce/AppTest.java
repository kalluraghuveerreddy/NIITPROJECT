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
import ecomProject.ecommerce.dao.AdminDaoService;
import ecomProject.ecommerce.dao.CategoryDaoService;
import ecomProject.ecommerce.dao.CustomerDaoService;
import ecomProject.ecommerce.dao.SubCategoryDaoService;

import ecomProject.ecommerce.dao.VendorDaoService;
import ecomProject.ecommerce.dao.products.LaptopDaoService;
import ecomProject.ecommerce.daoImpl.SubCategoryDaoServiceImpl;
import ecomProject.ecommerce.model.VendorAddress;
import ecomProject.ecommerce.model.AdminPerson;
import ecomProject.ecommerce.model.Category;


import ecomProject.ecommerce.model.SubCategory;
import ecomProject.ecommerce.model.Customer;
import ecomProject.ecommerce.model.Product;
import ecomProject.ecommerce.model.Vendor;
import ecomProject.ecommerce.model.products.Laptop;


@SpringJUnitConfig(classes = {Persistanceconfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
		
		private VendorAddress vendorAddress1;
	
		private VendorAddress vendorAddress2;
		
		@Autowired
		private Vendor vendor;
		@Autowired
		private VendorDaoService vendorDaoService;
		@Autowired
		private CustomerDaoService customerDaoService;
		@Autowired
		private Product product;
		@Autowired
		private AdminDaoService adminDaoService;
		@Autowired
		private AdminPerson adminPerson;
	
	
		@Before
		public void setUp()
		{
			//AnnotationConfigApplicationContext annotationConfigApplicationContext= new AnnotationConfigApplicationContext(Persistanceconfig.class);
			
		
			
			
			
			vendor.setVendor_name("ashok ");
			vendor.setVendor_mobile("9874563310");
			vendor.setVendor_email("ashok@gmail.com");
			vendor.setVendor_password("12345");
			vendor.setCompany_name("flipkart");
			
			HashSet<VendorAddress> vendorAddresses=new HashSet<VendorAddress>();
			vendorAddress1=new VendorAddress();
			vendorAddress1.setCity("Hyderabad");
			vendorAddress1.setStreetName("Bhanu nagar colony");
			vendorAddress1.setPincode(500059);
			vendorAddress1.setVendor(vendor);
			vendorAddresses.add(vendorAddress1);
			
			vendorAddress2=new VendorAddress();
			vendorAddress2.setCity("Hyderabad");
			vendorAddress2.setStreetName("RTCcolony");
			vendorAddress2.setPincode(500059);
			vendorAddress2.setVendor(vendor);
			vendorAddresses.add(vendorAddress2);
			
			vendor.setVendorAddress(vendorAddresses);
			
	      

		}
		
		@Test
		public void  registerVendorTest() {
			 assertEquals("vendor Insertion Failed",true,vendorDaoService.registerVendor(vendor));
		}

		
		
		@After
		public void  deleteVendorTest() {
			 assertEquals("vendor deletion Failed",true,vendorDaoService.delete(vendor));
		}
		
	
  
}
