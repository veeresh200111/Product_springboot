package com.ty.product.product_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.product.dto.Product;
import com.ty.product.product_service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	
	//save product
	@PostMapping("/products")
	public ResponseEntity<Object> saveProduct(@RequestBody Product product){
		return service.saveProduct(product);
		
	}
	
	@PostMapping("/products/many")
	public ResponseEntity<Object> saveProducts(@RequestBody List<Product> product){
		return service.saveProducts(product);
	}
	
	@GetMapping("/products")
	public ResponseEntity<Object> featchAll(){
		return service.featchAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Object> featchById(@PathVariable int id){
		return service.featchById(id);
	}
	

}
