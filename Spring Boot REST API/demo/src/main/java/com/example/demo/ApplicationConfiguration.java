package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.product.ProductRepository;

@Configuration
public class ApplicationConfiguration {
    
    @Bean // 스프링에게 아래 메소드가 반환하는 "객체"를 스프링 빈으로 등록해줘 전달
    public ProductRepository productRepository(){
        // 설정 파일의 메소드 이름은 보통 정해져있음
        // 원래 자바 클래스로 사용하려던게 아닌 데이터의 정보
        return new ProductRepository();
    }
}
