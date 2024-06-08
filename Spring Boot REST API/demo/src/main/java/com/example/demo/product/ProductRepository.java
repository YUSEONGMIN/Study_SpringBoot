package com.example.demo.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

// @Repository
public class ProductRepository {

    @Autowired
    EntityManager entityManager;
    // import jakarta.persistence <- 영속성

    // @Autowired
    // DataSource dataSource; //jdbc에서 사용한 객체

    
    // Id(Int), Name(Str)
    // 1        NoteBook
    // private Map<Integer, String> db = new HashMap<>();
    // Map은 인터페이스 -> 여러 구현체를 사용할 수 있다. 가장 빠른 구현체는 HashMap
    private Map<Integer, Product> db = new HashMap<>();
    
    private int id = 1;


    // // dataSource로 터널 뚫어보기 (=DB와 커넥션 만들기)
    // public void makeConnection() {
    //     DataSourceUtils.getConnection(dataSource);
    // }

    // 개별 조회
    // public String findProduct(int idx) {
    public Product findProduct(int idx) {
        // return "NoteBook";
        return db.get(idx);
    }

    // 상품 등록
    // public void save(String productName) {
    public void save(Product product) {
        // db.put(id++, "Notebook");
        // id 값은 자동으로 증가 1, 2, ...
        // db.put(id++, productName);
        db.put(id++, product);
        System.out.println(product.getName());
    }

    // 전체 조회
    public List<Product> findProducts() {        
        // return new ArrayList<>(db.values());
        // List 생성자를 이용. db는 Map 형태로 key(id), value(Product)로 되어 있음
        // Product 객체들이 모여 리스트가 됨

        // Map으로 구현된 db가 아닌 진짜 db로 조회하기
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> products = query.getResultList();
        return products;
    }
}
