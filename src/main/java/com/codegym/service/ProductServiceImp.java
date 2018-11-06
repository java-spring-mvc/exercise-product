package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements ProductService {

    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"san pham 1",2000.00));
        products.put(2, new Product(2, "san pham 2", 3000.00));
        products.put(3, new Product(3,"san pham 3", 40000.00));
        products.put(4, new Product(4, "san pham 4", 50000.00));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }


}
