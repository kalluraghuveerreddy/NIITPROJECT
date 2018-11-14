package projectdemo.webproject;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ecomProject.ecommerce.dao.AdminDaoService;
import ecomProject.ecommerce.dao.CartDaoService;
import ecomProject.ecommerce.dao.CartItemIdDaoService;
import ecomProject.ecommerce.dao.CartItemsDaoService;
import ecomProject.ecommerce.dao.CategoryDaoService;
import ecomProject.ecommerce.dao.CustomerDaoService;
import ecomProject.ecommerce.dao.NoOfProductDaoService;
import ecomProject.ecommerce.dao.ProductDaoService;
import ecomProject.ecommerce.dao.SubCategoryDaoService;
import ecomProject.ecommerce.dao.VendorDaoService;
import ecomProject.ecommerce.dao.products.AirConditionerDaoService;
import ecomProject.ecommerce.dao.products.KurtaDaoService;
import ecomProject.ecommerce.dao.products.LaptopDaoService;
import ecomProject.ecommerce.dao.products.MobileDaoService;
import ecomProject.ecommerce.dao.products.PantDaoService;
import ecomProject.ecommerce.dao.products.RefrigeratorDaoService;
import ecomProject.ecommerce.dao.products.ShirtDaoService;
import ecomProject.ecommerce.model.Cart;
import ecomProject.ecommerce.model.CartItemId;
import ecomProject.ecommerce.model.CartItems;
import ecomProject.ecommerce.model.Customer;
import ecomProject.ecommerce.model.NoOfProducts;
import ecomProject.ecommerce.model.Product;
import ecomProject.ecommerce.model.products.Laptop;

@Controller
public class CartController {

	@Autowired
	private NoOfProductDaoService noOfProductDaoService;

	@Autowired
	private CustomerDaoService customerDaoService;

	@Autowired
	private CartDaoService cartDaoService;

	@Autowired
	private CartItems cartItems;

	@Autowired
	private Customer customer;

	@Autowired
	private CartItemsDaoService cartItemsDaoService;

	@Autowired
	private CartItemId cartItemId;

	@Autowired
	private CartItemIdDaoService cartItemIdDaoService;

	@Autowired
	private ProductDaoService productDaoService;

	@Autowired
	private Cart cart;

	@Autowired
	private SessionFactory sessionFactory;

	private NoOfProducts noOfProducts;

