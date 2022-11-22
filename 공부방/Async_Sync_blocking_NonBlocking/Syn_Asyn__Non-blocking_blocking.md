
> # 동기와 비동기
> **동기와 비동기는 프로세스의 수행 순서 보장에 대한 매커니즘이다.**
>> ## Synchronous(동기)
>> 동기식 처리은 직렬적으로 task를 수행한다.
>> 
>> **즉, task가 순차적으로 실행 되며 어떤 작업이 수행 중이면 그 작업이 끝날때까지 대기한다.**
>> ## Asynchronous(비동기)
>> 비동기식 처리는 병렬적으로 task 를 처리한다.
>> 
>>   **즉, task 가 종료되지 않은 상태라 하더라도 대기하지 않고 다음 task를 실행한다(비순차적으로 작업 처리)**
>>   
>>   **콜백 함수를 사용하여 알아서 해당 일에 대한 완료 여부를 확인한다.**
   
   
   
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------   
   

> # Blocking & Non-Blocking
> **Blocking 과 Non-Blocking은 프로세스의 유휴 상태에 대한 개념이다**
>    
>   (유후 = 컴퓨터가 작동 가능한데 작업을 하지 않는 시간)
>   
>   전체적인 작업의 흐름을 막거나 안 막는 거에 초점
>   
>   즉, 제어권이 누가 가지고 있느냐
>> 
>> ## Blocking
>>
>>   Blocking 은 자신의 작업을 진행하다가 다른 주체의 작업이 시작되면 다른 작업이 끝날 때까지 기다렸다가 자신의 작업을 시작하는 것이다.
>>    
>>   [예시] 함수 A에서 B를 호출 할때 B가 작업이 끝날때까지 A는 대기상태가 된다.
>>
>> ## Non-blocking
>>
>>  Non-blocking은 다른 주췌의 작업에 관련없이 자신의 작업을 하는 것
>>
>>   즉, 함수 A가 B를 호출할때 B가 작업하고 있는 동안 A은 다른 작업을 할 수 있다.
------------------------------------------------------------------------------------------

> # Sync & Async 와 Blocking & Non-Blocking 조합
>
> ![1](https://user-images.githubusercontent.com/38696775/157169912-6661b933-e459-4c97-bd70-3a0f91b66c4d.png)
>
>> ## Sync-Blocking
>> <img align="right" width="500" height="500" src = "https://user-images.githubusercontent.com/38696775/203093123-5af12c9c-245a-4c79-9f53-0f51505593c5.png"/>
>> <br>
>> <br>
>> <br>
>> Worker A는 Woerker B의 <strong>리턴값을 필요로 한다(Sync)</strong>
>><br>
>><br>
>><br>
>> 제어권을 Worker B에게 넘겨주고, Worker B가 실행을 완료하여 리턴값과 <strong>제어권을 돌려 줄때까지 기다린다(Blocking)</strong>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> 
>> ## Sync-Non_Blocking
>> 
>> <img align="right" width="500" height="500" src = "https://user-images.githubusercontent.com/38696775/203315172-e84c771c-e4e7-41f5-b994-09e5592f6831.png" />
>>
>> Worker A는 Worker B에게 제어권을 주지 않고, <strong> 자신의 코드를 계속 실행한다(Non-Blocking)</strong>
>>
>> Worker A는 Worker B의 리턴 값이 필요하기 때문에, <strong>중간중간 Worker B에게 함수 실행을 완료했는지 물어본다(Sync)</strong>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> 
>> ## Async-Blocking
>> 
>> <img align="right" width="500" height="500" src = "https://user-images.githubusercontent.com/38696775/203095529-8ee91881-a8c8-496b-8b99-cae19c0b95d8.png" />
>> <br>
>> <br>
>> Worker A는 Worker B의 리턴값에 신경쓰지 않고, <strong>콜백함수를 보낸다(Async)</strong>
>> 
>> 그런데, Worker B의 작업에 관심이 없으며, <strong> Worker A는 Worker B에게 제어권을 넘긴다(Blocking)</strong>
>> 
>> Worker A는 자신과 관련 없는 Worker B의 작업이 끝날때까지 기다려야한다.
>> 
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> 
>> ## Async-Non_Blocking
>> 
>> <img align="right" width="500" height="500" src = "https://user-images.githubusercontent.com/38696775/203095979-07060f47-eace-4868-99f6-11eb5e32532b.png" />
>> 
>> Worker B는 <strong>제어권을 주지 않고, 자신이 계속 가지고 있는다.</strong> 따라서 Worker B를 호출한 이후에도 멈추지 않고 자신의 코드를 계속 실행한다.에게 제어권을 주지 않고, <strong> 자신의 코드를 계속 실행한다(Non-Blocking)</strong>
>>
>> Worker B를 호출할떄 콜백함수를 함께 준다. Worker B는 <strong>자신의 작업이 끝나면 Worker A가 준 콜백 함수를 실행한다(Async)</strong>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>
>> <br>






## 이미지 출처 및 참조
https://jh-7.tistory.com/
https://inpa.tistory.com/entry/%F0%9F%91%A9%E2%80%8D%F0%9F%92%BB-%EB%8F%99%EA%B8%B0%EB%B9%84%EB%8F%99%EA%B8%B0-%EB%B8%94%EB%A1%9C%ED%82%B9%EB%85%BC%EB%B8%94%EB%A1%9C%ED%82%B9-%EA%B0%9C%EB%85%90-%EC%A0%95%EB%A6%AC
