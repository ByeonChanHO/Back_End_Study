# ACID

> ## [ 정의 ]
>> ACID는 데이터베이스 트랜잭션이 안전하게 수행된다는 것을 보장하기 위해 지켜야할 성질을 가르키는 약어이다
>> A : Atomicity(원자성)
>> C : Consistency(일관성)
>> I : Isolation(독립성)
>> D : Durability (지속성)

>> ### [ 트랜잭션 ]
>> 데이터베이스에서 데이터에 대한 하나의 노리적 실행단계를 트랜잭션이라고 한다.
>> 
>> 예를 들어, 은행에서 계좌이체를 트랜잭션이라고 할 수 있는데, 계좌 이체 자체를 구현은 내부적으로 여러단계가 있지만 전체적으로는 '송신자 계좌의 금액 감소', '수신자의 계좌의 금액 증가'가 한 동작으로 이루어져야한다.
>> 
>> ### [ 원자성 (Atomicity) ]
>>> 
>> ### [ 일관성 (Consistency) ]
>> ### [ 독립성 (Isolation) ]
>> ### [ 지속성 (Durability) ]



### 참조
https://ko.wikipedia.org/wiki/ACID#:~:text=ACID(%EC%9B%90%EC%9E%90%EC%84%B1%2C%20%EC%9D%BC%EA%B4%80%EC%84%B1%2C,%ED%95%98%EB%8A%94%20%EA%B8%B0%EC%88%A0%EC%9D%84%20%EA%B0%9C%EB%B0%9C%ED%95%B4%20%EB%83%88%EB%8B%A4.
