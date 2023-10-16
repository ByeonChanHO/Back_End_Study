# JVM
> JVM 이란 Java Virtual Machine 의 줄임말로 자바 프로그램이 실행되는 가상 컴퓨터이다.
>
# JVM Monitoring 지표들
### 1. JVM Heap
  > JVM 이 동적으로 생성된 instance나 배열 객체를 저장하는 곳
  > 
  > Java 객체들이 여기에 할당되면 Garbage Collector에 의해 관리됨
  > 
  > Heap은 대부분의 Java 프로그램 코드가 동작하는 곳으로 메모리 할다 및 해제가 자주 일어난다.

   #### - Used Max (사용 중인 최대 메모리)

      현재 시점에서 실제 사용 중인 최대 힙 메모리 양을 나타냄

      즉, 현재 시점에서 할당된 객체들이 차지하는 최대 메모리 크기
  #### - Committed Max (확정된 최대 메모리)

      JVM이 현재 프로그램에게 확정적으로 제공할 수 있는 최대 힙 메모리 양을 나타낸다.

      시간이 지남에 따라 증가할 수 있으나, 일반적으로 Max Heap Size 로 설정된 값과 같다.
