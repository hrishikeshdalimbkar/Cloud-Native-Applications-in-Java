package com.cybage.service;

import java.util.Arrays;
import java.util.List;

import com.cybage.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Integer> getProductIds(int categoryId) {
		return Arrays.asList(categoryId + 1, categoryId + 2, categoryId + 3);
	}

}
