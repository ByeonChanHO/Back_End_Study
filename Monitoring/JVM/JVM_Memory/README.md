# JVM Memory
말 그대로 JVM Memory 에 대한 것

## JVM Memory 지표
> ### JVM Heap
>
> Java 프로그램에서 동적으로 할당되는 메모리 영역 중 하나로, Object instance와 배열 등의 데이터를 저장하는 공간이다
>
> 해당 지표에서 애플리케이션의 실행 중에 메모리를 관리함으로 객체의 생성과 해제 그리고 메모리 사용량을 관리한다.
>
> ### JVM Non-Heap
>
> Non-Heap 은 Heap 이외의 부분(stack)을 나타냅니다.
>
> Non-Heap 영역에는 다양한 데이터와 자료구조가 저장되며, JVM 내부 동작 및 실행 중인 Java 프로그램의 관리를 위한 데이터를 저장하는 곳입니다.
>
> 예를 들어 java 애플리케이션의 코드 실행 및 클래스 로딩, 네이티브 메서드 호출 및 직접 메모리 할당(stack) 과 같은 JVM의 내부 동작을 관리하는 데 중요
>
> ### JVM Total
> JVM 의 메모리 영역을 말하며 JVM 에서 사용 가능한 총 메모리 양을 나타낸다
>
> Heap 영역 + Non-Heap 영역 Memory 이다.
