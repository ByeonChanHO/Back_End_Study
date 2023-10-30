# JVM Heap
VM(Java Virtual Machine) Heap은 Java 프로그램에서 동적으로 할당되는 메모리 영역 중 하나로, 객체 인스턴스와 배열 등의 데이터를 저장하는 공간입니다. JVM Heap은 Java 애플리케이션의 실행 중에 메모리를 관리하고, 객체의 생성과 해제, 그리고 메모리 사용량을 관리합니다.

## Heap 의 두가지 영역

1. **Young Generation (젊은 세대)**: 이 영역은 새로 생성된 객체가 저장되는 곳으로, 대부분의 객체는 이 공간에서 생성됩니다. Young Generation은 다시 세부적으로 Eden 영역과 두 개의 Survivor 영역 (S0, S1)으로 나뉩니다.
   객체가 처음 생성되면 Eden 영역에 저장되며, 일정 시간 동안 살아남으면 Survivor 영역 중 하나로 이동하고, 계속해서 살아남으면 다시 다른 Survivor 영역으로 이동합니다. 이 과정은 GC(Garbage Collection) 과정 중에 일어납니다.

3. **Old Generation (노인 세대 또는 힙)**: Young Generation에서 일정 시간 동안 살아남은 객체는 Old Generation으로 이동합니다. Old Generation은 일반적으로 Young Generation보다 크고 오래 저장되는 객체들을 담는 공간입니다.
 Old Generation에서 GC가 발생할 때는 Major GC 또는 Full GC라고도 부릅니다. Major GC는 Old Generation에서 일어나며, Full GC는 Young Generation과 Old Generation 모두에서 발생하는 가장 강력한 형태의 GC입니다.

## 장점
JVM Heap은 Java 애플리케이션의 메모리 사용을 관리하며, GC를 통해 더 이상 사용되지 않는 객체를 정리하여 메모리를 회수합니다. 
이것은 Java의 강력한 메모리 관리와 안정성을 제공하며, 개발자가 메모리 관리에 대해 너무 많은 걱정을 하지 않고도 안정적인 애플리케이션을 개발할 수 있도록 도와줍니다.
