package projectdemo.webproject;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ecomProject.ecommerce.dao.CartDaoService;
import ecomProject.ecommerce.dao.CartItemIdDaoService;
import ecomProject.ecommerce.dao.CartItemsDaoService;
import ecomProject.ecommerce.dao.CustomerDaoService;
import ecomProject.ecommerce.dao.OrderDaoService;
import ecomProject.ecommerce.dao.OrderedItemIdDaoService;
import ecomProject.ecommerce.dao.OrderedItemsDaoService;
import ecomProject.ecommerce.dao.ProductDaoService;
import ecomProject.ecommerce.model.Cart;
import ecomProject.ecommerce.model.CartItemId;
import ecomProject.ecommerce.model.CartItems;
import ecomProject.ecommerce.model.Customer;
import ecomProject.ecommerce.model.Product;

@Controller
public class OrderController {

	@Autowired
	private CustomerDaoService customerDaoService;

	@Autowired
	private CartDaoService cartDaoService;

	@Autowired
	private ProductDaoService productDaoService;
	@Autowired
	private CartItemIdDaoService cartItemIdDaoService;
	@Autowired
	private CartItemsDaoService cartItemsDaoService;


	@GetMapping("customer/ordernow")
	public String placeOrder(Principal principal, HttpSession session) {

		Customer customer = customerDaoService.getCustomerByEmail(principal.getName());
		int customer_id = customer.getCustomer_id();
		Cart cart = cartDaoService.getCart(customer_id);
		int product_id = cart.getCartItems().get(0).getCartItemIds().get(0).getNoOfProducts().getProduct()
				.getProduct_id();
		Product product = productDaoService.getProduct(product_id);
		CartItems cartItems = cartItemsDaoService.getCartItemByCartId(cart.getCart_id());
		CartItemId cartItemId = cartItemIdDaoService.getCartItemId(cartItems.getCartItem_id());

		session.setAttribute("cart", cart);
		session.setAttribute("cartItems", cartItems);

		return "orderpage";
	}


}
