# Synchronous/Asynchronous(동기/비동기) 와 Blocking/Non

# 동기와 비동기

   **동기와 비동기는 프로세스의 수행 순서 보장에 대한 매커니즘이다.**

## Synchronous(동기)

   동기식 처리은 직렬적으로 task를 수행한다.

   **즉, task가 순차적으로 실행 되며 어떤 작업이 수행 중이면 그 작업이 끝날때까지 대기한다.**
   


## Asynchronous(비동기)

   비동기식 처리는 병렬적으로 task 를 처리한다.

   **즉, task 가 종료되지 않은 상태라 하더라도 대기하지 않고 다음 task를 실행한다(비순차적으로 작업 처리)**
   
   **콜백 함수를 사용하여 알아서 해당 일에 대한 완료 여부를 확인한다.**

# Blocking & Non-Blocking

   **Blocking 과 Non-Blocking은 프로세스의 유휴 상태에 대한 개념이다**
    
   (유후 = 컴퓨터가 작동 가능한데 작업을 하지 않는 시간)
   
   전체적인 작업의 흐름을 막거나 안 막는 거에 초점
   
   즉, 제어권이 누가 가지고 있느냐

## Blocking

    Blocking 은 자신의 작업을 진행하다가 다른 주체의 작업이 시작되면 다른 작업이 끝날 때까지 기다렸다가 자신의 작업을 시작하는 것이다.
    
    [예시] 함수 A에서 B를 호출 할때 B가 작업이 끝날때까지 A는 대기상태가 된다.

## Non-blocking

    Non-blocking은 다른 주췌의 작업에 관련없이 자신의 작업을 하는 것

    즉, 함수 A가 B를 호출할때 B가 작업하고 있는 동안 A은 다른 작업을 할 수 있다.


![1](https://user-images.githubusercontent.com/38696775/157169912-6661b933-e459-4c97-bd70-3a0f91b66c4d.png)




## 이미지 출처 및 참조
https://jh-7.tistory.com/
