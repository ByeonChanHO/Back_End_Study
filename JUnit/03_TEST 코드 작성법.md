# [TEST 코드 작성법]

@Test Annotation 이 있는 test class 은 **Given-When-Then Pattern**을 사용한다.
```java
@Test
public void Service_Test(){
    //given
    
    //when

    //then
}
```
## [Given-When-Then Pattern]

1. **given**
    + 테스트를 위한 준비 과정을 말한다.
    + 테스트에 사용하는 변수, 입력 값 등을 정의하거나, Mock 객체와 stub를 정의하는 구문이다.

    ```java
    //given
    OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
    NotificationClient notificationClient = Mockito.mock(NotificationClient.class);
    orderService = new OrderService(orderRepository, notificationClient);

    Mockito.when(orderRepository.findOrderList()).then(invocation -> {
        System.out.println("I'm mock orderRepository!!");
        return Collections.emptyList();
    });

    Mockito.doAnswer(invocation -> {
        System.out.println("I'm mock notificationclient");
        return null;
    }).when(notificationClient).notifyToMobile();

    ```

2. **when**
    + 실제로 액션을 하는 테스트를 실행하는 과정
    + Clean code에서는 가능한 when은 심플한 구문이 되어야한다.

    ```java
    //when
    orderService.createOrder(true);
    ```

3. **Then**
    + 테스트를 검증하는 과정이다.
    + 예상 값, 실제 실행을 통해서 나온 값을 검증한다.

    ```java
    //then
    Mockito.verify(orderRepository, Mockito.times(1)).createOrder();
    Mockito.verify(notificationClient, Mockito.times(1)).notifyToMobile();
    ```