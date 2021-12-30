package com.cybage.controller;

import java.util.List;
import java.util.Optional;

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

import com.cybage.exception.BadRequestException;
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

	private Product findProduct(Integer productId) {
		Optional<Product> product = productService.getProduct(productId);
		if (product.isPresent())
			return product.get();
		else
			throw new BadRequestException(BadRequestException.ID_NOT_FOUND, "No product found for ID: " + productId);
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") Integer productId) {
		return findProduct(productId);
	}

	@GetMapping("/products")
	public List<Product> getProductIds(@RequestParam("id") Integer categoryId) {
		return productService.getProductIds(categoryId);
	}

	@PostMapping("/")
	public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.insertProduct(product), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer productId, @RequestBody Product product) {

		// First fetch an existing product and then modify it.
		Product existingProduct = findProduct(productId);

		// Now update it back
		existingProduct.setCatId(product.getCatId());
		existingProduct.setName(product.getName());

		return new ResponseEntity<>(productService.updateProduct(existingProduct), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer productId) {

		// First fetch an existing product and then delete it.
		Product existingProduct = findProduct(productId);

		// Return the deleted product
		productService.deleteProduct(existingProduct);

		return new ResponseEntity<>(existingProduct, HttpStatus.OK);
	}

}
