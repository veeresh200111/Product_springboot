package com.ty.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.product.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByName(String name);

	

	

}
