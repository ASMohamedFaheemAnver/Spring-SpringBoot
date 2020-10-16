package org.freedom.showroom.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@Table(name="brands")
@Entity(name="brands")
public class BrandEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="brand_id")
	int brand_id;
	@Column(name="brand_name")
	String brand_name;

	public BrandEntity() {
		super();
	}

	public BrandEntity(int brand_id, String brand_name) {
		super();
		this.brand_id = brand_id;
		this.brand_name = brand_name;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

}
