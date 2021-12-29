package com.cybage.dao;

import com.cybage.pojo.Product;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Cacheable("productsByCategoryCache")
	List<Product> findByCatId(int catId);

	@CacheEvict(cacheNames = "productsByCategoryCache", key = "#result?.catId")
	Product save(Product product);

	@CacheEvict(cacheNames = "productsByCategoryCache", key = "#p0.catId")
	void delete(Product product);

}
