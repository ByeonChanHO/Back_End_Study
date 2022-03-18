# JUnit

## 사전 지식 : TDD(Test Driven Development)

+ TDD 란 **"테스트 주도 설계"** 라고 하며 테스트를 먼저 만들고 테스트를 통과하기 위해 코드를 짜며 실제 서비스가 될 코드를 작성하는 개발 방법론 중 하나이다.
    + 장점
        + 객체지향적인 코드를 개발 할 수 있다.
        + 설계 수정 및 디버깅 시간을 단축
        + 유지보수 용이
        + 오버 엔지니어링 방지
        + 여러가지 등등등이 있다.
    + 단점
        + 개발 시간 증가
        + 어려움
    + 결론
        + TDD를 위해 그 일부인 단위테스트를 편하게 작성할 수 있게 제공해주는 framework가 JUnit이다.
            + 정확히는 xUnit이다.
            + JUnit 은 Java Unit


## Unit test
+ 모든 함수와 메서드에 대한 **테스트 케이스**를 작성하여 의도된 대로 잘 잘 동작하는지 검증하는 절차
+ 프로그램을 작은 단위(unit)으로 쪼개어 각 unit이 정확하게 동작하는지 검사함으로서 프로그램의 안정성을 높인다
+ System.out.println()으로 하는 디버깅이 필요없으며, 개발 기간 중 대부분을 차지하는 디버깅 시간을 단축할 수 있다.


## JUnit 정의 및 특징
+ JUnit 이란 Java의 대표적인 Unit Testing Framework이다.
    + Java 와 Unit 을 합쳐 JUnit이라고 불린다.
        + 즉, C, C++,python 등 여러 Unit이 존재한다.
+ Testing 한 결과는 Test class로 개발자에게 테스트 방법 및 클래스의 history를 공유
+ 방법
    + assert(단정) 메소드로 테스트 케이스의 수행 결과를 판별
    + Annotation(@)으로 간결하게 사용 가능하다.


## JUnit4 vs JUnit5

1. 구성이 다르다
    + **Junit4**
        + 하나의 라이브러리 안에 모든게 구현이 되어있기에 라이브러리 하나만 추가하면 된다.
    + **Junit5**
        + 3개의 모듈로 나눠져 있다.
            + JUnit Platform
            + JUnit Jupiter
            + JUnit Vintage
        + ![1](https://user-images.githubusercontent.com/38696775/158925115-3a9a1e10-c742-4cb8-9d8f-986d2632e450.png)

2. java 및 Spring Boot 버전
    + **JUnit4**
        + java 4 이상
        + Spring Boot 2.1 버전까지 기본 제공
    + **JUint5**
        + java 8 이상
        + Spring Boot 2.2 이후버전 부터 기본 제공
            + 2.2 버전 이후로는 다른 설정 없이 기본 starter-test로 의존성 추가해야한다.

3. Annotation의 차이
    + 
    + 




## 참조
https://velog.io/@ehddek/JUnit-%EC%9D%B4%EB%9E%80 (이미지 출처 및 설명)
https://minkwon4.tistory.com/155
