import java.util.Arrays;
import java.util.stream.*;

class streamAPI{

    public static void first_stream(){
        int[] arr = {1,2,3,4,5};
        IntStream stm1 = Arrays.stream(arr);            //Array를 stream 형으로 변환
        IntStream stm2 = stm1.filter(n -> n%2 == 1);    //filter 로 조건에 만족하는 component 추출(중간 연산)
        int total = stm2.sum();                         //모든 component 덧셈(최종 연산)
        System.out.println( "값 :" + total );
    
    }


    public static void first_stream2(){
        int[] arr = {1,2,3,4,5};

        //지연 처리(Lazy) 처리 방식이 가능
        int total = Arrays.stream(arr)                  //Array를 stream 형으로 변환
            .filter(n -> n%2 == 1)                      //filter
            .sum();                                     //sum
                                                        //한문장으로 통합.
        System.out.println("값2 : " + total);
    }


    public static void main(String[] args){
        first_stream();
        first_stream2();
    }



}

