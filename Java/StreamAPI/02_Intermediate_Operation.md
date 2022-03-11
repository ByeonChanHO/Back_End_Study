# Intermediate_Operation(중개 연산)

초기 스트림은 중개 연산을 통해 또 다른 스트림으로 변환이 된다.

중개 연산의 반환 타입은 스티림임으로, 연속으로 연결해서 사용할 수 있다.

(즉, 필터-맵(filter-map)기반의 API를 사용함으로서 지연(lazy) 연산으로 성능을 최적화 할 수 있다.)

### **대표적 중개 연산의 메소드**
1. 필터링 : filter(), distinct()
2. 변환 : map(), flatMap()
3. 제한 : limit(), skip()
4. 정렬 : sorted()
5. 연산 결과 확인 : peek()


## Stream 필터링

+ **filter()** 는 주어진 조건에 맞는 요소만으로 구성된 새로운 stream을 반환한다.
+ **distinct()**은 중복된 요소가 제거된 새로운 stream 을 반환합니다.
    (내부적)