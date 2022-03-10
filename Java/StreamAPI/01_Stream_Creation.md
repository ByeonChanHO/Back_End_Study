# Stream_Creation(스트림 생성)

Stream 생성은 다양한 소스에서 생성될 수 있다.

1. Collections
2. Array
3. Variable Parameter(가변 매개변수)
4. 지정된 범위의 연속된 정수
5. 특정 타입의 난수들
6. Lambda Expression(람다 표현식)
7. File(파일)
8. Empty Stream(빈 스트림)

## 1. Collection

```java
ArrayList<Integer> list = new ArrayList<Integer>();

list.add(4);
list.add(3);
list.add(2);
list.add(1);

Stream<Integer> stream = list.stream(); //collection에서 stream으로 변환
stream.forEach(System.out::println);    //forEach() 로 stream component를 순차적으로 접근
```

*forEach* 메소드는 해당 스트림의 component를 하나씩 소모해가며 순차적으로 접근하는 메소드로 같은 스트림으로 

forEach() 메소드를 한 번빡에 호출할 수 없다.

단, 원본 데이터 component를 소모한 것이 아니여서 다른 stream으로 forEach 를 호출할 수 있다.

## 2. Array(배열)

stream 내에 IntStream, LongStream, DoubleStream 인터페이스가 각각 제공되어 있어

기본 타입인 int, long, double 형 배열을 stream 으로 저장 할 수 있다. 

```java
String[] arr = new String[]{"넷", "둘", "셋", "하나"};

// 배열에서 스트림 생성
Stream<String> stream1 = Arrays.stream(arr);
stream1.forEach(e -> System.out.print(e + " "));
System.out.println();
//결과 : 넷 둘 셋 하나

// 배열의 특정 부분만을 이용한 스트림 생성
Stream<String> stream2 = Arrays.stream(arr, 1, 3);  //1에서 3번째까지의 index을 가져온다.
stream2.forEach(e -> System.out.print(e + " "));    //(1,2 index를 가져옴)
```

## 3. Variable Parameter(가변 매개변수)

Stream 클래스의 of() 메소드를 이용하면 가변 매개변수로 Stream을 생성할 수 있다.

```java
Stream<Double> stream = Stream.of(4.2,2.5,3.1,1.8);
stream.forEach(System.out::println);                //4.2, 2.5, 3.1, 1.8 출력
```

## 4. 지정된 범위의 연속된 정수

지정된 범위의 연속된 정수를 Stream으로 생성하기 위해 IntStream과 LongStream interface에 range() 와 rangeClosed() method가 정의되어 있다.

+ **range()** 메소드는 명시된 시작 정수를 포함하지만, 명시된 마지막 정수는 포함되지 않는 Stream 생성
+ **rangeClosed()** 는 명시된 시작 정수뿐만 아니라 명시된 마지막 정수까지 포함되는 Stream 생성

```java
IntStream stream1 = IntStream.range(1,4);
IntStream stream2 = IntStream.rangeClosed(1,4);

stream1.forEach(n -> System.out.print(n + " "));    //1,2,3 출력
System.out.println();
stream2.forEach(n -> System.out.print(n + " "));    //1,2,3,4 출력
```

## 5. 특정 타입의 난수들

Random 클래스에는 ints(), longs(), doubles()와 같은 메소드를 통해 타입을 정하고 난수를 발생시킨다.

난수를 발생시킬 때는 곡 크기를 정해야해야한다.

(크기를 안 정할 시 무한 스트림을 반환되어 limit() 메소드로 stream 크기를 제한해하는 번거러움 생긴다.)

```java
IntStream stream = new Random().inits(5);
stream.forEach(System.out::print);          //5개의 난수가 나온다.
```

## 6. Lambda Expression(람다 표현식)

람다 표현식으로 component을 발생시켜 Stream으로 만들 수 있다.

주요 메소드는 iterate() 와 generate() 다

+ **iterate()** 는 시드로 명시된 값을 람다 표현식에 사용하여 반환된 값을 다시 시드로 사용하는 방식으로 무한 stream을 생성한다.
+ **generate()** 는 매개변수가 없는 람다 표현식을 사용하여 반환된 값으로 무한 stream을 생성한다.

+ 주의 : 무한으로 갈 결우 limit() 메소드로 사이즈 크기를 정하자.

```java
Stream<Integer> stream = Stream.iterate(2, n -> n + 2).limit(4); //2,4,6,8
stream.forEach(n -> System.out.print(n + " "));
```

## 7. File(파일)

파일의 한 행(line)을 component로 하는 stream을 생성하기 위해 java.nio.file.Files 클래스에는 line() 메소드가 정의되어 있다.
java.io.BufferedRoader 클래스의 lines() 메소드를 사용하면 파일뿐만 아니라 다른 입력으로부터도 데이터를 행(line) 단위로 읽어 올 수 있다.

```java
String<String> stream = Files.lines(Path path);
```

## 8. Empty Stream(빈 스트림)

빈 스트림은 Stream 클래스에 있는 empty() 메소드를 사용하여 생성 가능하다.

```java
Stream<Object> stream = Stream.empty();
System.out.println(stream.count());     //stream의 component 총 개수 출력
```


## 참조
http://www.tcpschool.com/java/java_stream_creation