	@GetMapping("/customer/addtocart")
	public String addToCart(Principal principal, HttpServletRequest request) {

		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int quantity = Integer.parseInt(request.getParameter("noOfProducts"));
		int unitprice = productDaoService.getProduct(product_id).getProduct_price();
		Product product = productDaoService.getProduct(product_id);
		customer = customerDaoService.getCustomerByEmail(principal.getName());

		if (checkAvailabilityOfProducts(product_id, quantity) == true) {

			cart = cartDaoService.getCart(customer.getCustomer_id());

			if (cart == null) {

				cart = new Cart();
				cartItems = new CartItems();
				List<CartItemId> cartItemIdList = new ArrayList<CartItemId>();
				List<CartItems> cartItemsList = new ArrayList<CartItems>();
				List<NoOfProducts> noOfProductsList = noOfProductDaoService.getNoOfProducts(product_id);

				for (int i = 0; i < quantity; i++) {

					cartItemId = new CartItemId();
					noOfProducts = new NoOfProducts();
					noOfProducts = noOfProductsList.get(i);
					noOfProducts.setSold(true);
					noOfProductDaoService.update(noOfProducts);
					cartItemId.setNoOfProducts(noOfProducts);
					cartItemId.setCartItems(cartItems);
					cartItemIdList.add(cartItemId);
				}
				cartItems.setUnitPrice(unitprice);
				cartItems.setTotalPrice(unitprice * quantity);
				cartItems.setQuantity(quantity);
				cartItems.setCartItemIds(cartItemIdList);
				cartItems.setCart(cart);
				cartItemsList.add(cartItems);
				cart.setCartItems(cartItemsList);
				cart.setCustomer(customer);
				cart.setNetPrice(quantity * unitprice);
				cart.setNoOfItems(quantity);
				cartDaoService.addCart(cart);

				return "redirect:/customer/cart";

			} else {

				cartItems = checkIfProductAlreadyExists(product_id, cart);

				if (cartItems != null) {

					List<CartItemId> cartItemIdsList = new ArrayList<CartItemId>();
					List<CartItems> cartItemsList = new ArrayList<CartItems>();
					cartItemsList = cart.getCartItems();
					int position = cartItemsList.indexOf(cartItems);
					List<NoOfProducts> noOfProductsList = noOfProductDaoService.getNoOfProducts(product_id);
					cartItemIdsList = cartItemIdDaoService.getAllCartItemId(cartItems.getCartItem_id());

					for (int i = 0; i < quantity; i++) {

						cartItemId = new CartItemId();
						noOfProducts = new NoOfProducts();
						noOfProducts = noOfProductsList.get(i);
						noOfProducts.setSold(true);
						noOfProductDaoService.update(noOfProducts);
						cartItemId.setNoOfProducts(noOfProducts);
						cartItemId.setCartItems(cartItems);
						cartItemIdsList.add(cartItemId);
					}
					cartItems.setCartItemIds(cartItemIdsList);
					cartItemsList.add(position, cartItems);
					cart.setCartItems(cartItemsList);
					cart.setNetPrice((quantity * unitprice) + cart.getNetPrice());
					cart.setNoOfItems(quantity + cart.getNoOfItems());
					cartDaoService.updateCart(cart);

					return "redirect:/customer/cart";
				} else {

					cartItems = new CartItems();
					List<CartItemId> cartItemIdsList = new ArrayList<CartItemId>();
					List<CartItems> cartItemsList = new ArrayList<CartItems>();
					List<NoOfProducts> numberOfProductsList = noOfProductDaoService.getNoOfProducts(product_id);
					for (int i = 0; i < quantity; i++) {

						cartItemId = new CartItemId();
						noOfProducts = new NoOfProducts();
						noOfProducts = numberOfProductsList.get(i);
						noOfProducts.setSold(true);
						noOfProductDaoService.update(noOfProducts);
						cartItemId.setNoOfProducts(noOfProducts);
						cartItemId.setCartItems(cartItems);
						cartItemIdsList.add(cartItemId);
					}
					cartItems.setUnitPrice(unitprice);
					cartItems.setTotalPrice(unitprice * quantity);
					cartItems.setQuantity(quantity);
					cartItems.setCartItemIds(cartItemIdsList);
					cartItems.setCart(cart);
					cartItemsList.add(cartItems);
					cart.setCartItems(cartItemsList);
					cart.setNetPrice((quantity * unitprice) + cart.getNetPrice());
					cart.setNoOfItems(quantity + cart.getNoOfItems());
					cartDaoService.updateCart(cart);
					return "redirect:/customer/cart";
				}

			}

		} else {

			return "redirect:/customer/customerindex";
		}

	}

	public CartItems checkIfProductAlreadyExists(int product_id, Cart cart) {

		List<CartItems> cartItemsList = cart.getCartItems();
		for (CartItems items : cartItemsList) {
			if (items.getCartItemIds().get(0).getNoOfProducts().getProduct().getProduct_id() == product_id) {
				return items;
			}
		}
		return null;
	}

	public boolean checkAvailabilityOfProducts(int product_id, int quantity) {

		if (noOfProductDaoService.getNoOfProducts(product_id).size() >= quantity) {
			return true;
		} else {
			return false;
		}
	}

	@GetMapping("customer/cart")
	public String displayCart(Principal principal, HttpSession session, Model model) {
		Customer customer = customerDaoService.getCustomerByEmail(principal.getName());
		System.out.println(customer.getCustomer_id());
		Cart cart = cartDaoService.getCart(customer.getCustomer_id());

		model.addAttribute("cart", cart);

		return "cart";
	}

	@GetMapping("customer/{cartItem_id}")
	public String deleteCart(@PathVariable("cartItem_id") int cartItem_id, Principal principal) {

		int cart_id = cartItemsDaoService.getCartItems(cartItem_id).getCart().getCart_id();
		List<CartItemId> cartItemIdList = cartItemsDaoService.getCartItems(cartItem_id).getCartItemIds();
		if (cartItemsDaoService.deleteCartItem(cartItemsDaoService.getCartItems(cartItem_id))) {

			NoOfProducts noOfProducts = null;
			for (CartItemId cartItemId : cartItemIdList) {
				noOfProducts = cartItemId.getNoOfProducts();
				noOfProducts.setSold(false);
				noOfProductDaoService.update(noOfProducts);

			}
			Customer customer = customerDaoService.getCustomerByEmail(principal.getName());

			Cart cart = cartDaoService.getCart(customer.getCustomer_id());
			List<CartItems> cartItemsList = cartItemsDaoService.getAllCartItemsByCartId(cart.getCart_id());
			int quantity = 0;
			int price = 0;
			for (CartItems cartItems : cartItemsList) {

				quantity = quantity + cartItems.getQuantity();
				price = price + cartItems.getTotalPrice();
			}
			cart.setNoOfItems(quantity);
			cart.setNetPrice(price);
			cartDaoService.updateCart(cart);

			return "redirect:/customer/cart";
		}
		return "redirect:/customer/customerindex";

	}

