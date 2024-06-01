package com.example.demo.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    
    // Id(Int), Name(Str)
    // 1        NoteBook
    // private Map<Integer, String> db = new HashMap<>();
    // Map은 인터페이스 -> 여러 구현체를 사용할 수 있다. 가장 빠른 구현체는 HashMap
    private Map<Integer, Product> db = new HashMap<>();
    
    private int id = 1;

    // public String findProduct(int idx) {
    public Product findProduct(int idx) {
        // return "NoteBook";
        return db.get(idx);
    }

    // public void save(String productName) {
    public void save(Product product) {
        // db.put(id++, "Notebook");
        // id 값은 자동으로 증가 1, 2, ...
        // db.put(id++, productName);
        db.put(id++, product);
        System.out.println(product.getName());
    }
}
