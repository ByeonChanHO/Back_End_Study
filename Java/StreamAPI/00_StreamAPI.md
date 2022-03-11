# Stream API

**정의 :** A sequence of elements supporting sequential and parallel aggregate operations.

    Stream API이란 데이터 흐름에서 filtering 과 matching, mapping 등과 같은 데이터 가공 및 처리 작업이 간편하게 해주는 기능.

## 배경

**문제점**

    자바에서 많은 양의 데이터를 저장하기 위해 array나 Collection을 사용한다.

    하지만 array나 collection 방식은 데이터를 접근하기 위해 반복문이나 iterator(반복자)를 사용하여야한다.

    즉, 데이터를 접근할 때마다 새로운 코드를 작성해야하기에 코드 길이도 늘어나고 가독성이 떨어지고, 코드 재사용이 불가능해진다.

    (DB의 query와 같이 정형화된 처리 패턴을 가지지 못했기에 데이터마다 다른 방법으로 접근해야한다.)

**해결책**
    이를 해결하기 위해 Stream API가 도입되었다.

    Stream API는 데이터를 추상화하여 다루므로, 다양한 방식으로 저장된 데이터를 읽고 쓰기 위한 공통된 방법을 제공

    따라서 Stream API를 이용하면 Array나 Collections뿐만 아니라 File에 저장된 Data도 모두 같은 방법으로 다룰 수 있다.

## Stream API의 특징

1. 외부 반복을 통해 작업하는 Collection과는 달리 내부 반복(internal iteration)을 통해 작업을 수행
    (즉, Collection은 반복문 또는 반복자를 써서 작업하는 반면, Stream은 안의 method로 작업 수행)
2. 재사용이 가능한 Collection과는 달리 일회용으로 단 한번만 사용이 가능하다.   
3. 원본 데이터를 변경하짖 않는다.
    (call by value 라고 생각하면 되지만 모든 것이 call by value는 아니다)
4. 연산이 filter-map(필터-맵) 기반의 API를 사용하여 지연(lazy) 연산을 통해 성능을 최적화 한다.
5. parallelStream() 메소들를 통한 손쉬운 병렬 처리를 지원

## Stream API의 동작 흐름
1. Stream의 생성
    + Array 및 Collections instance 대상으로 Stream 생성

2. 중간 연산
    + Filtering(필터링) 및 Mapping(맵핑)관련 연산.

3. 최종 연산
    + Reduction(리덕션) 관련 연산

## 참조
https://velog.io/@gjrjr4545
http://www.tcpschool.com/java/