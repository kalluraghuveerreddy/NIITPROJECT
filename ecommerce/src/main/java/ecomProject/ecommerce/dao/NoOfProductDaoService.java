package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.NoOfProducts;

public interface NoOfProductDaoService {
    
	public  boolean addNoOfProducts(NoOfProducts noOfProducts);
	public List<NoOfProducts> getNoOfProducts(int product_id);
	public NoOfProducts getNoOfProductsByNoOfproductsId(int  item_no);
}
