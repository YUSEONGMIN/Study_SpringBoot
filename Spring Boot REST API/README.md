# Udemy 강의

- 옆집 개발자와 같이 진짜 이해하며 만들어보는 첫 Spring Boot 프로젝트 (김송아 강사)

## 목차

- [Section 1 - 시작](#section-1---시작)
- [Section 2 - 웹](#section-2---웹)
- [Section 3 - API](#section-3---api)
- [Section 4 - Spring](#section-4---spring)
- [Section 5 - 프로젝트 생성](#section-5---프로젝트-생성)
  - [Section 5: 프로젝트구조](#프로젝트-구조)

# [Section 1 - 시작](#목차)

프로젝트: 일정 기간 일정 목적을 달성하기 위한 업무 묶음 (프로세스)  
하나의 프로그램, 서비스 등을 완성하는 것뿐만 아니라 에러 해결, 기능 추가(수정)

# [Section 2 - 웹](#목차)

HTML: Hyper Text Markup Language  
HTTP: Hyper Text Transfer Protocol

# [Section 3 - API](#목차)

API: Application Programming Interface  
REST(ful) API: HTTP 규칙(틀), 필요한 데이터

URL: 웹에서 요청하는 방법 = API를 사용하는 방법

# [Section 4 - Spring](#목차)

Spring: 웹 프레임워크

라이브러리 vs 프레임워크  
프레임워크: 틀 안에서 해결 (이미 라이브러리 포함)

![alt text](img/image.png)

    Data Access: 데이터베이스와 소통할 수 있는 인터페이스
    Web: 웹 개발하는데 필요한 기술
    AOP: Spring의 큰 장점
    Core Container: 핵심 기술
    Test: Test 도구

Spring Boot: Spring 기반으로 설정을 쉽게 해줌

# [Section 5 - 프로젝트 생성](#목차)

- [프로젝트 구조](#프로젝트-구조)
- [프로젝트 구조](#프로젝트-구조)

## [spring initializr](https://start.spring.io/)

프로젝트 만들어주는 사이트

![alt text](img/image-1.png)

Project: Gradle, Maven (빌드 도구)

    Gradle이 Maven보다 빌드가 조금 더 빠름
    Gradle - Groovy, Gradle - Kotlin (Gradle과 소통할 언어)

Packaging: Jar, War (압축파일 확장자)

    Jar: 웹서버(WAS)까지 포함해서 압축
    War: 그것을 빼고 압축

Dependencies: 사용할 것

REST API를 만들기 위해서는 가장 기본적인 것

> Spring Web

Build web: 웹을 만들거나
including RESTful: RESTful하게 만들거나
Uses Apache Tomcat as the default embedded container

> Tomcat: WAS(Web Application Service) 브랜드

## [프로젝트 구조](#section-5---프로젝트-생성)

```
📦demo
 ┃ ┣ 📂resources
 ┃ ┃ ┗ 📂main
 ┃ ┃ ┃ ┣ 📂static
 ┃ ┃ ┃ ┣ 📂templates
 ┃ ┃ ┃ ┗ 📜application.properties
 ┣ 📂gradle
 ┃ ┗ 📂wrapper
 ┃ ┃ ┣ 📜gradle-wrapper.jar
 ┃ ┃ ┗ 📜gradle-wrapper.properties
 ┣ 📂src (source)
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┃ ┗ 📂demo
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DemoApplication.java
 ┃ ┃ ┗ 📂resources (src 이외)
 ┃ ┃ ┃ ┣ 📂static
 ┃ ┃ ┃ ┣ 📂templates
 ┃ ┃ ┃ ┗ 📜application.properties
 ┃ ┗ 📂test (tdd)
 ┃ ┃ ┗ 📂java
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┃ ┗ 📂demo
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DemoApplicationTests.java
 ┣ 📜build.gradle
 ┣ 📜gradlew
 ┣ 📜gradlew.bat
 ┣ 📜HELP.md
 ┗ 📜settings.gradle
```

src 폴더 안에는 main과 test 폴더가 있음  
test 폴더 -> TDD: 테스트를 기반으로 구현하는 프로젝트, 개발 방법  
로직을 짜는 곳은 src -> main -> java

resources 폴더: 소스코드 이외의 것 -> 화면(템플릿), 이미지(로고), 설정(properties) 등

> 설정: 자바로 데이터베이스 jdbc로 연결하려면 긴 코드..  
> 스프링을 이용하면 DB이름, 계정 정보만 설정 파일에 작성하면 끝

build.gradle 파일: gradle이 빌드할 때 보는 파일

> group: gradle과 소통하기 위한 그룹
> dependencies: 추가한 것들 (Spring Web)

gradlew, gradlew.bat: gradle로 빌드하기 위한 실행 파일  
gradlew(MAC), gradlew.bat(윈도우 배치 파일)

## [스프링 주요 개념 (Core)](#section-5---프로젝트-생성)

- IoC
- DI
- 컨테이너
- 스프링 빈

---

IOC(Inversion of Control)

제어의 역전
제어권을 갖고있다가 역전 -> 갖고있지 않음

어떤 제어권? 프로그램(객체)의 흐름을 제어

객체의 흐름: 객체 생성 -> 사용 -> ...  
원래 객체 생성 주체는 나: new Product()  
이제는 스프링

---

DI(Dependency Injection)

의존성 주입

의존한다 = 사용한다  
객체(의 메소드)를 사용한다.  
-> 먼저 객체 생성부터

내가 직접 객체를 생성해서 사용하는 것이 아닌
주입을 당해서 사용

---

컨테이너

공간: 스프링이 객체를 생성해서 관리하는 공간

IoC를 위한 컨테이너, DI를 위한 컨테이너...

의존성 주입해줘 -> 컨테이너에서 객체를 찾아서 전달

스프링이 관리하는 객체: 스프링 빈(bean)

---

정리

IoC를 구현하기 위해 DI가 필요하다.

스프링 빈: 스프링(이 컨테이너에 담아놓고 관리하는) 객체

IoC (제어의 역전): 프로그램의 흐름을 제어하는 주체가 정반대로 바뀜  
= 객체의 흐름을 제어하는 주체가 정반대로 바뀜  
= 스프링 빈의 흐름을 제어하는 주체가 정반대로 바뀜

컨테이너 (a.k.a IoC, DI, 스프링): 스프링 빈을 담아두는 공간

DI (의존성 주입): 우리는 의존성을 주입 당하는 역할  
= 스프링은 의존성을 주입 하는 역할

## [Spring MVC](#section-5---프로젝트-생성)

스프링 MVC: Controller - Service - Repository

- Model: 데이터 처리(연산), 로직

  > 데이터를 가지고 연산을 하려면 데이터가 필요(데이터 베이스랑 소통)  
  > 모델은 단순히 로직만 수행하는 것이 아니라 로직에 필요한 데이터까지 처리  
  > 클래스명을 로직을 담당하는 Service라는 클래스(계층)이 있고,  
  > 데이터(베이스)와 소통하는 Repository 모델이 있음  
  > (계층, 클래스) Service / Repository

- View: 화면

  > 스프링은 화면도 만들 수 있음  
  > 근데 최근은 api 용도로만 쓰고  
  > 그 api도 화면을 보내주는 api가 아닌  
  > 데이터만 정해서 보내주는 api (REST API)  
  > 요즘은 화면을 스프링에서 잘 안쓰는 추세

- Controller : Model - View 중간 매개체
  >            Model - 사용자 중간 매개체
  >
  > View는 잘 안쓰는 추세  
  > View는 사용자(클라이언트)가 화면을 보니까  
  > 컨트롤러는 모델과 사용자 중간 매개체  
  > 사용자가 요청하면 그에 맞는 모델의 로직을 호출  
  > 그 로직은 결과를 내서 컨트롤러한테 반환  
  > 컨트롤러는 사용자에게 반환

## [프로젝트 구동하기](#section-5---프로젝트-생성)

![alt text](img/image-2.png)

`Tomcat initialized with port 8080 (http)`

Tomcat: 인터넷 통신망 사이의 가상 웹 공간  
Tomcat을 초기화한다. 8080 포트로. http 프로토콜을 사용

[http://localhost:8080](http://localhost:8080)
![alt text](img/image-3.png)

type=Not Found  
url을 요청했는데 그 url에 대응할 만한 서비스가 아직 없어서 에러  
(http에는 url을 담아서 보냄. url은 localhost:8080)

## [Controller, Service, Repository 클래스 생성](#section-5---프로젝트-생성)

![alt text](img/image-4.png)

Controller, Service, Repository는 하나의 클래스로 각각 사용

컨트롤러는 요청을 받아서 일을 시키고 그 결과를 돌려줌
(일은 서비스한테 시킴)

서비스는 일을 하기 위해서 데이터가 필요
데이터베이스에서 데이터를 저장하고 수정
(서비스는 레파지토리한테 데이터를 불러오거나 저장 요청)

레파지토리는 데이터베이스와 소통

## [자바 어노테이션](#section-5---프로젝트-생성)

`@SpringBootApplication`

어노테이션을 이해하기 위해선 오버라이드 개념부터

`OverrideDemo.java` 예시

```java
class Parent {
  void method() {

  }
}

class Child extends Parent {

}
```

![alt text](img/image-6.png)

Child 클래스는 Parent를 상속받아 method() 함수 존재

```java
class Parent {
  void method() {

  }
}

class Child extends Parent {
  void method() {

  }
}
```

오버라이드 했음

![alt text](img/image-5.png)

만약에 method에 h를 빼먹으면 오버라이드가 아님  
새로운 메소드 metod를 생성한 것  
이런 실수를 했다면 `@Override`를 통해 에러를 찾을 수 있음  
어노테이션의 역할은 다양함 (코드생성, 오류찾기 등)
