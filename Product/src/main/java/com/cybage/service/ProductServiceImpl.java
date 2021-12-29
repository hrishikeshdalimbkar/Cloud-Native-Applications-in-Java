package com.cybage.service;

import java.util.List;

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
	public Product getProduct(int productId) {
		return productRepository.findById(productId).get();
	}

	@Override
	public List<Product> getProductIds(int categoryId) {
		return productRepository.findByCatId(categoryId);
	}

}
