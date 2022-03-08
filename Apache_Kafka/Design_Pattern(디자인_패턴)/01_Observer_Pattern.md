# 1. Observer Pattern

    Observer Pattern 이란 하나의 생성자인 Main Object 을 다수의 Observer 객체와 의존관계로 묶여 
    
    Main Object가 변화(update)할때마다 notify method 로 이를 통보해 다수의 Observer가 변화를 가져 적용시킨다.
    
![1](https://user-images.githubusercontent.com/38696775/157134582-073146e6-5a71-4086-bb22-039b0c73b117.png)

## **Kafka의 Observer Pattern**
    Kafka에서의 Observer Pattern 에서는 각 Broker들 주 하나를 뽑아 Controller 로 지정한다.
    
    그 이후 Controller를 나머지 Broker들이 관찰하며 변화가 발생해 알려주면 그 즉시 그 정보를 참조한다.

    만약 Controller이 관찰하는 라인(의존 관계)를 파괴시켜버리면 다른 Broker들은 자기들 중에 한명을 뽑아 Controller로 만들어

    다시 그 Controller을 관찰한다.


## 참조
이미지[1] : https://en.wikipedia.org/wiki/Observer_pattern