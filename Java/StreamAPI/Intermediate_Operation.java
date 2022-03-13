import java.util.stream.*;
import java.util.Arrays;
import java.util.Comparator;


public class Intermediate_Operation {

    public static void operation1(){
        IntStream stream1 = IntStream.of(7,4,4,1,2,3,4,5,6);
        IntStream stream2 = IntStream.of(7,6,6,1,2,3,4,5,6);

        // 결과(홀수) : 7 1 3 5
        stream1.filter(n -> n%2 != 0).forEach(n -> System.out.print(n + " "));
        System.out.print("\n");

        //결과(중복제거) : 7 6 1 2 3 4 5
        stream2.distinct().forEach(n -> System.out.print(n + " "));
    }

    public static void operation2(){
        Stream<String> stream1 = Stream.of("JAVA", "Spring", "KAFKA");
        String[][] str = new String[][]{{"java", "stream"}, {"KAFKA", "pub-sub"}, {"Spring", "Don't know"}};
        String[] str2 = {"I study hard", "You study JAVA", "I am hungry"};
        

        stream1.map(s -> s.length())
        .forEach(s -> System.out.println(s)); //결과 : 4,6,5
        
        Arrays.stream(str).flatMap(array -> Arrays.stream(array))
        .forEach(n -> System.out.println(n)); //결과 : java stream KAFKA pub-sub Spring Don't know
        Arrays.stream(str2).flatMap(s -> Stream.of(s.split(" +")))
        .forEach(System.out::println);  //결과 I study hard You study JAAVA I am hungry
    }

    public static void operation3(){
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
    }

    public static void operation4(){
        IntStream stream1 = IntStream.of(8,5,2,0,1,4,7,9,6,3);
        Stream<Integer> stream2 = Stream.of(8,5,2,0,1,4,7,9,6,3);

        stream1.sorted().forEach(n -> System.out.print(n + " "));
        System.out.println();
        // 결과 : 0 1 2 3 4 5 6 7 8 9

        stream2.sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n + " "));
        //결과 : 9 8 7 6 5 4 3 2 1
    
    }

    public static void operation5(){
        IntStream stream = IntStream.of(9,8,7,6,5,4,3,2,1,0);

        stream.peek(n -> System.out.println("시작 : " + n)).skip(3)     //결과 : 9,8,7,6,5,4,3,2,1,0
            .peek(n -> System.out.println("Skip(3)이후" + n)).sorted()  //결과 : 6,5,4,3,2,1,0
            .peek(n -> System.out.println("sorted()이후" + n))          //결과 : 0,1,2,3,4,5,6
            .forEach(n -> System.out.println(n));
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

    }

    
}
