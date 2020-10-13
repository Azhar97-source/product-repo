package com.zensar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.model.Product;
import com.zensar.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public Iterable<Product> getAllProducts() {

		return repository.findAll();
	}

	@Override
	public Product getProduct(int productId) {

		return repository.findById(productId).get();
	}

	@Override
	public Product insertProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {

		 repository.deleteById(productId);
	}

	@Override
	public void updateProduct(int productId, Product updatedproduct) {
		Product product=repository.findById(productId).get();
		product.setProductId(updatedproduct.getProductId());
		product.setProductName(updatedproduct.getProductName());
		product.setProductCost(updatedproduct.getProductCost());
		repository.save(product);
	}

}
