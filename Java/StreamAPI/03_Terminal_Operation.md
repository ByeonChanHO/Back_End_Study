# Terminal_Operation(최종 연산)

1. Component 출력 : forEach()
2. Component 소모 : reduce()
3. Component 검색 : findFirst(), findAny()
4. Component 검사 : anyMatch(), allMatch(), noneMatch()
5. Component 통계 : count(), min(), max()
6. Component 연산 : sum(). average()
7. Component 수집 : collect()

## 1. 출력

+ **forEach** 은 stream의 각 component를 소모하여 명시된 동작을 수행

```java
Stream<String> stream = Stream.of("하나", "둘", "셋", "넷");
stream.forEach(s -> System.out.println(s));
```

## 2. 소모

+ **reduce()** 은 첫번째와 두변째 요소를 가지고 명시된 연산을 수행 뒤, 그 결과와 세번째 요소를 가지고 또 다시 연산을 수행
    + 초기 값을 설정하면 초기 값과 첫번째 요소가 처음에 연산이 수행된다.
    + 반환 값은 `Optional<T>`가 아닌 T 타입을 반환한다.

```java
Stream<Integer> stream1 = Stream.of(11,22,33,44);
Stream<String> stream2 = Stream.of("넷", "둘", "셋", "하나");
Stream<String> stream3 = Stream.of("넷", "둘", "셋", "하나");

int result1 = stream1.reduce(0,(i1,i2) -> i1 + i2);

Optional<String> result2 = stream2.reduce((s1, s2) -> s1 + "++" + s2);String result3 = stream3.reduce("시작", (s1, s2) -> s1 + "++" + s2);

result2.ifPresent(n -> System.out.println(n));  // 결과 : 넷++둘++셋++하나
System.out.println(result1);                    // 결과 : 110
System.out.println(result3);                    // 결과 : 시작++넷++둘++셋++하나
```
## 3. 검색

+ **findFirst()** 
    + 여러 요소가 조건에 부합해도 Stream 순서를 고려하여 가장 앞에 있는 첫번째 요소를 고른다. 
    + Optional 객체로 반환한다.

+ **findAny()**
    + 가장 먼저 찾은 요소를 고른다.
    + Optional 객체로 반환한다.

```java
IntStream stream1 = IntStream.of(4, 2, 7, 3, 5, 1, 6);
IntStream stream2 = IntStream.of(4, 2, 7, 3, 5, 1, 6);

OptionalInt result1 = stream1.sorted().findFirst();
OptionalInt result2 = stream2.sorted().findAny();

System.out.println(result1.getAsInt());         //결과 : 1
System.out.println(result2.getAsInt());         //결과 : 1
```

## 4. 검사

해당 Stream의 요소 중에서 특정 조건을 만족하는 요소가 잇는지 아닌지 체크하는 메소드들

+ **anyMatch()**
    + 일부 요소가 특정 조건을 만족할 경우 true
+ **allMatch()**
    + 모든 요소가 특정 조건을 만족할 경우 true
+ **noneMatch()**
    + 모든 요소가 특정 조건을 만족하지 않는 경우 true

```java
IntStream stream1 = IntStream.of(30,80,70,100);
IntStream stream2 = IntStream.of(30,80,70,100);
IntStream stream3 = IntStream.of(30,80,70,100);

System.out.println(stream1.anyMatch(n -> n >=80));  //true
System.out.println(stream2.allMatch(n -> n >=80));  //false
System.out.println(stream3.noneMatch(n -> n >=80)); //false
```
## 5. 통계

+ **count()**
    + Stream 요소의 총 개수를 long 타입의 값으로 반환

+ **max()**
    + Stream 요소 중 가장 큰 값을 가지고 Optional 객체로 반환

+ **min()**
    + Stream 요소 중 가장 작은 값을 가지고 Optional 객체로 반환

```java
IntStream stream1 = IntStream.of(30,80,70,100);
IntStream stream2 = IntStream.of(30,80,70,100);
IntStream stream3 = IntStream.of(30,80,70,100);

System.out.println(stream1.count());                    // 4

stream2.max().ifPresent(n -> System.out.println(n));    // 100
//System.out.println(stream2.max().getAsInt());
stream3.min().ifPresent(n -> System.out.println(n));    // 30
//System.out.println(stream2.min().getAsInt());
```

## 6. 연산

+ **sum()**
    + Stream 요소들 합을 반환한다.
+ **average()**
    + Stream 요소들의 평균을 optional 객체로 반환합니다

```java
IntStream stream1 = IntStream.of(30,80,70,100);
DoubleStream stream2 = DoubleStream.of(30.3, 90.9, 70.7, 10.5);

System.out.println(stream1.sum());                  //280
stream2.average().ifPresent(System.out::println);   //50.6
//System.out.println(stream2.average().getAsDouble());
```

## 7. 수집

+ **collect()**
    + 인수로 전달되는 Collectors 객체에 구현된 방법대로 Stream 요소를 수집해 원하는 Collection 클래스로 반환할 수 있다.
    + 이 외에도 사용자가 직접 Collector 인터페이스를 구현하여 자신만의 수집 방법을 정의할 수 있다.

#### 1. Stream을 배열이나 컬렉션으로 변화
    + toArray(), toCollection(), toList(), toSet(), toMap()

2. 요소의 통계와 연산 메소드와 같은 동작을 수행
    + Counting(), maxBy(), minBy(), summingInt(), averagingInt() 등

3. 요소의 소모와 같은 동작 수행
    + reducing(), joining()

4. 요소의 그룹화와 분할
    + groupingBy(), partitioningBy()

```java
```

## 참조
http://www.tcpschool.com/java/java_stream_terminal