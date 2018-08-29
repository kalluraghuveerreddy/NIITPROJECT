package ecomProject.ecommerce;

import static org.junit.Assert.assertEquals;

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
		@Autowired
		private Address address1;
		@Autowired
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
		public void setVendor()
		{
			//AnnotationConfigApplicationContext annotationConfigApplicationContext= new AnnotationConfigApplicationContext(Persistanceconfig.class);
			
			
			vendor.setVendor_name("Rishikesa");
			vendor.setCompany_name("niit");
			vendor.setVendor_email("rishi@gmail.com");
			vendor.setVendor_mobile("8978513016");
			vendor.setVendor_password("rishi123");
			
			
			/*laptop.setHarddisk("1TB");
			laptop.setLaptopName("MacBoook");
			laptop.setProcessor("i7");
			laptop.setRam("8GB");
			laptop.setProduct_name("laptop");
			laptop.setProduct_price(50000);*/
			
	       HashSet<Address> addresses=new HashSet<Address>();
			address1.setCity("bangalore");
			address1.setStreetName("marathali");
			address1.setPincode(250065);
			addresses.add(address1);
			
			
			address2.setCity("hyderabad");
			address2.setStreetName("Champapet");
			address2.setPincode(500059);
			addresses.add(address2);
		
           vendor.setAddress(addresses);
	
		   
	       
		}
  
	  @Test
		public void addVendorTest()
		{
		  
		   assertEquals("Vendor Insertion Failed",true,vendorDaoService.addVendor(vendor));
		   //deleteVendor();
		}	
	
/*		@Test
		public void getVendorTest() {
			 vendorDaoService.addVendor(vendor);
			 assertEquals("Vendor Insertion Failed",vendor,vendorDaoService.getVendor(vendor.getVendor_id()));
			 deleteVendor();
		}
		@Test
		public void updateVenodorTest() {
			 vendorDaoService.addVendor(vendor);
			 vendor.setVendor_email("rishi@yahoo.com");
			 assertEquals("Vendor Insertion Failed",true,vendorDaoService.updateVendor(vendor));
			deleteVendor();
			
		}*/
		
	
		/*@Test
		public void addLaptop()
		{
		
			subCategory=subCategoryDaoService.getSubCategory(1);
			vendorDaoService.addVendor(vendor);
			laptop.setVendor(vendor);
			laptop.setSubCategory(subCategory);
		
			assertEquals("Test Insertion laptop failed",true,laptopDaoService.addLaptop(laptop));
		
			deleteLaptop();
			deleteVendor();
			
		}*/
	
		private void deleteLaptop() {
			
			laptopDaoService.deleteLaptop(laptop);
			
		}

		public void deleteVendor()
		{
			vendorDaoService.deleteVendor(vendor);
		}
		
	
		
}
