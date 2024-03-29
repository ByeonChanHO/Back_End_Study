# Event Driven Architecture
> ## [ 정의 ]
>>
>> <p align="center">
>>          <img src = "https://user-images.githubusercontent.com/38696775/205497363-e33c5a90-fd78-4b19-90fd-a743ad6454b1.png"/>
>> </p>
>>                                                                                                                                           
>> Event Driven Architecture 이란 이벤트를 중심으로 생산, 소비으 돌아가는 아키텍쳐이다
>>
> ## [이벤트란?]
>>  시스템 하드웨어 또는 소프트웨어 상태의 변화 또는 중대 사건의 발생을 의미합니다
>>  
>>  즉, 마우스 클릭, 키보드 입력, 데이터 변화 등이 될 수 있습니다.
>>  
> ## [구성요소]
>> 
>> Event Driven Architecture 는 Event producer와 Event consumer, Event Channels 로 구성
>> 
>> ![image](https://user-images.githubusercontent.com/38696775/212904950-b32aa6e6-df5b-4eee-bf79-d09cc6f77ddd.png)
>> 
>> Event Producer : 이벤트를 감지하며 해당 이벤트를 메시지로 재구성하여 보내는 역할
>> 
>> Evnet Consumer : 해당 이벤트의 알림을 받아, 해당 이벤트를 가져와 처리하는 역할
>> 
>> Event Channels : 비동기적으로 이벤트를 처리하고 소비자한테 이벤트를 보내는 역할을 합니다
>>> 정확히 이벤트 처리란 이벤트를 수집하고, 필터링 그리고 소비자한테 push 하는 걸 말합니다
>> 
> ## [이점]
> ![image](https://user-images.githubusercontent.com/38696775/213211264-efde76a1-a25c-454e-8a50-1114c272dda6.png)
>> 1. 독립적인 확장 및 장애
>>> 서비스끼리 서로 인식하지 못하고 Event Channel로만 인식함으로서 느슨한 연결을 제공한다. 즉, 서비스는 상호 운용 가능하지만 한 서비스의 로직 변경이나 장애가 발생되더라도 나머지 서비스는 영향을 받지 않는다.
>> 2. 손쉬운 감사
>>> 이벤트 라우터는 애플리케이션을 감사하고 정책을 정의하는 중앙 집중식 관리 역할을 합니다. 이러한 정책은 라우터를 게시 및 구독할 수 있는 사용자를 제한하고 데이터에 액세스할 권한이 부여되는 사용자와 리소스를 제어할 수 있습니다. 또한 전송 중인 이벤트와 저장된 이벤트를 모두 암호화할 수 있습니다.
>> 3. 비용 절감
>>> 이벤트 기반 아키텍처는 푸시 기반이므로, 이벤트를 확인하기 위해 지속적 폴링 비용을 지불할 필요가 없습니다. 
>>> 즉, 네트워크 대역폭 사용량, CPU 활용률 등 I/O 가 줄어들어 비용이 절감됩니다






-----------------------------------------------------------------------------------------------------
> ## [이벤트 기반 아키텍처 모델]
>> pub/sub 모델과 Event streaming 모델 총 2가지의 이벤트 기반 아키텍처가 존재한다.
>> ### [Pub / Sub Model]
>>> 이벤트 스트림 구독 기반의 메시징 infrasture 로 이벤트 발생 후 또는 게시 후에 알림을 받아야하는 구독자한테 바로 이벤트가 전송됩니다.
>> ### [ Event Streaming Model ]
>> Event Streaming Model 을 사용하게 되면 이벤트가 로그에 기록이 됩니다.
>> 또한, 이벤트 소비자는 이벤트 스트림을 구독하지 않습니다
>> 스트림의 모든 부분에서 읽기가 가능하며 언제든지 스트림에 참여 가능
>>> [ Event Streaming 유형]
>>>> 1. Event stream processing
>>>>> Apache Kafka 와 같이 데이터 스트림 플랫폼을 사용하여 이벤트 스트림을 처리 또는 운송하는 걸 뜻한다.
>>>> 2. Simple event processing
>>>>> 이벤트가가 즉시 소비자 행동 트리거가 된다.
>>>> 3. Complex event processing
>>>>> 감지하기 위해 소비자는 이벤트를 처리해야한다?












>> 
>> ### [ Database Per Sevice로 인한 문제점 ]
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

## 참고
https://www.samsungsds.com/kr/insights/msa_architecture_edm.html#:~:text=Event%20Driven%20%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98%EB%8A%94%20%ED%8A%B9%EC%A0%95,%EC%9D%84%20%EC%88%98%ED%96%89%ED%95%A0%20%EC%88%98%20%EC%9E%88%EC%8A%B5%EB%8B%88%EB%8B%A4.

https://cloud.google.com/eventarc/docs/event-driven-architectures?hl=ko.
