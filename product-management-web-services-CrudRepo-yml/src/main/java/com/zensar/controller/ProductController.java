package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Product;
import com.zensar.service.ProductService;

@RestController
//@RequestMapping(produces= {MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {

	@Autowired
	private ProductService service;

	// @RequestMapping(value = "/products", method = RequestMethod.GET)
	@GetMapping("/products")
	public Iterable<Product> getAllProducts() {

		return service.getAllProducts();

	}

	// @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) {
		return service.getProduct(productId);
	}

	// @RequestMapping(value="/products",method=RequestMethod.POST)
	@PostMapping("/products")
	public Product insertProduct(@RequestBody Product product) {
		return service.insertProduct(product);
	}

	// @RequestMapping(value="/products/{productId}",method=RequestMethod.DELETE)
	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {

		service.deleteProduct(productId);
	}

	// @RequestMapping(value="/products/{productId}", method=RequestMethod.PUT)
	@PatchMapping("/products/{productId}")
	public void updateProduct(@PathVariable("productId") int productId, @RequestBody Product updatedproduct) {
		service.updateProduct(productId, updatedproduct);
	}

}
