# Udemy 강의

- [옆집 개발자와 같이 진짜 이해하며 만들어보는 첫 Spring Boot 프로젝트 (김송아 강사)](README.md)
- [옆집 개발자와 같이 진짜 이해하며 만들어보는 첫 Spring Boot 프로젝트 1.5탄 (김송아 강사)](README1.5.md)

---

- 옆집 개발자와 같이 진짜 이해하며 만들어보는 첫 Spring Boot 프로젝트 2탄 (김송아 강사)

## 목차

- [Section 1 - 시작](#section-1---시작)
- [Section 2 - DB를 쓰는 이유](#section-2---db를-쓰는-이유)
- [Section 3 - 도커란?](#section-3---도커란)
- [Section 4 - ERD](#section-4---erd)
- [Section 5 - JPA](#section-5---jpa)
- [Section 6 - Spring Data JPA](#section-6---spring-data-jpa)
  - [DB 연결하기 - properties](#db-연결하기---properties)
- [Section 7 - JDBC API](#section-7---jdbc-api)
  - [build.gradle](#buildgradle)
- [Section 8 - JPA](#section-8---jpa)
  - [hibernate](#hibernate)
- [Section 9 - 전체 조회](#section-9---전체-조회)
  - [@Entity](#entity)
- [Section 10 - 상품 등록](#section-10---상품-등록)
  - [트랜잭션](#트랜잭션)
- [Section 11 - Spring Data JPA](#section-11---spring-data-jpa)
- [Section 12 - DTO](#section-12---dto)

---

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
자바 지속성/영속성 API (영원히 지속되는 성질)  
자바(의 객체)가 JVM 밖에서도 지속되길 원함  
-> 데이터베이스에 저장해둘 수 있을까

자바 객체를 어떻게 DB에 저장?  
-> 자바 객체를 JPA가 DB에 저장할 수 있도록 변환  
= 자바 객체를 RDBMS에 저장할 수 있도록 맵핑
(Object - Relational Mapping: ORM)

JPA는 스프링이 아닌 JAVA 기술  
JPA != Spring Data JPA

# [Section 6 - Spring Data JPA](#목차)

- [DB 연결하기 - properties](#db-연결하기---properties)

![alt text](img/image-21.png)

Spring은 자바로 웹을 만들 수 있는 프레임워크

웹: 정보 공유 -> 데이터 중요

DB와 연결되는 JDBC를 사용할 수 있게 하는 JPA  
그 JPA를 쉽게 사용할 수 있게 하는 것  
-> Spring Data JPA

## [DB 연결하기 - properties](#section-6---spring-data-jpa)

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

### [spring.io - application.properties](https://docs.spring.io/spring-boot/appendix/application-properties/index.html)

![alt text](img/image-22.png)

굉장히 많은 DB에 연결될 때 사용하는 것들

```
<프로젝트 속성>
1) DB 연결 (JDBC를 사용하려면 'Datasource 객체' 속성 사용)

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

![alt text](img/image-23.png)

mariaDB와 연결? X  
mariaDB 안에 shoppingmall과 연결 O

application.properties에서  
url, username, password 등 틀린 정보를 입력해도 에러가 발생하지 않는다.
-> JDBC API

# [Section 7 - JDBC API](#목차)

- [build.gradle](#buildgradle)

자바 프로젝트와 DB를 어떻게 연결하는가?  
-> JDBC의 객체: datasource

DataSource 객체의 역할

- DB 속성값을 들고 자바와 DB 사이의 터널을 뚫어줌
- SQL 구문으로 소통 가능하게 도와줌

properties에 DB 속성 값을 적어주면 Spring이 DataSource 객체를 만들어줌

에러가 안 나는 이유는 이 속성 값이 틀린지 스프링은 아직 모른다.  
스프링은 이 객체를 사용할 때 알게 됨

## [build.gradle](#section-7---jdbc-api)

### DataSource 객체를 만드는 방법

```java
import javax.sql.DataSource;

    @Autowired
    DataSource dataSource;
```

dependencies: 의존성 = 사용할 것

```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'

  runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
	implementation 'org.springframework.boot:spring-boot-starter-jdbc'
}
```

web을 만들 것이다. test를 할 것이다. 등

> runtimeOnly: 프로그램 돌 때만 사용하겠다.  
> implementation: 구현할 때 사용

{} 안에 있는 것들(패키지)을 사용하는데 앞에 있는 글에 따라서 언제 사용하는지 결정

build.gradle의 dependencies에 추가를 해줘야 스프링이 객체를 만들어줌

MySQL을 사용한다면

```
	runtimeOnly 'mysql:mysql-connector-java' 에서
	runtimeOnly 'com.mysql:mysql-connector-j' 으로 변경
```

### dataSource로 터널 뚫기

```java
// ProductRepository
    public void makeConnection() {
        DataSourceUtils.getConnection(dataSource);
    }
// ProductController
    @GetMapping("/connectdb")
    public void makeConnection() {
        productService.makeConnection();
    }
```

spring.datasource.url 주소가 틀리면 에러 발생

`Caused by: java.net.ConnectException: Connection refused (Connection refused)`

# [Section 8 - JPA](#목차)

- [hibernate](#hibernate)

DataSource는 이제 JPA를 통해서 관리하므로 주석처리

build.gradle에 JPA 추가하기

> [Maven Repository](https://mvnrepository.com/)  
> Spring Boot Starter Data JPA  
> Starter: 필요한 패키지 미리 준비

```
	implementation 'org.springframework.boot:spring-boot-starter-jdbc:3.3.0'
```

뒤에 버젼을 적지 않더라도 알아서 적용  
빌드하면 로그에 hibernate라는 글자가 보임

## [hibernate](#section-8---jpa)

![alt text](img/image-21.png)

자바와 DB끼리 통신하려면 JDBC API로 1단계 쉽게 접근  
객체랑 데이터베이스의 데이터랑 매핑하는데 어려워 JPA로 2단계 쉽게 접근  
사용하기엔 조금 어려워 Spring Data JPA로 3단계 쉽게 접근

JDBC API, JPA(Java Persistence API), Spring Data JPA 모두 API  
API: Application Programming Interface

JDBC API는 DB랑 통신할 때 사용한 객체는 DataSource  
DataSource 내부를 보면 인터페이스임

```java
20 implementations
public interface DataSource extends CommonDataSource, Wrapper { ... }
```

인터페이스라는건 구현된 코드가 없다는 것..  
그런데 이전에 getConnection 메소드를 사용했음  
인터페이스로는 객체를 만들 수 없음..

-> 자바의 인터페이스를 type 형태로만 사용하고, type에 담을 수 있는 진짜 구현체는 따로

20 implementations을 열어보면 20개의 구현체들이 있음

DataSource를 객체라고 했지만  
DataSource 인터페이스를 implement해서 구현체는 따로 있음

ex) 20개 중 하나인 HikariDataSource (com.zaxxer.hikari) 등...

DataSource는 인터페이스고, 그 안의 구현체는 따로 있다.
-> 인터페이스이기 때문에 type만 담아서 사용 (UpCasting)

### JPA(API): hibernate

JDBC보다도 ORM이 가능하게 지원해줌  
JPA도 인터페이스로 진짜 구현체는 hibernate

> Recall)  
> Java Persistence API: 자바 영속성(영원히 지속되는 성질)  
> 자바(객체)가 JVM 밖에서도(=프로그램이 종료되도) 저장되도록  
> -> 데이터베이스에 저장

JPA가 하는 일은 자바의 객체와 DB의 row를 매핑해서 DB에 저장

매핑(Mapping)을 한다는 것은 자바의 객체를 DB에 그대로 저장하는 것이 아니라  
DB는 DB대로 저장을 하되, 객체가 그대로 저장되는 것처럼 형태를 매핑하는 것

JPA: 자바 객체 - Mapping "Entity" - DB 가로 줄(행)

스프링이 스프링 빈을 관리하는 공간 = 컨테이너  
JPA가 Entity를 관리하는 공간 = `EntityContext`

JPA는 자바와 DB 사이에 EntityContext 공간을 만들고 엔티티를 관리한다.

1. JPA가 관리하는 객체: Entity (DB와 1:1 매핑)
2. Entity를 모아두는 공간: EntityContext (Mapping을 고려하는 공간)
3. JDBC API - DataSource (interface) - hikari -> 터널을 연결하고, SQL 전달  
    JPA API - EntityManager (interface) - hibernate  
   hibernate -> Entity를 관리 (라이프 사이클, 영속성 관리), CRUD 작업 수행할 수 있는 메소드 제공

### hibernate 위주로 쓰는 이유

인터페이스는 구현체가 1개 이상(hibernate 등) 가능하다.

Maven Repository에서 Spring Boot Starter Data JPA를 보면  
Compile Dependencies (컴파일하는데 필요한 Dependencies 포함)

- O/R Mapping, org.hibernate.orm > hibernate-core 등...

Spring Data JPA Dependencies에 hibernate 포함  
즉, 구현체가 hibernate를 사용하라고 default로 설정

그 외에 spring boot starter jdbc, spring data jpa도 포함  
-> JDBC를 포함한다는 것은 build.gradle에서 JDBC를 생략해도 무방

```java
// ProductRepository
    @Autowired
    EntityManager entityManager;
    // import jakarta.persistence <- 영속성
```

EntityManager는 DB의 CRUD 메소드 제공

# [Section 9 - 전체 조회](#목차)

- [@Entity](#entity)


DB에 테이블 만들기

![alt text](img/image-24.png)

name, price, description이 각각 중복되어 있음  
서로 다른 상품임에도 구별하기가 어렵다.  
그래서 id 값이 필요하다.

```sh
mysql -u root -p
> root1234
```

```sql
CREATE TABLE product (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  price INT NOT NULL,
  description VARCHAR(500),
  PRIMARY KEY (id)
);
```

DB에 테이블 생성하는 쿼리문  
_id는 비어있지 않으며, 자동 증가로 PK 지정_

sql 구문을 파일에 기록하는 것이 좋다.  
그 동안 어떤 쿼리문을 썼는지, 오타가 있는지 확인하기 좋다.  
최상단 경로에 `shoppingmall.sql` 파일 생성

![alt text](img/image-25.png)

DB 준비 끝

---

JPA: 자바 객체 <-> Mapping `Entity` in `EntityContext` <-> DB 가로줄(행)

## [@Entity](#section-9---전체-조회)

JPA가 Entity로 등록해서 관리하는 방법  

> Reall)  
> 스프링이 스프링 빈으로 등록해서 관리하는 방법  
> @Component 또는 @Configuration + @Bean  
> "어노테이션" 사용

JPA가 Entity로 등록해서 관리하는 방법  
`@Entity` 어노테이션 사용  

```java
@Entity
public class Product {

      private int id;
```

`@Entity`  
Product 객체를 Entity로 등록

DB에서 생성된 테이블 구조에 맞게 id 추가  

> private는 다 getter, setter 해야한다?
> setter의 경우, 꼭 그렇지는 않다.

### EntityManager가 가진 메소드

- 테이블 조회 SELECT
- 객체 등록 INSERT

```java
    public List<Product> findProducts() {
        return entityManager // 엔티티매니저에게
                .createQuery("던지고 싶은 sql", 엔티티로 사용할 클래스) // 이 쿼리문을 만들어서
                .getResultList(); // 결과를 가져와 줘
    }
```
일반적인 sql 구문이 들어가지 않음 -> JPQL(Java Persistence Query Language)  
JPA의 번거로움 -> Spring DATA JPA 으로 해결

```
SQL: SELECT * FROM product(테이블명)

JPQL: SELECT p FROM Product(엔티티명) (AS) p
- SQL을 자바의 시선으로 추상화시킨 명령어
- 결국 DB에서는 SQL이 실행
```

JPQL: JPA에서 내가 원하는 쿼리를 만들어서 쓸 때 사용하는 명령어

```java
    public List<Product> findProducts() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> products = query.getResultList();
        return products;
```

entityManager의 createQuery 반환 타입은 String이 아닌 TypedQuery (타입이 정해진 쿼리)  
쿼리를 만들어서 나온 결과는 두번째 매개변수 `Product.class` 형태로 나옴  
이 형태가 값일지 리스트일지는 아직 모름. 그래서 제네릭 사용  

```
TypedQuery <com.example.demo.product.Product>
<>는 제네릭(Generic)을 의미
어떤 타입일지 몰라서
```

이대로 빌드를 하면 다음과 같은 에러가 발생  

```
Caused by: org.hibernate.AnnotationException: 
Entity 'com.example.demo.product.Product' has no identifier 
(every '@Entity' class must declare or inherit at least one '@Id' or '@EmbeddedId' property)
```

DB에선 id가 식별자이지만 자바에선 식별자를 정의해줘야 함  
`@Id` 사용

### JPA 키워드 정리

JPA: 자바 객체 -> "ORM" -> RDBMS 저장  
- 자바의 영속성을 지켜주는 역할
- 영속성: 자바 객체를 JVM 밖에서도 지속하는 것 (DB 저장)

hibernate: JPA 구현체 (Spring 선택: default)
- JPA는 인터페이스이고, 인터페이스 뒤에 있는 구현체들 중 하나
- 편해서 default

Entity: 자바 객체 1:1 DB **Mapping**  
EntityManager: Mapping 관리, CRUD method  
- 자바 객체를 Entity로 만들어줌

EntityContext: Java - DB 사이 공간 Entity가 모여있는 곳  
- EntityManager가 일하는 공간

@Entity: JPA에게 Entity로 등록해줘 전달
@Id: DB의 식별자를 지정

# [Section 10 - 상품 등록](#목차)

- [트랜잭션](#트랜잭션)

EntityManager가 가진 CRUD 메소드

- 테이블 조회 SELECT

```java
entityManager.createQuery("").getResultList(); // 전체 조회
```

entityManager에게 select를 하기위한 쿼리를 만들어줘 `createQuery`  
쿼리를 만들고 실행하면 결과가 여러 개가 나오니까 List로 반환해줘 `getResultList`

CRUD 메소드라고 하기엔 어설픔  
CRUD를 해준게 아니고, 내가 직접 CRUD를 해달라고 요청한 것  
-> entityManager는 전체 조회는 제공하지 않고, 개별 조회를 제공함

개별 조회 `find(id)`

- 객체 등록 INSERT

```java
persist(객체) // 저장
```

JPA가 자바 객체를 저장(영속성)

- 수정 / 삭제

---

상품 등록을 하면 오류가 발생함 (트랜잭션 에러)

```
jakarta.persistence.TransactionRequiredException: No EntityManager with actual transaction available for current thread - cannot reliably process 'persist' call
```

## [트랜잭션](#section-10---상품-등록)

데이터베이스 작업(CRUD) 단위

회원가입: 입력값 가입 요청 -> 가입 -> 000님 환영합니다! (가입 정보 출력) 

    Create -> Read 
    INSERT -> SELECT 

    사용자가 원하는 기능 덩어리 단위 = ‘Create ~ Read’ 트랜잭션 1개 
    = 비즈니스 로직 

    Repository 메소드 단위는 C,R,U,D 단위로 구성
    Service 메소드 단위는 비즈니스 로직 단위로 구성 (즉, 여기에 트랜잭션을 표현) 

---

트랜잭션을 하는 이유  

하나의 트랜잭션: insert + insert + ... + insert + insert   
작업 중 에러 발생하면 다시 다 원상복구 = 모든 작업 다 롤백(Roll-Back) 

모든 작업들이 성공해야 모두 DB 반영  
-> 트랜잭션 단위로 DB에 반영/취소

@Transaction 사용

`127.0.0.1:8080/products` POST 방식으로 데이터 저장 후

```
{
    "name":"note",
    "price":4000,
    "description":"line"
}
```

GET으로 조회하기

### JPA의 SQL 구문 확인하기

application.properties

`spring.jpa.show-sql=true` 추가

save를 하면 다음과 같은 sql 구문 출력

```
Hibernate: insert into product (description,name,price,id) values (?,?,?,?)
```

get으로 조회할 시

```
Hibernate: select p1_0.id,p1_0.description,p1_0.name,p1_0.price from product p1_0
```

# [Section 11 - Spring Data JPA](#목차)

![alt text](img/image-26.png)

Spring Data JPA: Spring이 제공해주는 JPA 인터페이스

JPA: EntityManager, createQuery 등 복잡함을 추상화(간단하게)  
-> 제공하는 메서드를 간결하고 다양하게

- 페이징 기능
  - DB 페이징 (1페이지: 1~10, 2페이지: 11~20 …)

- 쿼리 메서드: 이 테이블에서 A 컬럼 값으로 조회

### JpaRepository

ApplicationConfiguration 에서 스프링 빈으로 등록된 기존 ProductRepository 대신 사용하기

```java
public interface SpringDataJPAProductRepository extends JpaRepository<엔티티명, 아이디> {
}
```

제네릭 형태<>로 테이블 매핑해서 사용  
엔티티명(엔티티로 사용할 클래스명), 아이디(Product 클래스의 id)  
제네릭은 Type으로 작성

SpringDataJPA는 자동으로 스프링 빈으로 등록해 줌  
Service에서 바로 사용

JpaRepository에는 `findAll`, `findAllById` 등 다양한 메소드들이 존재  

- 테이블 전체 조회: findAll()
- 데이터 개별 등록: save(엔티티 객체) (CrudRepository에 존재)
- 데이터 개별 조회: findById()


```java
Optional<T> findById(ID id);

// Optional은 클래스
public final class Optional<T> {

}
```

JPA는 DB에서 데이터를 가져오는 역할  
-> 없는 값은 가져올 수 없음 (null.getName() X)

Optional은 없을 수도 있는 값(null)을 확인

```java
// Service
    @Autowired
    private SpringDataJPAProductRepository springDataJPAProductRepository;

    public Product findProduct(int id) {
        return springDataJPAProductRepository.findById(id).get();
    }
```

ProductRepository -> SpringDataJPAProductRepository로 레파지토리를 바꾸니  
서비스 메소드 또한 findProduct -> findById 등으로 바뀌고, 변수 또한 바뀜

레파지토리 하나를 바꾸니 서비스의 코드가 다 바뀜 (문제점)

![alt text](img/image-27.png)

Interface를 통해 해결 가능

---

어떤 레파지토리를 사용할 것인지  

```java
@Repository
ProductRepository
```

```java
// @Repository
ProductSpringDataJPARepository
```
SpringDataJPA는 스프링빈 자동 등록

등록된 레파지토리가 2개이면 에러 발생  
ProductRepository를 사용하려면?

id 말고 name, price 등으로 찾으려면...  
- `findByName(String name)`
- `findByPrice(int price)`

SpringDataJPA  
findBy... 라고 인터페이스 정의를 하면 알아서 JPQL을 만들어 줌

JPA 기능: 메소드 이름을 분석해서 쿼리를 만들어줌 (네임드 쿼리)

https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

```
JPA Query Methods
This section describes the various ways to create a query with Spring Data JPA.

Query Lookup Strategies
The JPA module supports defining a query manually as a String or having it being derived from the method name.
```

JPA 모듈은 메소드 이름에 따라서 쿼리를 작성해 준다.

```java
public interface UserRepository extends Repository<User, Long> {

  List<User> findByEmailAddressAndLastname(String emailAddress, String lastname);
}
```

Name을 가지고 상품 리스트를 조회하고 싶다면

```java
public interface SpringDataJPAProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
}
```

# [Section 12 - DTO](#목차)

DTO(Data Transfer Object)  
데이터 전송 객체: 데이터를 전송하기 위해 사용하는 객체 

DTO를 알려면 엔티티에 대해 알아야 됨
Entity는 DB 테이블에 들어있는 데이터와 1:1로 매핑되는 객체

엔티티란?  
- DB와 일대일로 매핑되는 객체
- 영속성을 가짐
- 엔티티 매니저가 관리
- 엔티티 컨텍스트에 저장

### DTO를 쓰는 이유

DB에 들어있는 데이터는 검증되어야 들어감(무결성)  
엔티티는 DB에서 나올 수도, 들어갈 수도 있음  
`Product` 엔티티를 DB에 들어가기 전 변경한다면.. 위험(무결성 위배)  

엔티티를 Controller까지 왔다갔다 하기에는 위험하다.  
Controller는 프론트엔드와 너무 가까움  
엔티티는 DB에 들어가야 되는 객체임  

- 년도로 입력받고 DB에는 나이로 저장  

- 화면에서 입력받는 값이 바뀌면 DB와 엔티티 모두 바뀜

---

엔티티(원본) 대신 사본처럼 일하는 객체 = DTO


### 다음 목표

- JPA로 수정, 삭제하기  
- DTO <-> Entity: 복사(변환)
  - DTO 만들기, DTO 이용하다가 DB 들어가기 전 Entity 변환
- build.gradle dependencies 키워드 의미 파악, 메이븐 레포지토리란? 
- gradle, maven 차이, 장단점
- @SpringBootApplication 
- AOP 
- Security 

웹 서비스: 유효성 검사, 예외 처리 