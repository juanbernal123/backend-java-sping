package com.products.core.productsbackend.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.core.productsbackend.models.ProductModel;
import com.products.core.productsbackend.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping()
	public ArrayList<ProductModel> index() {
		return (ArrayList<ProductModel>) productService.getProducts();
	}

	@PostMapping
	public ProductModel store(@Valid @RequestBody ProductModel product) {
		return this.productService.store(product);
	}


}
