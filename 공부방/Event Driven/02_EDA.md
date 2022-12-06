# Event Driven Architecture
> ## [ 배경 ]
>> Event Driven Architecture는 MSA의 문제점을 보완하고자 나온 구조입니다
>> 
>> 기존의 MSA는 단일 애플리케이션을 작은 서비스 모음으로 개발하는 방식인데, 각각 서비스를 자체 프로세스에서 실행되게 만들며 느슨한 연결(Loosely-coupled)구조로 HTTP 리소스인 REST와 같은 경량 메커니즘으로 각 서비스들끼리 통신합니다
>> 
>> 즉, 하나의 큰 애플리케이션을 여러개의 작은 애플리케이션으로 쪼개어 변경과 조합이 가능하도록 만든 아키텍쳐입니다.
>> 
>> 하지만 MSA 방식은 문제점이 존재했는데요
>> 
>> ### [ MSA 문제점 ]
>>> <strong>[ 비즈니스 흐름 수행 문제 ]</strong>
>>> 
>>>   
>>> <strong>[ 트랜잭션 관리 ]</strong>
>>> 
>>>   
>>> <strong>[ 서비스 간 반정규화 데이터 동기 처리 문제 ]</strong>
>>> 
>>>   
>>> <strong>[ 시스템내 통합 문제 ]</strong>
>>> 
>>> 
>>>   
>>> 
> ## [ 정의 ]
>>
>> <p align="center">
>>          <img src = "https://user-images.githubusercontent.com/38696775/205497363-e33c5a90-fd78-4b19-90fd-a743ad6454b1.png"/>
>> </p>
>>                                                                                                                                           
>> Event Driven Architecture 이란 이벤트를 중심으로 생산,감지,소비을 돌아가는 아키텍쳐이다
>> 즉, 이벤트 생성자가 이벤트를 발행하면 소비자는 이를 감지하고 가져가서 그 이벤트를 처리하는 방식의 Architecture이다.
>> 
>>
> ## [ 구성 요소 ]
>> 1. Event Producer(Generater, Publisher, Creater)
>>  생성된 이벤트 데이터를 Event bus에게 전달
>> 2. Event Bus(Router, Channel)
>>  이벤트 데이터를 저장하고 해당 데이터를 Event Consumer에게 전파하는 역할
>> 3. Event Consumer(Processor)
>>  수신된 이벤트 데이터를 식별하고 처리하는 역
>> 
아마존에서 Event Bus 는 Event router 로


## 참고
https://www.samsungsds.com/kr/insights/msa_architecture_edm.html#:~:text=Event%20Driven%20%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98%EB%8A%94%20%ED%8A%B9%EC%A0%95,%EC%9D%84%20%EC%88%98%ED%96%89%ED%95%A0%20%EC%88%98%20%EC%9E%88%EC%8A%B5%EB%8B%88%EB%8B%A4.
