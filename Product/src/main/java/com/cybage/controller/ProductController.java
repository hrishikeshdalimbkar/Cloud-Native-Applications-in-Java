package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.pojo.Product;
import com.cybage.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	public ProductController() {
		System.out.println("in ctr of Product controller");
	}

	@Autowired
	IProductService productService;

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") Integer productId) {
		System.out.println("get product");
		return productService.getProduct(productId);
	}

	@GetMapping("/productIds")
	public List<Integer> getProductIds(@RequestParam("id") Integer categoryId) {
		System.out.println("get product Ids");
		return productService.getProductIds(categoryId);
	}

}