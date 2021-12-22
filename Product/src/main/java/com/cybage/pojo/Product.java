package com.cybage.pojo;

import org.springframework.stereotype.Component;

@Component
public class Product {

	private int id = 0;
	private String name = "Orange";
	private int catId = 2;

	public Product() {

	}

	public Product(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

}
