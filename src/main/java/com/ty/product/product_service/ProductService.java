package com.ty.product.product_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.product.dto.Product;
import com.ty.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;

	public ResponseEntity<Object> saveProduct(Product product) {
		repository.save(product);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Added success");
		map.put("data",product);
		return new ResponseEntity<Object>(map,HttpStatus.CREATED);
	}

	public ResponseEntity<Object> saveProducts(List<Product> product) {
		repository.saveAll(product);
		Map<String , Object>map = new HashMap<String, Object>();
		map.put("message", "Product Added Success");
		map.put("data", product);
		return new ResponseEntity<Object>(map,HttpStatus.CREATED);
	}

	public ResponseEntity<Object> featchAll() {
		List<Product> list=repository.findAll();
		if(list.isEmpty()) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found");
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}else {
			Map<String, Object>map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);
		return new ResponseEntity<Object>(map,HttpStatus.FOUND);
		}
	}

	public ResponseEntity<Object> featchById(int id) {
		Optional<Product> optional= repository.findById(id);
		if(optional.isEmpty()) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found");
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}else {
			Map<String, Object>map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", optional.get());
		return new ResponseEntity<Object>(map,HttpStatus.FOUND);
			
		}
	}

}
