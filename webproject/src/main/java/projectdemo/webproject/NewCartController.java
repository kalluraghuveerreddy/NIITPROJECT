package projectdemo.webproject;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ecomProject.ecommerce.dao.CartDaoService;
import ecomProject.ecommerce.dao.CustomerDaoService;
import ecomProject.ecommerce.dao.NoOfProductDaoService;
import ecomProject.ecommerce.dao.ProductDaoService;
import ecomProject.ecommerce.model.Cart;
import ecomProject.ecommerce.model.CartItemId;
import ecomProject.ecommerce.model.CartItems;
import ecomProject.ecommerce.model.Customer;
import ecomProject.ecommerce.model.NoOfProducts;


public class NewCartController {

	/*@Autowired
	private CustomerDaoService customerDaoService;

	@Autowired
	private ProductDaoService productDaoService;
	
	@Autowired
	private CartDaoService cartDaoService;
	
	@Autowired
	private NoOfProductDaoService noOfProductDaoService;
	
	@GetMapping("/customer/cart")
	public String cart(HttpServletRequest request, Principal principal) {

		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int quantity = Integer.parseInt(request.getParameter("noOfProducts"));

		Customer customer = customerDaoService.getCustomerByEmail(principal.getName());
		int customer_id = customer.getCustomer_id();

		int unitPrice = productDaoService.getProduct(product_id).getProduct_price();
		
		int totalPrice=quantity*unitPrice;
		
		List<NoOfProducts> productsList=noOfProductDaoService.getNoOfProducts(product_id);
		
	Cart cart=cartDaoService.getCart(customer_id);
	
	if(cart==null) {
		cart=new Cart();
		cart.setCustomer(customer);
		cart.setNoOfItems(quantity);
		cart.setNetPrice(totalPrice);
		
		List<CartItems> cartItemsList=new ArrayList<CartItems>();
		CartItems cartItems=new CartItems();
		cartItems.setCart(cart);
		cartItems.setQuantity(quantity);
		cartItems.setUnitPrice(unitPrice);
		cartItems.setTotalPrice(totalPrice);
		
		List<CartItemId> cartItemIdsList=new ArrayList<CartItemId>();
		
		for(int i=0;i<quantity;i++) {
			CartItemId cartItemId=new CartItemId();
			cartItemId.setCartItems(cartItems);
			NoOfProducts noOfProducts=productsList.get(i);
			noOfProducts.setSold(true);
			noOfProductDaoService.update(noOfProducts);
			cartItemId.setNoOfProducts(noOfProducts);
			cartItemIdsList.add(cartItemId);
		}
		
		cartItems.setCartItemIds(cartItemIdsList);
		
		cartItemsList.add(cartItems);
		
		cart.setCartItems(cartItemsList);
		
		if(cartDaoService.addCart(cart)) {
			
			return "redirect:/customer/cart";
			
		}
		else {
			return  "redirect:/customer/customerindex";
		}
		
	}else if(cart!=null) {
		
		if(checkIfCartItemAlreadyExists(cart, product_id)) {
			
		}else {
			
			CartItems cartItems=new CartItems();
			cartItems.setCart(cart);
			cartItems.setQuantity(quantity);
			cartItems.setUnitPrice(unitPrice);
			cartItems.setTotalPrice(totalPrice);
			
			List<CartItems> cartItemsList=cart.getCartItems();
		    List<CartItemId> cartItemIdList=new ArrayList<CartItemId>();
		    
		    for(int i=0;i<quantity;i++) {
		    	CartItemId cartItemId=new CartItemId();
		    	cartItemId.setCartItems(cartItems);
		    	NoOfProducts noOfProducts=productsList.get(i);
		    	noOfProducts.setSold(true);
		    	noOfProductDaoService.update(noOfProducts);
		    	cartItemId.setNoOfProducts(noOfProducts);
		    	cartItemIdList.add(cartItemId);
		    }
		    cartItems.setCartItemIds(cartItemIdList);
		   
		    if(cartItemsList==null) {
		    	cartItemsList=new ArrayList<CartItems>();
		    	cartItemsList.add(cartItems);
		    }else {
		    	cartItemsList.add(cartItems);
		    }
		    
		    cart.setCartItems(cartItemsList);
		    cart.setNoOfItems(cart.getNoOfItems()+quantity);
		    cart.setNetPrice(cart.getNetPrice()+totalPrice);
		    
		    if(cartDaoService.updateCart(cart)) {
		    	return "redirect:/customer/cart";
		    }else {
		    	return  "redirect:/customer/customerindex";
		    }
		}
		
	}

		return "";
	}





public boolean checkIfCartItemAlreadyExists(Cart cart,int productId) {

	List<CartItems> cartItemsList=cart.getCartItems();
	for(CartItems items:cartItemsList) {
		if(items.getCartItemIds().get(0).getNoOfProducts().getProduct().getProduct_id()==productId) {
			return true;
		}
	}
	return false;
}

@GetMapping("customer/cart")
public String displayCart(Principal principal, HttpSession session, Model model) {
	Customer customer = customerDaoService.getCustomerByEmail(principal.getName());
	Cart cart = cartDaoService.getCart(customer.getCustomer_id());

	model.addAttribute("cart", cart);

	return "cart";
}
*/
}