	@GetMapping("customer/updatequantity")
	public String updateCart(HttpServletRequest request) {

		int prevQuantity = cartItemsDaoService.getCartItems(Integer.parseInt(request.getParameter("cartItem_id")))
				.getQuantity();
		int unitPrice = cartItemsDaoService.getCartItems(Integer.parseInt(request.getParameter("cartItem_id")))
				.getUnitPrice();
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int cartItem_id = Integer.parseInt(request.getParameter("cartItem_id"));

		CartItems cartItems = cartItemsDaoService.getCartItems(cartItem_id);
		Cart cart = cartItems.getCart();
		System.out.println(cart.getCart_id());

		int product_id = cartItems.getCartItemIds().get(0).getNoOfProducts().getProduct().getProduct_id();
		List<CartItems> cartItemsList = cartItemsDaoService.getAllCartItemsByCartId(cartItems.getCart().getCart_id());

		List<CartItemId> cartItemIdList = cartItems.getCartItemIds();
		List<NoOfProducts> noOfProductsList = noOfProductDaoService.getNoOfProducts(product_id);
		List<NoOfProducts> allNoOfProductsList=noOfProductDaoService.getAllNoOfProducts(product_id);
				
		int updatedQuantity = 0;

		System.out.println(prevQuantity + "   " + quantity);

		if (prevQuantity > quantity) {

			updatedQuantity = prevQuantity - quantity;

			for (int i = 0; i < updatedQuantity; i++) {

				noOfProducts = new NoOfProducts();
				noOfProducts = allNoOfProductsList.get(i);

				noOfProducts.setSold(false);
				noOfProductDaoService.update(noOfProducts);
				cartItemIdList.remove(i);

			}
			cartItems.setQuantity(prevQuantity - updatedQuantity);
			cartItems.setTotalPrice(cartItems.getTotalPrice() - (updatedQuantity * unitPrice));
			cartItems.setCart(cart);
			cartItems.setUnitPrice(unitPrice);
			cartItemsDaoService.updateCartItem(cartItems);
			/*cartItems.setCartItemIds(cartItemIdList);*/
	/*		cartItemsList.add(cartItems);*/
		/*	cart.setCartItems(cartItemsList);*/
			cart.setNoOfItems(cart.getNoOfItems() - updatedQuantity);
			cart.setNetPrice(cart.getNetPrice() - (updatedQuantity * unitPrice));
			cartDaoService.updateCart(cart);

			return "redirect:/customer/cart";

		} else if (prevQuantity < quantity) {
			updatedQuantity = quantity - prevQuantity;
			if (checkAvailabilityOfProducts(product_id, updatedQuantity)) {

				for (int i = 0; i < updatedQuantity; i++) {

					CartItemId cartItemId = new CartItemId();

					noOfProducts = new NoOfProducts();
					noOfProducts = noOfProductsList.get(i);
					noOfProducts.setSold(true);
					noOfProductDaoService.update(noOfProducts);
					cartItemId.setNoOfProducts(noOfProducts);
					cartItemId.setCartItems(cartItems);
					cartItemIdList.add(cartItemId);

				}
				cartItems.setQuantity(updatedQuantity + prevQuantity);
				cartItems.setTotalPrice(updatedQuantity * unitPrice + cartItems.getTotalPrice());
				cartItems.setCart(cart);
				cartItems.setUnitPrice(unitPrice);
				cartItemsDaoService.updateCartItem(cartItems);
			/*	cartItems.setCartItemIds(cartItemIdList);
				cartItemsList.add(cartItems);
				cart.setCartItems(cartItemsList);*/
				cart.setNoOfItems(updatedQuantity + cart.getNoOfItems());
				cart.setNetPrice(updatedQuantity * unitPrice + cart.getNetPrice());
				cartDaoService.updateCart(cart);
				return "redirect:/customer/cart";
			} else {
				return "redirect:/customer/customerindex";
			}

		} else {
			updatedQuantity = prevQuantity;
			return "redirect:/customer/cart";
		}

	}
}
