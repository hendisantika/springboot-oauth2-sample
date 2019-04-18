package com.hendisantika.oauth2.resourceserver.controller;

import com.hendisantika.oauth2.resourceserver.domain.Product;
import com.hendisantika.oauth2.resourceserver.repository.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : resource-server
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-19
 * Time: 06:37
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
    public Product getProduct(@PathVariable("id") Long id) {
        return productRepository.findById(id)
                .orElse(null);
    }

}
