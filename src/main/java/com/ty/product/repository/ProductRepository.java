package com.ty.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.product.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	

	

}
