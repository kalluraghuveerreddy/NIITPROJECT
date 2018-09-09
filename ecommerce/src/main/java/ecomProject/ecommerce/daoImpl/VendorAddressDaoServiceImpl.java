package ecomProject.ecommerce.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.VendorAddressDaoService;
import ecomProject.ecommerce.model.VendorAddress;
@Component
@Transactional
public class VendorAddressDaoServiceImpl implements VendorAddressDaoService{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public boolean addAddress(VendorAddress vendorAddress) {
		try {
			    sessionFactory.getCurrentSession().save(vendorAddress);
			    return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteAddress(VendorAddress vendorAddress) {
		try {
		    sessionFactory.getCurrentSession().delete(vendorAddress);
		    return true;
	        } catch (Exception e) {
		      return false;
	          }
	}

	@Override
	public VendorAddress updateAddress(VendorAddress vendorAddress) {
		try {
		       sessionFactory.getCurrentSession().update(vendorAddress);
		       return vendorAddress;
		   
	         } catch (Exception e) {
		        return null;
	           }
	}

	@Override
	public VendorAddress getAddress(int vendorAddress_id) {
	try {
		  return sessionFactory.getCurrentSession().get(VendorAddress.class, vendorAddress_id);
	     } catch (Exception e) {
		   return null;
	    }
	}
         
}
