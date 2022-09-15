package com.ipap.springcustomannotations.service;

import com.ipap.springcustomannotations.advice.LogExecutionTime;
import com.ipap.springcustomannotations.entity.Product;
import com.ipap.springcustomannotations.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void initDB() {
        List<Product> list = new ArrayList<>();
        IntStream.rangeClosed(1, 10000).forEach(integer -> list.add(new Product("product" + integer)));
        productRepository.saveAll(list);
    }

    @LogExecutionTime
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @LogExecutionTime
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
