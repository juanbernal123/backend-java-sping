package com.products.core.productsbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.products.core.productsbackend.models.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel, Integer> {
    
}
