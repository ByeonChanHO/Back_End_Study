# Synchronous/Asynchronous(동기/비동기) 와 Blocking/Non

## Synchronous(동기)

    동기식 처리은 직렬적으로 task를 수행한다.

    즉, task가 순차적으로 실행 되며 어떤 작업이 수행 중이면 그 작업이 끝날때까지 대기한다.


## Asynchronous(비동기)

    비동기식 처리는 병렬적으로 task 를 처리한다.

    즉, task 가 종료되지 않은 상태라 하더라도 대기하지 않고 다음 task를 실행한다.

## Blocking

    Blocking 은 한 작업이 끝날 때까지 제어권을 못 가져가게 막는 것을 말한다.
    
    즉, 함수 A에서 B를 호출 할때 B가 작업이 끝날때까지 A는 대기상태가 된다.

## Non-blocking

    Non-blocking은 한 작업을 호출할때 제어권은 주지 않는 것을 말한다.

    즉, 함수 A가 B를 호출할때 B가 작업하고 있는 동안 A은 다른 작업을 할 수 있다.


![1](https://user-images.githubusercontent.com/38696775/157169912-6661b933-e459-4c97-bd70-3a0f91b66c4d.png)




## 이미지 출처 및 참조
https://jh-7.tistory.com/
