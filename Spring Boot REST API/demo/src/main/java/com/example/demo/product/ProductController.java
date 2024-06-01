package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class ProductController {
    // 사용자(화면) 요청을 던지면
    // 그 안에서, 그에 맞는 로직을 수행할 수 있도록
    // 서비스한테 시킴

    // 요청을 던졌을 때 그것을 받는게 컨트롤러
    // 그리고 받아서 어떤 서비스한테 어떤 메소드를 실행할 지 관리

    // 기본적으로 필드는 private (보안성)
    @Autowired
    private ProductService productService;

    // 상품 조회
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    // public String findProduct(@PathVariable("id") int id) {
        // ProductService productService = new ProductService();
        // 위는 직접 객체 생성, 스프링 빈 등록하는 방법은 @Autowired
    public Product findProduct(@PathVariable("id") int id) {
        System.out.println("GET "+ id);

        // return "NoteBook";
        return productService.findProduct(id);
    }

    // 상품 등록
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    // public void saveProduct(@RequestParam(value = "name") String productName) {
        // localhost:8080/products?name=___ => productName
        public void saveProduct(@RequestBody Product product) {
        System.out.println("POST");
        // productService.saveProduct();
        // productService.saveProduct(productName);
        productService.saveProduct(product);
    }
    

}
