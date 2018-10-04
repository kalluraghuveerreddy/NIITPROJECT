package projectdemo.webproject;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	private VendorDaoService vendorDaoService;

	@Autowired
	private NoOfProductDaoService noOfProductDaoService;
	@Autowired
	private CustomerDaoService customerDaoService;
	@Autowired
	private CartDaoService cartDaoService;

	private CartItems cartItems;

	@Autowired
	private CartItemsDaoService cartItemsDaoService;

	private CartItemId cartItemId;
	@Autowired
	private CartItemIdDaoService cartItemIdDaoService;

	@Autowired
	private AdminDaoService adminDaoService;
	@Autowired
	private CategoryDaoService categoryDaoService;
	@Autowired
	private SubCategoryDaoService subCategoryDaoService;
	@Autowired
	private ProductDaoService productDaoService;

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

		if (checkAvailabilityOfProducts(product_id, quantity) == true) {

			Customer customer = customerDaoService.getCustomerByEmail(principal.getName());
            System.out.println(customer.getCustomer_id());
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

				return "cart";

			} else {

				cartItems = checkIfProductAlreadyExists(product_id, cart);

				if (cartItems != null) {

					List<CartItemId> cartItemIdsList = new ArrayList<CartItemId>();
					List<CartItems> cartItemsList = new ArrayList<CartItems>();
					cartItemsList = cart.getCartItems();
					int position = cartItemsList.indexOf(cartItems);
					List<NoOfProducts> noOfProductsList = noOfProductDaoService.getNoOfProducts(product_id);
					cartItemIdsList = cartItemIdDaoService.getAllCartItemIds(cartItems.getCartItem_id());
					for (int i = 0; i < quantity; i++) {
						cartItemId = new CartItemId();
						noOfProducts = new NoOfProducts();
						noOfProducts = noOfProductsList.get(i);
						noOfProducts.setSold(true);
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

					return "cart";
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
					return "cart";
				}

			}

		} else {

			return "redirect:/customer/customerindex";
		}

	}

	public CartItems checkIfProductAlreadyExists(int product_id, Cart cart) {
		List<CartItems> cartItemsList = cart.getCartItems();
		for (CartItems c : cartItemsList) {
			if (c.getCartItemIds().get(0).getNoOfProducts().getProduct().getProduct_id() == product_id) {
				return c;
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

}
