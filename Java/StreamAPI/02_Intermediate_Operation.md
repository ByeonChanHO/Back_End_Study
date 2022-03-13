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
    + 내부적으로 Object 클래스의 equals() 메소드로 component의 중복을 비교한다.

```java
IntStream stream1 = IntStream.of(7,4,4,1,2,3,4,5,6);
IntStream stream2 = IntStream.of(7,6,6,1,2,3,4,5,6);

// 결과(홀수) : 7 1 3 5
stream1.filter(n -> n%2 != 0).forEach(n -> System.out.print(n + " "));
System.out.print("\n");

//결과(중복제거) : 7 6 1 2 3 4 5
stream2.distinct().forEach(n -> System.out.print(n + " "));
```

## Stream 변환

+ **map()** 은  해당 스트림의 component들을 주어진 함수에 인수로 전달하고 반환값으로 이루어진 새로운 Stream을 반환한다.
+ **flatMap()** 은 각 배열의 각 component의 반환 값을 하나로 합친 새로운 스트림을 반환한다.

```java
Stream<String> stream1 = Stream.of("JAVA", "Spring", "KAFKA");
String[][] str = new String[][]{{"java", "stream"}, {"KAFKA", "pub-sub"}, {"Spring", "Don't know"}};
String[] str2 = {"I study hard", "You study JAVA", "I am hungry"};
        

stream1.map(s -> s.length())
    .forEach(s -> System.out.println(s)); //결과 : 4,6,5
        
Arrays.stream(str).flatMap(array -> Arrays.stream(array))
    .forEach(n -> System.out.println(n)); //결과 : java stream KAFKA pub-sub Spring Don't know
Arrays.stream(str2).flatMap(s -> Stream.of(s.split(" +")))
    .forEach(System.out::println);  //결과 I study hard You study JAAVA I am hungry
```


## Stream 제한

+ **limit()** 은 stream 의 사이즈 크기를 정하는 메소드이다.
+ **skip()** 은 stream 몇 번째 component 까지 스킵하는 메소드다.

```java
IntStream stream1 = IntStream.range(0, 10);
IntStream stream2 = IntStream.range(0, 10);
IntStream stream3 = IntStream.range(0, 10);

stream1.skip(3).forEach(n -> System.out.print(n + " "));
System.out.println();
//결과 : 3 4 5 6 7 8 9

stream2.limit(4).forEach(n -> System.out.print(n + " "));
System.out.println();
//결과 : 0 1 2 3

stream3.skip(3).limit(4).forEach(n -> System.out.print(n + " "));
//결과 : 3 4 5 6
```

## Stream 정렬

+ **Sorted()** 은 비교자(Comparator)을 이용하여 정렬한다.
    + Default 로는 사전 편찬 순으로 정렬된다.

```java
IntStream stream1 = IntStream.of(8,5,2,0,1,4,7,9,6,3);
Stream<Integer> stream2 = Stream.of(8,5,2,0,1,4,7,9,6,3);

stream1.sorted().forEach(n -> System.out.print(n + " "));
System.out.println();
// 결과 : 0 1 2 3 4 5 6 7 8 9

stream2.sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n + " "));
//결과 : 9 8 7 6 5 4 3 2 1
```

## Stream 연산 결과 확인

+ **peek()** 은 원본 stream 에서 component를 소모하지 않고 명시된 동작을 수행한다.
    + 그렇기 때문에 디버깅용으로 주로 많이 사용한다.

```java
IntStream stream = IntStream.of(9,8,7,6,5,4,3,2,1,0);

stream.peek(n -> System.out.println("시작 : " + n)).skip(3)     //결과 : 9,8,7,6,5,4,3,2,1,0
    .peek(n -> System.out.println("Skip(3)이후" + n)).sorted()  //결과 : 6,5,4,3,2,1,0
    .peek(n -> System.out.println("sorted()이후" + n))          //결과 : 0,1,2,3,4,5,6
    .forEach(n -> System.out.println(n));
```


## 참고
http://www.tcpschool.com/java/java_stream_intermediate

