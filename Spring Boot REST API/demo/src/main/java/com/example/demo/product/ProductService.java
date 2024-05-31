package com.example.demo.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    public String findProduct() {
        return "NoteBook!";
    }
}
