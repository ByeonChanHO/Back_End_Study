# Kafka
> ## [정의]
>> 대용량, 대규모 메시지 데이터를 빠르게 처리하도록 개발된 분산 메시지 서비스
>> Publish-Subscribe 모델 기반
> ## [Pub-sub 모델]
>> [이미지]
>> 메시지를 전송할 때는 publisher 가 보내며 받을 때는 Subscriber 가 받는다
>> Pub-Sub 은 메시지를 특정 수신자에게 보낼 때 직접 보내지 않고 중계자(Broker)를 통해서 메시지를 보낸다
>> Publisher 는 메시지를 Topic을 통해 카테고리
>> 분류된 메시지를 받기 원한느 Subscriber 는 해당 Topic 을 구독함으로써 메시지를 읽어 올 수 있다.
>> Publisher 는 Topic에 대한 정보만 알고 있고, Subscriber도 Topic 만 바로본다
>> 즉, publisher와 Subscriber은 서로 인지 못하고 상호작용하는 느슨한 결합 구조를 취하고 있다.
