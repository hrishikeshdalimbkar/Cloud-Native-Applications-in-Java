package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return productService.getProduct(productId);
	}

	@GetMapping("/productIds")
	public List<Product> getProductIds(@RequestParam("id") Integer categoryId) {
		return productService.getProductIds(categoryId);
	}

	@PostMapping("/")
	public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.insertProduct(product), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer productId, @RequestBody Product product) {
		return new ResponseEntity<>(productService.updateProduct(productId, product), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
	}

}
