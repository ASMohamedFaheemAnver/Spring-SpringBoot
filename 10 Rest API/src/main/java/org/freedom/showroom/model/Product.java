package org.freedom.showroom.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "products")
@Entity(name = "products")
public class Product {

	@Id
	int product_id;
	@ManyToOne(targetEntity = Brand.class)
	@JoinColumn(name = "brand_id")
	Brand brand_entity;
	String product_name;
	String category;
	String cost;

	public Product() {

	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Brand getBrand_entity() {
		return brand_entity;
	}

	public void setBrand_entity(Brand brand_entity) {
		this.brand_entity = brand_entity;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

}
