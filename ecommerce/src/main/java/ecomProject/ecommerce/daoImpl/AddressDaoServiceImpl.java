package ecomProject.ecommerce.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.AddressDaoService;
import ecomProject.ecommerce.model.Address;
@Component
@Transactional
public class AddressDaoServiceImpl implements AddressDaoService{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public boolean addAddress(Address address) {
		try {
			    sessionFactory.getCurrentSession().save(address);
			    return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteAddress(Address address) {
		try {
		    sessionFactory.getCurrentSession().delete(address);
		    return true;
	        } catch (Exception e) {
		      return false;
	          }
	}

	@Override
	public Address updateAddress(Address address) {
		try {
		       sessionFactory.getCurrentSession().update(address);
		       return address;
		   
	         } catch (Exception e) {
		        return null;
	           }
	}

	@Override
	public Address getAddress(int addressId) {
	try {
		  return sessionFactory.getCurrentSession().get(Address.class, addressId);
	     } catch (Exception e) {
		   return null;
	    }
	}
         
}
