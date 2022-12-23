# Event Driven Architecture
> ## [ 정의 ]
>>
>> <p align="center">
>>          <img src = "https://user-images.githubusercontent.com/38696775/205497363-e33c5a90-fd78-4b19-90fd-a743ad6454b1.png"/>
>> </p>
>>                                                                                                                                           
>> Event Driven Architecture 이란 이벤트를 중심으로 생산,감지,소비을 돌아가는 아키텍쳐이다
>> 즉, 이벤트 생성자가 이벤트를 발행하면 소비자는 이를 감지하고 가져가서 그 이벤트를 처리하는 방식의 Architecture이다.
>> 
> ## [ 배경 ]
>> Event Driven Architecture는 MSA의 문제점을 보완하고자 나온 구조입니다
>> 
>> 기존의 MSA는 단일 애플리케이션을 작은 서비스 모음으로 개발하는 방식인데, 각각 서비스를 자체 프로세스에서 실행되게 만들며 느슨한 연결(Loosely-coupled)구조로 HTTP 리소스인 REST와 같은 경량 메커니즘으로 각 서비스들끼리 통신합니다
>> 
>> 즉, 하나의 큰 애플리케이션을 여러개의 작은 애플리케이션으로 쪼개어 변경과 조합이 가능하도록 만든 아키텍쳐입니다.
>> 
>> 하지만 MSA 방식에는 문제점이 존재했는데요
>> 
>> 바로 [Database Per Service](https://github.com/ByeonChanHO/Back_End_Study/blob/main/%EA%B3%B5%EB%B6%80%EB%B0%A9/Event%20Driven/Database%20Per%20Service%EB%A1%9C%20%EC%A0%84%ED%99%98.md) 를 적용하게 되면서 나타나는 문제점입니다
>> 
>> ### [ MSA Database Per Sevice로 인한 문제점 ]
>> 
>>> <strong>[ 비즈니스 흐름 수행 문제 ]</strong>
>>> 
>>> 하나의 공간에서 처리되던 로직이 여러 개의 공간으로 서비스가 분리되어 해당 기능을 수행하기 위해서 여러 서비스를 통신을 거쳐야한다.
>>> 
>>>> [ 닥터유 에너지바를 산다고 가정을 하자! ]
>>>> 
>>>> MSA 로 바뀌기 이전에는 하나의 기능이 여러 단계를 걸쳐서 닥터유 에너지바를 고객에게 전달을 한다.
>>>> 
>>>> 하지만 MSA 이후에는 각 단계별로 서비스가 구현 되었기에 menu -> order -> pay -> make -> delivery 서비스 순서대로 동작을 할 것이다.
>>>> 
>>>> 즉, 각 서비스 마다 통신을 하게 되고 이전 보다 시간이 걸리고 비즈니스 흐름이 복잡해진다.
>>> 
>>> <strong>[ 트랜잭션 관리 ]</strong>
>>> 
>>> 기존 Legacy 시스템에서는 문제 발생시 일괄적으로 commit 또는 rollback 처리나 이전에 발생한 상태 변경에 직접 접근하여 데이터 수정이 가능하였다.
>>> 
>>> 하지만 MSA 가 적용된 후, 각 서비스가 나눠져 일관적으로 commit 또는 rollback 하기가 어려워집니다.
>>> 
>>> <strong>[ 서비스 간 반정규화 데이터 동기 처리 문제 ]</strong>
>>> 
>>> 기존의 Legacy 시스템에서는 한곳에서 데이터를 관리하다 보니 반정규화가 생길 가능성이 적었습니다
>>> 
>>> 하지만 MSA가 적용된 후 각 서비스의 DB에 반정규화가 생길 가능성이 이전보다 높아지고, 해당 반정규화를 해소시키기위해 REST 통신을 하게 되면서 복잡성 및 성능이 안 좋아지게 된다.
>>> 
>>>> [ 각 서비스 DB에 쓰이는 테이블 컬럼이 있다고 가정하자! ]
>>>> 
>>>> 두개의 서비스가 있습니다 
>>>> 
>>>> 서비스1 DB 테이블은 닥터유 제품관련 데이터가 있다
>>>> 
>>>> 서비스2는 닥터유 에너지바관련 데이터가 있다.
>>>> 
>>>> 닥터유 제품에는 당연히 닥터유 에너지바를 제품으로 등록해 있다.
>>>> 
>>>> 근데 서비스2가 닥터유 에너지바의 이름을 닥터유+ 에너지바로 바꾸게 된다.
>>>> 
>>>> 이때 서비스1에서 에너지바 관련된 일로 서비스2를 호출 할 경우 반정규화가 생긴다.
>>>> 
>>>> 이를 해결하기 위해 서비스들끼리 계속 REST 통신하게 되면 복잡성이 커지고 성능을 떨어지게 된다.
>>>> 
>>> <strong>[ 시스템내 통합 문제 ]</strong>
>>> 
>>> 
>>>   
>>> 

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
