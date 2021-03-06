# Kafka

실시간으로 기록 스트림을 게시, 구독, 저장 및 처리할 수 있는 분산 데이터 스트리밍 플랫폼

### 배경

MSA 로 개발 환경이 변화면서 공유 데이터베이스 계층과 같은 종속성을 줄여 보다 작업을 수월하게 수행하도록 바뀌었다. 하지만 개발자가 구축 중인 분산형 애플리케이션이 데이터를 공유하려면 특정한 유형의 통합이 필요하다.

**통합 옵션 방법들**
1. API 방식을 사용하여 서로 다른 사용자 간 데이터 공유를 하는 동기식 방법.
2. Apache Kafka를 사용하여 중간 스토어에서 데이터를 복제하는 비동기식 방법.
    (데이터를 스트리밍하여 데이터 스토어를 채우면 해당 데이터를 여러 팀들이 애플리케이션 간에 공유가 가능)

## 구성 요소

#### 1. Event(이벤트 또는 메세지)

    Event 은 kafka에서 Producer(생산자)와 Consumer(소비자)가 데이터를 주고 받는 단위.

#### 2. Producer(생산자)

    Producer은 kafka에 이벤트를 게시(post)하는 클라이언트 애플리케이션

    즉, 웹 등 사용자가 보는 것

#### 3. Consumer(소비자)

    Consumer은 이러한 Topic을 구독하고 이로부터 얻어낸 이벤트를 처리하는 클라이언트 애플리케이션

#### 4. Topic

    이벤트가 쓰이는 곳으로 파일 시스템의 폴더와 유사하며, 이벤트는 폴더 안의 파일과 유사

    Producer가 Topic에서 이벤트를 게시하고 Consumer가 Topic으로 부터 이벤트를 가져가 처리한다.

    (Topic 에 저장된 이벤트는 필요한 만큼 다시 읽을 수 있다.)

    즉, 일종의 Queue 이다.

#### 5. Partition

    Topic는 여러 Broker에 분산되어 저장되며, 이렇게 분산된 Topic을 partition이라고 부른다.

    어떤 이벤트가 Partition에 저장될지는 이벤트의 Key에 의해 정해지며, 같은 키를 가진 이벤트는 항상 같은 Partition에 저장.

    (Consumer은 동일한 순서로 저장된 이벤트를 Partition안에서 가져와야한다.)



## 참조
https://www.redhat.com/ko/topics/integration/what-is-apache-kafka

https://galid1.tistory.com/793