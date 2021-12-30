package com.cybage.service;

import java.util.List;

import com.cybage.pojo.Product;

public interface IProductService {

	java.util.Optional<Product> getProduct(int productId);

	List<Product> getProductIds(int categoryId);

	Product insertProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(Product product);

}
