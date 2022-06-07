# Error 와 Exceoption

## 1. 정의
- **Error**
    + Error 는 시스템에 비정상적인 상황이 생겼을 때 발생한다.
        + 시스템 레벨에서 발생하기 떄문에 심각한 수준의 오류이다.
        + 따라서 개발자가 미리 예측하여 처리할 수 없다.
- **Exceoption**
    + Exception은 발생할 상황을 미리 예측하여 처리할 수 있는 걸 말한다.
        + 즉, validation(검증)할 수 있는 걸 처리할 수 있다.
        + 개발자가 구현한 로직에서 발생 가능


## 2. 예외 클래스
![1](https://user-images.githubusercontent.com/38696775/172399248-d3409a1d-a000-460f-9e0e-aab9c08b9d2d.png)

- **Throwable**
    + Throwable 은 Object의 자식 클래스이다.
    + Throwable 을 상속 받는 Error와 Exception 클래스가 존재한다.
- **Error**
    + Error 은 스스템에 변화를 주어 문제를 처리해야하는 경우가 일반적이다.
        + 시스템 레벨의 심각한 수준의 에러이기 때문이다.
- **Exception**
    + RuntimeException과 CheckedException, UncheckedException 으로 나눈 클래스들이 존재한다.
    + RuntimeException이 CheckedException과 UncheckedException을 구분하는 기준이 된다.
        + RuntimeException이 아닌 것은 CheckedException이다.
        + RuntimeException의 자식 클래스는 UnCheckedException이다.
    
## 3. Checked Exception과 UnChecked Exception (RuntimeException포함)

- **Checked Exception**
    + 처리여부 : 반드시 예외를 처리해야한다.
    + 확인시점 : 컴파일 단계
    + 예외발생시 트랜잭션 처리 : Roll-Back 하지 않음
    + 대표 예외 : IOException, SQLException
- **UnChecked Exception**
    + 처리여부 : 명시적인 처리를 강제하지 않음
    + 확인시점 : 실행단계
    + 예외발생시 트랜잭션 처리 : Roll-Back 함
    + 대표 예외 : NullPointerException, IllegalArgumentException, IndexOutOfBoundException, SystemException(RuntimeException 하위 예외들)

- **명확한 구분법**
    + **"꼭 처리 해야하느냐"** 에 따라 구분된다.
        + Checked Exception은 꼭 처리해야하는 예외
        + Uncecked Exception은 명시적으로 처리하지 않아도 되도록 되어 있기에 로직에서 처리할 필요가 없다.
    + **확인 시점**에 따라 구분
        + Checked Exception은 컴파일 단계에서 명확하게 체크 가능하다.
        + UnChecked Exception은 실행 단계에서 체크가 가능하다.(= Runtime Exception에 포함된 것이다.)
    + **Roll-Back** 에 따라 구분
        + Checked Exception은 트랜잭션 Roll-back 하지 않고 예외를 던져준다.
        + UnChecked Exception은 트랜잭션 Roll-back 하고 예외를 던져준다.
        + 주의 : 어떻게 묶느냐에 따라 Roll-Back 범위가 달라지는데, 개발자가 이를 인지 못하면 실행결과가 맞지 않거나 예상치 못한 예외가 발생할 수 있다.
        + 해결 : Roll-Back 범위를 인지하고 트랜잭션을 적용시킬때 전파방식(Propagation Behavior)과 롤백규칙 등을 적절히 사용하면 더욱 효율적인 애플리케이션을 구현할 수 있다.

## 4. 예외처리 방법
1. **예외복구**
    + 다른 작업 흐름으로 유도
2. **예외처리 회피**
    + 처리하지 않고 호출한 쪽으로 throw
3. **예외 전환**
    + 명확한 의미의 예외로 전환 후 throw

### 4-1. 예외복구
```java
int maxTry = MAX_TRY;
while(maxTry --> 0){
    try{
        //예외가 발생할 가능성이 있는 시도
        return 0; //작업 성공시 리턴
    }
    catch(SomeException e){
        //로그 출력. 정해진 시간만큼 대기
    }
    finally{
        //리소스 반납 및 정리 작업
    }
}
throw new RetryFailedException(); //최대 시도 횟수가 넘으면 직접 예외 발생
```
- **재시도를 통해 예외를 복구하는 코드이다.**
    1. 이 예외는 일정 시간 만큼 대기하고 다시 재시도를 반복한다.
    2. 최대 시도 횟수가 넘으면 예외를 발생한다.
- **장점**
    + 재시도를 통해 정상적인 흐름을 타게 하거나 예외가 발생하면 이를 미리 예측하여 다른 흐름으로 유도시키도록 구현하면 비록 예외가 발생하였어도 정상적으로 작업을 종료할 수 있다.

### 4-2. 예외처리 회피
```java
public void function() throws SQLException{
    //로직
}
```
- 던지는 방식이 최선의 방법이라 확신할때만 써라
### 4-3. 예외 전환
```java
catch(SomeException e){
    throw SomehandlingException();
}

catch(SomeException e){
    new SomeException(code : 500, e.getmessage());
}
```
- 어떤 예외인지 분명하게 하여 처리하는 방식이다.
- 이를 통해 Checked Exception 중 복구가 불가능한 예외가 잡혔다면 UnChecked Exception으로 전환하여 다른 계층에서 일일이 예외를 선언할 필요가 없도록 할 수 있다.


## 참조
하단의 사이트를 보고 왔다.
https://www.nextree.co.kr/p3239/#:~:text=Error%EB%8A%94%20%EC%8B%9C%EC%8A%A4%ED%85%9C%20%EB%A0%88%EB%B2%A8%EC%9D%98,%EC%9E%90%EC%8B%9D%ED%81%B4%EB%9E%98%EC%8A%A4%EB%A5%BC%20%EA%B0%80%EC%A7%80%EA%B3%A0%20%EC%9E%88%EB%8B%A4.
