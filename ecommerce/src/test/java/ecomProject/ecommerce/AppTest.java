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
import ecomProject.ecommerce.dao.CustomerDaoService;
import ecomProject.ecommerce.dao.ProductDaoService;
import ecomProject.ecommerce.dao.SubCategoryDaoService;
import ecomProject.ecommerce.dao.VendorDaoService;
import ecomProject.ecommerce.dao.products.LaptopDaoService;
import ecomProject.ecommerce.daoImpl.SubCategoryDaoServiceImpl;
import ecomProject.ecommerce.model.Address;
import ecomProject.ecommerce.model.Category;
import ecomProject.ecommerce.model.Customer;
import ecomProject.ecommerce.model.Product;
import ecomProject.ecommerce.model.SubCategory;
import ecomProject.ecommerce.model.Vendor;
import ecomProject.ecommerce.model.products.Laptop;


@SpringJUnitConfig(classes = {Persistanceconfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
		
		@Autowired
	    private	Vendor vendor;
	
		@Autowired
		private SubCategory subCategory;
		
		@Autowired
		private Laptop laptop;
		@Autowired
	     private Customer customer;
	
		private Address address1;
	
		private Address address2;
		
		@Autowired
		private Category category;
		
		@Autowired
		private SubCategoryDaoService subCategoryDaoService;
		@Autowired
		private CategoryDaoService categoryDaoService;
		@Autowired
		private CustomerDaoService customerDaoService;
		@Autowired
		private VendorDaoService vendorDaoService;
		@Autowired
		private ProductDaoService productDaoService;
		
		@Autowired
		private  LaptopDaoService laptopDaoService;
		@Autowired
		private AddressDaoService addressDaoService;
	
	
	
		
		
		@Before
		public void setUp()
		{
			//AnnotationConfigApplicationContext annotationConfigApplicationContext= new AnnotationConfigApplicationContext(Persistanceconfig.class);
			
			
			vendor.setVendor_name("Raghuveer Reddy");
			vendor.setCompany_name("Amazon");
			vendor.setVendor_email("kalluraghureddy@outlook.com");
			vendor.setVendor_mobile("8978513016");
			vendor.setVendor_password("raghu123");
			
	       HashSet<Address> addresses=new HashSet<Address>();
	        address1=new Address();
			address1.setCity("New York");
			address1.setStreetName("Time sqare");
			address1.setPincode(5000098);
		    address1.setVendor(vendor);
			addresses.add(address1);
			
			address2=new Address();
			address2.setCity("Mumbai");
			address2.setStreetName("Electronic street");
			address2.setPincode(500058);
			address2.setVendor(vendor);
			addresses.add(address2);
		
		
             vendor.setAddresses(addresses);
           
		}
  
	 @Test
		public void addVendorTest()
		{
		   assertEquals("Vendor Insertion Failed",true,vendorDaoService.register(vendor));
		}	
	
       @Test
		public void getVendorByIdTest() {
			
    	   vendorDaoService.register(vendor);
			 assertEquals("Vendor Insertion Failed",vendor,vendorDaoService.getVendorById(vendor.getVendor_id()));
		}
	 
	  @Test
      public void getVendorByEmailTest() {
     	
		  vendorDaoService.register(vendor);
          assertEquals(vendor,vendorDaoService.getVendorByEmail(vendor.getVendor_email())); 
      }
        
		@Test
		public void updateVenodorTest() {
			 vendorDaoService.register(vendor);
			 assertEquals("Vendor updation Failed",true,vendorDaoService.updateVendor(vendor));
			 
		}
		
        @After
		public void deleteVendor()
		{
			vendorDaoService.deleteVendor(vendor);
		}
	 
}
