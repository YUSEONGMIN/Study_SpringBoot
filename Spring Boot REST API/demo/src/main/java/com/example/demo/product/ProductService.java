package com.example.demo.product;

import org.springframework.stereotype.Service;

@Service // @Service에는 이미 @Component가 있음
public class ProductService {
    
    public String findProduct() {
        return "<h1>NoteBook!!</h1>";
    }
}
