package ecomProject.ecommerce.dao.products;

import ecomProject.ecommerce.model.products.Mobile;

public interface MobileDaoService {

	public boolean addMobile(Mobile mobile);
	public boolean deleteMobile(Mobile mobile);
	public boolean updateMobile(Mobile mobile);
}
