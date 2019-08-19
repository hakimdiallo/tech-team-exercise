package com.soul.backend.tech.team.exercise.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.soul.backend.tech.team.exercise.model.dto.Product;
import com.soul.backend.tech.team.exercise.services.IProductService;

@RestController
@CrossOrigin
@RequestMapping(value="/api/")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("productIds")
	public ResponseEntity<Set<Integer>> getProductIds(){
		
		return new ResponseEntity<Set<Integer>>(productService.getProductIds(), HttpStatus.OK);
	}
	
	@GetMapping("products")
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<List<Product>>(productService.getProducts(), HttpStatus.OK);
	}

	@GetMapping(value="product/{id}")
	public ResponseEntity<List<Product>> getProductById(@PathVariable int id){
		return new ResponseEntity<List<Product>>(productService.getProduct(id), HttpStatus.OK);
	}
}
