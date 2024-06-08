package com.example.demo.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // persistence.Entity
public class Product {

    // DB에선 id가 식별자인데 여기는 자바
    // hibernate는 EntityManager를 포함한 JPA 구현체
    // EntityManager는 자바 소속
    // EntityContext 공간에서 엔티티를 관리
    // EntityContext 안에서 identifier(식별자=DB의 PK)를 가지고 Entity를 구별

    @Id
    private int id;
    private String name;
    private int price;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
