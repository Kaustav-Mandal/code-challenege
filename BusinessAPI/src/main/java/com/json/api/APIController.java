package com.json.api;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.json.api.entities.Product;
import com.json.api.repos.ProductRepository;

@RestController
@RequestMapping("/api")
public class APIController 
{
	private static ArrayList<Product> cart = new ArrayList<Product>();
	private static HashMap<Integer, ArrayList<Product>> order = new HashMap<Integer, ArrayList<Product>>();
	@Autowired
	ProductRepository productrepo;
	
	@GetMapping
	public ResponseEntity<ArrayList<Product>> getAllRecipes()
	{
		ArrayList<Product> allProducts = (ArrayList<Product>) productrepo.findAll();
		return new ResponseEntity<ArrayList<Product>>(allProducts, HttpStatus.OK);
	}
	
	/*
	 * Adding product to the cart. 
	 */
	@PostMapping("/cart/products/{product-id}")
	public ResponseEntity<Object> addProductToCart(@PathVariable("product-id") int pid)
	{
		Product product = productrepo.getById(pid);
		if(product != null)
		{
			cart.add(product);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	/*
	 * Retrieve list of products from the cart. 
	 */
	@GetMapping("/cart")
	public ResponseEntity<Object> retrieveProductsFromCart()
	{
		if(cart.size() > 0)
			return new ResponseEntity<Object>(cart,HttpStatus.OK); 
		else
			return new ResponseEntity<Object>(HttpStatus.OK); 
		
	}
	
	/*
	 * Make order from Cart. 
	 */
	@PostMapping("/order")
	public ResponseEntity<Object> addProductToOrder()
	{
		if(cart.size() > 0)
		{
			int totalNoOfOrders = order.size();
			ArrayList<Product> products = new ArrayList<>();
			for(Product p : cart)
			{
				products.add(new Product(p.getId(), p.getProduct_category(), p.getProduct_label(), p.getDownloadURL(), p.getWeight()));
			}
			order.put(totalNoOfOrders+1, products);
			//Removing all items from cart after items have been moved to order. 
			cart.clear();
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
			
	}
	/*
	 *Retrieve all the products of of an order.  
	 */
	@GetMapping("/order/{order-id}")
	public ResponseEntity<Object> findProductsOforder(@PathVariable("order-id") int oid)
	{
		if(order.size() > 0)
		{
			return new ResponseEntity<Object>(order.get(oid), HttpStatus.OK);
		}
		else
			return new ResponseEntity<Object>(HttpStatus.OK); 
			
	}
}
