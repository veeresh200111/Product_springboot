package com.ty.product.product_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/products/name/{name}")
	public ResponseEntity<Object> featchByName(@PathVariable String name)
	{
		return service.featchByName(name);
	}
	
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id)
	{
		return service.deleteById(id);
	}
	
	@PutMapping("/products")
	public ResponseEntity<Object> update(@RequestBody Product product)
	{
		return service.updateProduct(product);
	}

	@PatchMapping("/products/{id}")
	public ResponseEntity<Object> update(@RequestBody Product product, @PathVariable int id){
		return service.update(product,id);
	}
}
