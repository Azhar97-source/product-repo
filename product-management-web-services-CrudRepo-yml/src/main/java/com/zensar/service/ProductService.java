package com.zensar.service;

import com.zensar.model.Product;

public interface ProductService {

	public Iterable<Product> getAllProducts();

	public Product getProduct(int productId);

	public Product insertProduct(Product product);

	public void deleteProduct(int productId);

	public void updateProduct(int productId, Product updatedproduct);

}
