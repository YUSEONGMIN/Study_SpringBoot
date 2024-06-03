# Udemy 강의

- 옆집 개발자와 같이 진짜 이해하며 만들어보는 첫 Spring Boot 프로젝트 2탄 (김송아 강사)

## 목차

- [Section 1 - 시작](#section-1---시작)
- [Section 2 - DB를 쓰는 이유](#section-2---db를-쓰는-이유)
- [Section 3 - 도커란?](#section-3---도커란)
- [Section 4 - ERD](#section-4---erd)
- [Section 5 - JPA](#section-5---jpa)
- [Section 6 - Spring Data JPA](#section-6---spring-data-jpa)
  - [DB 연결하기](#db-연결하기)

# [Section 1 - 시작](#목차)

목표

- DB, ERD, JPA, Spring Data JPA, Entity, DTO

# [Section 2 - DB를 쓰는 이유](#목차)

데이터 베이스란? 데이터가 모여있는 공간?
-> 메모장, 블로그, 공책도 데이트 베이스인가?

저장하는 이유는 나중에 사용할 때, 빠르고 쉽게 효율적으로 찾고 사용하고 싶어서  
메모장, 블로그, 공책은 찾는데 오래 걸릴 수 있음

- 중복: 이전에 썼던 내용을 피할 수 있음
- 안전: 공책은 잃어버릴 수 있음
- 보안: 공책은 남들이 볼 수 있음
- 데이터 신뢰할 수 있도록 역할
  ex. 이름 값에 숫자형을 넣으면 에러 발생

데이터 베이스란  
검증된 데이터가 체계적으로 모여있어서 (= 중복 X, 보안, 정확)  
나중에 사용할 때, 효율적으로 데이터를 찾아서 쓸 수 있는 공간

### DB vs DBMS

사용자가 DB를 쉽게 사용할 수 있는 인터페이스 -> DBMS

RDBMS  
Relational DBMS: 데이터들의 관계가 DB의 핵심

DBMS 설치 시 **도커**로도 할 수 있다.

# [Section 3 - 도커란?](#목차)

컨테이너를 만들고 실행하는 기술

컨테이너란?  
어플리케이션(프로그램) + 환경 설정 세팅

기존에 프로그램을 설치하려면 설치 파일부터 환경설정 등 하나씩...  
환경설정까지 끝난 프로그램을 하나의 컨테이너 공간에 담아 둠

도커는 컨테이너를 내 컴퓨터에 도킹시켜줌

# [Section 4 - ERD](#목차)

Entity Relationship Diagram: 개체 - 관계 도식

Entity(개체): DB에서 하나의 표(row)에 저장하는 단위

ex. 상품명, 상품 가격, 상품 설명 / 회원 이름, 회원 아이디, 회원 비밀번호  
상품과 회원 분리

![alt text](img/image-17.png)

개체를 어떻게 분리하느냐(정규화) <— 이 단위에 따라서, 관계 형성

상품 - (상품가격,상품명,상품설명)  
분리를 한다고 무조건 좋은 것은 아니다.

# [Section 5 - JPA](#목차)

JPA와 DB가 연결되는 방법

![alt text](img/image-18.png)

![alt text](img/image-19.png)

Java DataBase Connectivity

![alt text](img/image-20.png)

자바는 객체 지향  
음식은 객체로 존재할 수 있다.  
(int 음식번호 -> Food 음식)

객체 지향과 관계 데이터베이스의 패러다임 불일치  
이를 해결해주는 것이 JPA

### JPA란?

Java Persistence API  
자바 지속성/영속성 API
자바(의 객체)가 JVM 밖에서도 지속되길 원함  
-> 데이터베이스에 저장해둘 수 있을까

자바 객체를 어떻게 DB에 저장?  
-> 자바 객체를 JPA가 DB에 저장할 수 있도록 변환  
= 자바 객체를 RDBMS에 저장할 수 있도록 맵핑
(Object - Relational Mapping: ORM)

JPA는 스프링이 아닌 JAVA 기술  
JPA != Spring Data JPA

# [Section 6 - Spring Data JPA](#목차)

- [DB 연결하기](#)

![alt text](img/image-21.png)

Spring은 자바로 웹을 만들 수 있는 프레임워크

웹: 정보 공유 -> 데이터 중요

DB와 연결되는 JDBC를 사용할 수 있게 하는 JPA  
그 JPA를 쉽게 사용할 수 있게 하는 것  
-> Spring Data JPA

## [DB 연결하기](#section-6---spring-data-jpa)

1. DB에 Product를 저장할 공간, 테이블 준비하기
2. 진짜 DB랑 연결하기
3. Product 저장, 조회

main - resources - `application.properties`

### application.properties

DB 연결, 포트 넘버 변경, 프로젝트 이름 변경, 로그 파일 저장 경로 등  
-> 프로젝트 속성 값들을 설정 (로직과 관계가 없는)

자바 코드가 아니므로 빈 등록은 안해도 됨

스프링 - Spring Data JPA - JPA - JDBC API - MySQL

JDBC가 DB와 연결이 되면  
-> JPA가 거기에 ORM을 얹어주고  
-> Spring Data JPA는 거기에 사용하기 편하게 만들어줌

[spring.io - application.properties](https://docs.spring.io/spring-boot/appendix/application-properties/index.html)

![alt text](img/image-22.png)

```
<프로젝트 속성>
1) DB 연결 (JDBC를 사용하려면 'Datasource 객체' 속성 사용)
- 굉장히 많은 DB에 연결될 때 사용하는 것들

그 중 필요한 것들
spring.datasource.driver-class-name
-> driver: DB별 각각의 시스템을 잘 사용할 수 있도록 해주는 도구 (장치 구동기)

spring.datasource.password
-> DB 비밀번호 작성
spring.datasource.username
-> DB 사용자 이름 작성

spring.datasource.url
-> DB 주소 값

- spring.datasource.driver-class-name=마리아 db
- spring.datasource.url = 내컴퓨터에 있는 db 주소
- spring.datasource.username = 유저네임
- spring.datasource.password = 비밀번호

2) 포트 넘버 바꾸기
3) 프로젝트 이름 바꾸기
4) 로그 파일 경로
```
