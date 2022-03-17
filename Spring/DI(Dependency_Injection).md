# DI(Dependency_Injection)

### 배경

```java
class Person{}
    private Pet pet;

    public Person(){
        this.pet = new Dog();
    }
}
```
+ **Person 라는 객체가 Dog 객체를 의존하게 되면 문제점이 생긴다.**
    + 하나의 객체가 바뀌면 의존한 모든 다른 객체까지 변경되어야한다.(모듈도 적용된다.)
    + Unit Test 작성 또한 어려워진다.