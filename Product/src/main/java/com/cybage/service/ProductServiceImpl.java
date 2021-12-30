package com.cybage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.ProductRepository;
import com.cybage.pojo.Product;

@Service
public class ProductServiceImpl implements IProductService {

	public ProductServiceImpl() {
		System.out.println("in ctr of Product Service");
	}

	@Autowired
	ProductRepository productRepository;

	@Override
	public Optional<Product> getProduct(int productId) {
		return productRepository.findById(productId);
	}

	@Override
	public List<Product> getProductIds(int categoryId) {
		return productRepository.findByCatId(categoryId);
	}

	@Override
	public Product insertProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

}
