import java.util.stream.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.util.OptionalLong;


public class Terminal_Operation{

    public static void operation1(){
        Stream<String> stream = Stream.of("하나", "둘", "셋", "넷");
        stream.forEach(s -> System.out.println(s));
        //결과 : 하나, 둘, 셋, 넷
    }
    public static void operation2(){
        Stream<Integer> stream1 = Stream.of(11,22,33,44);
        Stream<String> stream2 = Stream.of("넷", "둘", "셋", "하나");
        Stream<String> stream3 = Stream.of("넷", "둘", "셋", "하나");

        int result1 = stream1.reduce(0,(i1,i2) -> i1 + i2);

        Optional<String> result2 = stream2.reduce((s1, s2) -> s1 + "++" + s2);
        String result3 = stream3.reduce("시작", (s1, s2) -> s1 + "++" + s2);

        result2.ifPresent(n -> System.out.println(n));  // 결과 : 넷++둘++셋++하나
        System.out.println(result1);                    // 결과 : 110
        System.out.println(result3);                    // 결과 : 시작++넷++둘++셋++하나

    }
    public static void operation3(){
        IntStream stream1 = IntStream.of(4, 2, 7, 3, 5, 1, 6);
        IntStream stream2 = IntStream.of(4, 2, 7, 3, 5, 1, 6);

        OptionalInt result1 = stream1.sorted().findFirst();
        OptionalInt result2 = stream2.sorted().findAny();

        System.out.println(result1.getAsInt());         //결과 : 1
        System.out.println(result2.getAsInt());         //결과 : 1
    } 
    public static void operation4(){
        IntStream stream1 = IntStream.of(30,80,70,100);
        IntStream stream2 = IntStream.of(30,80,70,100);
        IntStream stream3 = IntStream.of(30,80,70,100);

        System.out.println(stream1.anyMatch(n -> n >=80));  //true
        System.out.println(stream2.allMatch(n -> n >=80));  //false
        System.out.println(stream3.noneMatch(n -> n >=80)); //false

    }
    public static void operation5(){
        IntStream stream1 = IntStream.of(30,80,70,100);
        IntStream stream2 = IntStream.of(30,80,70,100);
        IntStream stream3 = IntStream.of(30,80,70,100);

        System.out.println(stream1.count());                    // 4

        stream2.max().ifPresent(n -> System.out.println(n));    // 100
        //System.out.println(stream2.max().getAsInt());
        stream3.min().ifPresent(n -> System.out.println(n));    // 30
        //System.out.println(stream2.min().getAsInt());

    }
    public static void operation6(){
        IntStream stream1 = IntStream.of(30,80,70,100);
        DoubleStream stream2 = DoubleStream.of(30.3, 90.9, 70.7, 10.5);

        System.out.println(stream1.sum());                  //280
        stream2.average().ifPresent(System.out::println);   //50.6
        //System.out.println(stream2.average().getAsDouble());
    }
    public static void operation7(){
        Stream<String> stream = Stream.of("넷", "둘", "하나", "셋");

        List<String> list = stream.collect(Collectors.toList());
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }

        System.out.println();

        Stream<String> stream1 = Stream.of("HTML", "CSS", "JAVA", "PHP");
        Map<Boolean, List<String>> patition = stream1.collect(Collectors.partitioningBy(s -> (s.length() % 2) == 0));

        List<String> oddLengthList = patition.get(false);

        System.out.println(oddLengthList);

        List<String> evenLengthList = patition.get(true);

        System.out.println(evenLengthList);
    }

    public static void main(String arg[]){
        System.out.println("\noperation1");
        operation1();
        System.out.println("\noperation2");
        operation2();
        System.out.println("\noperation3");
        operation3();
        System.out.println("\noperation4");
        operation4();
        System.out.println("\noperation5");
        operation5();
        System.out.println("\noperation6");
        operation6();
        System.out.println("\noperation7");
        operation7();

    }
}