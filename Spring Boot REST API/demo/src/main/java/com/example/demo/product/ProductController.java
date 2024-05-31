package com.example.demo.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ProductController {
    // 사용자(화면) 요청을 던지면
    // 그 안에서, 그에 맞는 로직을 수행할 수 있도록
    // 서비스한테 시킴

    // 요청을 던졌을 때 그것을 받는게 컨트롤러
    // 그리고 받아서 어떤 서비스한테 어떤 메소드를 실행할 지 관리

    // 상품 조회
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findProduct() {
        ProductService productService = new ProductService();
        return productService.findProduct();
        // return "NoteBook";
    }
}
