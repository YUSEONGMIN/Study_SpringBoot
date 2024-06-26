package com.example.demo.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service // @Service에는 이미 @Component가 있음
public class ProductService {

    @Autowired
    private SpringDataJPAProductRepository springDataJPAProductRepository;
    
//     // @Autowired
//     private ProductRepository productRepository;

//     @Autowired
//     ProductService(ProductRepository productRepository) {
//         this.productRepository = productRepository;
//     }
// // 생성자 주입 방법을 써도 필드가 필요하지 않은 것은 아님


    // public void makeConnection() {
    //     productRepository.makeConnection();
    // }

    // public String findProduct(int id) {
    public Product findProduct(int id) {
        // return "<h1>NoteBook!!</h1>";
        // return productRepository.findProduct(id);
        return springDataJPAProductRepository.findById(id).get();
    }

    @Transactional
    // public void saveProduct(String productName) {
    public void saveProduct(Product product) {
        // productRepository.save();
        // productRepository.save(productName);
        // productRepository.save(product);
        springDataJPAProductRepository.save(product);
    }

    public List<Product> findProducts() {
        // return productRepository.findProducts();
        return springDataJPAProductRepository.findAll();
    }
}
