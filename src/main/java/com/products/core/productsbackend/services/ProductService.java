package com.products.core.productsbackend.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.core.productsbackend.models.ProductModel;
import com.products.core.productsbackend.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ArrayList<ProductModel> getProducts() {
        return (ArrayList<ProductModel>) productRepository.findAll();
    }

    public ProductModel store(ProductModel product) {
        return productRepository.save(product);
    }

}
