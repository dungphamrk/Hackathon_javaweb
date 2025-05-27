package com.data.hackathon.service;

import com.data.hackathon.model.Category;
import com.data.hackathon.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    void insert(Product product);
    void update(Product product);
    void delete(int id);
}
