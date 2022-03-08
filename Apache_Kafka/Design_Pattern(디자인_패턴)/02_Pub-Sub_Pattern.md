# 2. Pub-Sub Pattern

    publisher(발행자)가 이벤트(메세지)를 발행하여 Topic(Channel)에 저장하고 
    
    Subscriber(구독자)가 Topic에서 저장된 이벤트(메세지)를 가져가는 패턴이다.

![1](https://user-images.githubusercontent.com/38696775/157141746-55cd809c-b6f5-4228-b02d-2530a5ff2a04.png)


## **Kafka의 Pub-Sub pattern**

    Kafka에서는 Pub/Sub 을 Producer/Consumer라는 개념으로 Kafka에 맞게 재 구성되었다.

    Producer은 Publisher와 같이 이벤트(메세지)를 Topic에 보내어 각 Partition에 맞게 이벤트를 저장한다.

    그 이후 Topic을 구독하고 있는 Consumer Group 내의 Sbucrier인 Consumer은 각각 1개 이상의 partition으로부터 이벤트를 가져온다.
    
 ![1](https://user-images.githubusercontent.com/38696775/157144578-d9001c76-4625-4289-9cec-3b07f963507f.png)

 ### **주의점**
    만약 partition 개수가 Consumer 보다 작으면, 아무일도 않하는 Consumer가 생기기에

    Partition 수를 Consumer보다 같거나 크게 해주는 것이 좋다.

## 참조

https://medium.com/frientrip/pub-sub-%EC%9E%98-%EC%95%8C%EA%B3%A0-%EC%93%B0%EC%9E%90-de9dc1b9f739