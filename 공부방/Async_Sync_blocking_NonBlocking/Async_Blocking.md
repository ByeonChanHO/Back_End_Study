> # Async_Blocking

> ![image](https://user-images.githubusercontent.com/38696775/203339460-491e61f8-66e0-4004-8d28-3ce0d1b4178a.png)
>> 
>> 사원이 서류를 가지고 와서 Blocking Sync 상사에게 서류처리결과를 이메일로 알려달라고 합니다
>> 
>> (여기서 이메일로 보내달라고 하는 말은 callback 함수를 뜻합니다)

> ![image](https://user-images.githubusercontent.com/38696775/203339505-63e8f57b-7db5-4f88-9f08-73c7327ac657.png)
>>
>> 이때 사원은 Blocking Sync 상사에게 서류 주며 상사의 말을 기다립니다
>> 
>> ( 서류(작업) 및 사원의 행동 제어권을 Non-Blocking Async 상사에게 준겁니다)

> ![image](https://user-images.githubusercontent.com/38696775/203339539-cf2e2af0-cedf-4a20-870b-8a27fc2ab723.png)
>>
>> 하지만 Blocking Sync 상사는 서류결과를 이메일로 보내달라고 한게 꽤심한지, 사원에게 서류처리 결과가 끝날때까지 기다리라고 합니다
>> 
>>  ( 이는 사원의 행동에 대한 제어권을 상사가 게속 가지고 있겠다는 말입니다 )

> ![image](https://user-images.githubusercontent.com/38696775/203339600-893e59fb-1b07-4130-98f0-5a09116e66d8.png)
>>
>>  Blcoking Sync 상사는 작업을 끝내고 서류처리결과를 이메일로 보내며 다시 사원에게 "이메일로 보냈으니 서류결과 보고 작업 마무리 하세요" 라고 합니다
>> 
>> (이는 작업(서류)결과를 CallBack(이메일)로 보낸 것이며, 사원에게 행동 제어권을 돌려주는 걸 뜻합니다)


> ## 보충자료
> ![image](https://user-images.githubusercontent.com/38696775/203354177-11276e1a-9fac-46ee-a05e-85c7d48ed7c7.png)
>
> 다른 예시로는 Non-Blocking/Asynchronous를 가진 node.js 와 blocking 특성을 가진 MySQL 조합이 이렇다.
> 
> 근데 보통 이렇게 안 쓴다

## 참고
https://www.youtube.com/watch?v=oEIoqGd-Sns


