# Mockito

+ **[Mockito 란]**
    + 개발자가 동작을 직접 제어할 수 있는 가짜(MOCK) 객체를 지원하는 테스트 프레임워크이다.
        + (진짜 객체 처럼 동작하지만 프로그래머가 직접 컨트롤 할 수 있는 객체)
        + Mock 객체를 만들고 관리 및 검증 할 수 있는 방법 제공
        + (가짜 객체를 만들어 준다고 생각하면 된다.)
        + 구현체가 아직 없는 경우, 구현체가 있더라도 특정 단위만 테스트 하고 싶을 경우 사용

+ **[배경]**
    + 단위 테스트는 모듈이 독립적으로 테스트가 진행되기에 여러 기능들이 의존관계에 있는 것은 테스트를 진행하기에 불가능하다.
    + 그렇기 때문에 다른 객체 대신에 가짜 객체(Mock Object)를 주입하여 어떤 결과를 반환하라고 정해진 답변(stub)를 준비시켜야한다.
    + **그래서 가짜 객체를 주윕시켜주는 Mockito 라이브러리가 나왔다.**
    + Mockito를 활용함으로써 가짜 객체에 원하는 결과를 Stub하여 단위 테스트를 진행 할 수 있다.


## [Mockito 사용법]

1. **Mock 객체 의존성 주입**
    + Mockito 에서 Mock(가짜) 객체의 의존성 주입을 위해서는 크게 **3가지 Annotation**이 사용된다.
        + **@MOCK** : Mock 객체를 만들어 반환해주는 Annotation
        + **@Spy** : Stub 하지 않는 메소드들을 원본 메소드 그대로 사용하게 해주는 Annotation
        + **@InjectMocks**: @Mock 또는 @Spy 로 생성된 가짜 객체를 자동으로 주입시켜주는 Annotation
    + **(EX)** UserController 에 대한 단위 테스트를 작성하고자 할때, UserService를 사용하고 있다면 @MOCK로 가짜 UserService를 만들고, @InjectMocks를 통해 UserController에 이를 주입시킬 수 있다.

2. **Stub로 결과 처리**
    + **의존성이 있는 객체는 가짜 객체(Mock Object)를 주입하여 어떤 결과를 반환하라고 정해진 답변을 준비**해야한다. 이러한 기능을 Mockito 안에 있는 **stub 메소드**가 제공한다.
        + **doReturn()** : Mock 객체가 특정한 값을 반환해야하는 경우
        + **doNothing()** : Mock 객체가 아무 것도 반환하지 않는 경우(void)
        + **doThrow()** : Mock 객체가 예외를 발생시킬 경우
    + **(EX)** doReturn(new ArrayList()).when(userSrtvice).findAllUser();
        + UserService의 findAllUser() 호출 시에 빈 ArrayList를 반환해야 한다면 다음과 같이 doReturn()을 사용할 수 있다.

3. **Mockito 와 Junit의 결합**
    + Mockito 도 Testing framework이기 떄문에 JUnit과 결합하여 **Annotation을 쓰기 위해**서는 별도의 작업이 필요하다.
        + **JUnit4** 에서 Mockito 활용
            + **@RunWith(MockitoJUnitRunner.class)** 을 Class Annotation으로 붙여줘야한다.
        + **JUnit5** 에서 Mockito 활용
            + **@ExtendWith(MockitoExtension.class)** 를 사용

## [Mockito의 디테일 점]

1. **Mockito**
    + Answers.RETURNS_DEFAULTS을 전략을 쓰고 있다.
        + 즉, stub가 되지 않은 메소드들은 Mockito에서 타입별로 정의된 return 값을 주어 메소드를 실행시킨다.
    

## 참조
https://mangkyu.tistory.com/145
