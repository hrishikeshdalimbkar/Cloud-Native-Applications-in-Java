package com.cybage.service;

import java.util.List;

import com.cybage.pojo.Product;

public interface IProductService {
	
	Product getProduct(int productId);
	
	List<Integer> getProductIds(int categoryId);

}
