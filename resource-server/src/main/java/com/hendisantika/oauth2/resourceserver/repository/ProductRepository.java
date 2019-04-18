package com.hendisantika.oauth2.resourceserver.repository;

import com.hendisantika.oauth2.resourceserver.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : resource-server
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-19
 * Time: 06:35
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByNameLike(String name);

    List<Product> findAll();
}