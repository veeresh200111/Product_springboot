package com.ty.product.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String discription;
	private int stock;
	private double price;
}
