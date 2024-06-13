package com.example.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface SpringDataJPAProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
}
