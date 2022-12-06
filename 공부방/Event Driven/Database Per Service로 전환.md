# Database Per Service 전환
> ## [ 정의 ]
> 
>> 간단하게 말하면 말 그대로 하나의 서비스당 하나의 DB가 붙는다는 말이다.
>> 
>> 자세히 말하자면 MSA 전환을 위한 패턴이며 아래와 같은 것들이 지켜져야한다.
>> 
>> 1. 마이크로서비스들은 데이터 계층을 공유하지 못하게 해야한다.
>> 
>> 2. 서비스의 개별 데이터베이스를 변경해도 다른 서비스에 영향이 안 미치게 해야한다.
>> 
>> 3. 서비스는 DB에 API를 통해서만 접근이 가능하게 해야한다.
>> 
>> 
> ## [전환 시 고려사항]
> 
>> 1. 데이터의 분리
>> 
>>> 데이터 분리가 필요하다
>>> 
>> 2. Shared 관계형 데이터베이스 장점 사용 불가
>> 
>>> 데이터를 효율적으로 보관하고 조회/삭제 등 기능의 효율을 높이는 장점이 사용 불가
>>> 
>>> 테이블 Join을 통한 통합 뷰 제공 불가
>>> 
>>> [ACID](https://github.com/ByeonChanHO/Back_End_Study/blob/main/%EA%B3%B5%EB%B6%80%EB%B0%A9/Event%20Driven/ACID.md) 원칙에 따른 트랜잭션 기능 고려
>>> [여담] [Shared 관계형 DB 문제점](https://github.com/ByeonChanHO/Back_End_Study/tree/main/%EA%B3%B5%EB%B6%80%EB%B0%A9/Event%20Driven)
>> 3. DB Oriented System
>> 
>>> 처음부터 Database 스키마/테이블 설계
>>> 
>>> 데이터의 [CRUD](https://github.com/ByeonChanHO/Back_End_Study/blob/main/%EA%B3%B5%EB%B6%80%EB%B0%A9/Event%20Driven/CRUD%EB%9E%80.md) 기능과 데이터의 Life cycle 고려
>>> 
>>> 기존 데이터 흐름을 재구성
>>> 
>> 4. DB 분리시 발생하는 비용
>> 
>> 5. 기존 DBMS 에 최적화된 각종 세팅 재설정
>> 

## 참조
https://medium.com/dtevangelist/event-driven-microservice-%EB%9E%80-54b4eaf7cc4a
