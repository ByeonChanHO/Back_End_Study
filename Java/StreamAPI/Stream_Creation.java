import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Creation {

    public static void first(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        Stream<Integer> stream = list.stream(); //collection에서 stream으로 변환
        stream.forEach(System.out::println);    //forEach() 로 stream component를 순차적으로 접근
    }

    public static void second(){
        String[] arr = new String[]{"넷", "둘", "셋", "하나"};

        // 배열에서 스트림 생성
        Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(e -> System.out.print(e + " "));
        System.out.println();
        //결과 : 넷 둘 셋 하나

        // 배열의 특정 부분만을 이용한 스트림 생성
        Stream<String> stream2 = Arrays.stream(arr, 1, 3);  //1에서 3번째까지의 index을 가져온다.
        stream2.forEach(e -> System.out.print(e + " "));    //(1,2 index를 가져옴)
        
    }
    public static void third(){
        Stream<Double> stream = Stream.of(4.2,2.5,3.1,1.8);
        stream.forEach(System.out::println);                //4.2, 2.5, 3.1, 1.8 출력
    }
    public static void four(){
        IntStream stream1 = IntStream.range(1,4);
        IntStream stream2 = IntStream.rangeClosed(1,4);

        stream1.forEach(n -> System.out.print(n + " "));    //1,2,3 출력
        System.out.println();
        stream2.forEach(n -> System.out.print(n + " "));    //1,2,3,4 출력
    }


    public static void five(){
        IntStream stream = new Random().ints(5);
        stream.forEach(System.out::println); //랜덤한 수 5개가 나온다.
    }
    public static void six(){
        // 무한으로 component가 생성되기에 limit 으로 사이즈를 고정 시켰다.
        Stream<Integer> stream = Stream.iterate(2, n -> n + 2).limit(4);
        stream.forEach(n -> System.out.print(n + " "));
    }
    public static void seven(){
        // 파일이 없어 실행 못함.
    }
    public static void eight(){
        Stream<Object> stream = Stream.empty();
        System.out.println(stream.count());     //stream의 component 총 개수 출력
    }




    public static void main(String arg[]){
        System.out.println("first()");
        first();
        System.out.println("\n second()");
        second();
        System.out.println("\n third()");
        third();
        System.out.println("\n four()");
        four();
        System.out.println("\n five()");
        five();
        System.out.println("\n six()");
        six();
        System.out.println("\n seven()");
        seven();
        System.out.println("\n eight()");
        eight();

    }
}
