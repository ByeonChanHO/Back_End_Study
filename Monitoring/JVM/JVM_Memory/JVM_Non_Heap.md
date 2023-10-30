# JVM Non Heap
JVM(Java Virtual Machine) Non-Heap 영역은 JVM 메모리 구조에서 Heap 이외의 부분을 나타냅니다. 
Non-Heap 영역에는 다양한 데이터와 자료구조가 저장되며, JVM의 내부 동작 및 실행 중인 Java 프로그램의 관리를 위한 데이터를 저장하는 곳입니다.

## 구성 요소
1. **Method Area (메서드 영역)**: Method Area는 클래스 파일의 바이트 코드, 메서드 및 클래스 수준의 정보, 정적 변수(static variables), 상수 풀(constant pool) 등을 저장하는 공간입니다. 
모든 스레드에서 공유되는 영역으로, 클래스 로딩 시 클래스 정보가 이 공간에 로드됩니다. 메서드 영역은 PermGen(Permanent Generation) 또는 Metaspace(Java 8부터)라고도 불립니다.

2. **Native Method Stack (네이티브 메서드 스택)**: Java 애플리케이션에서 사용되는 네이티브(native) 메서드, 즉 Java가 아닌 네이티브 코드(C, C++ 등)로 작성된 메서드의 호출 및 관리에 사용됩니다.
네이티브 메서드 스택은 Java 스택과는 별도로 관리됩니다.

3. **Direct Memory (직접 메모리)**: Java의 NIO(Native I/O)를 통해 할당되는 메모리 공간으로, ByteBuffer 및 기타 네트워크 또는 I/O 작업에 사용되는 버퍼를 관리하는 데 사용됩니다. 
이 영역은 일반적으로 JVM 외부의 메모리를 할당하며, GC(Garbage Collection)의 대상이 아닙니다.

## 설명
Non-Heap 영역은 Java 애플리케이션의 코드 실행 및 클래스 로딩, 네이티브 메서드 호출 및 직접 메모리 할당과 같은 JVM의 내부 동작을 관리하는 데 중요합니다. Non-Heap 영역의 크기와 동작은 JVM의 구현에 따라 다를 수 있으며, JVM 매개변수를 통해 조절할 수 있습니다. 
Non-Heap 영역은 일반적으로 Heap 영역보다 상대적으로 작지만, Java 애플리케이션의 성능과 안정성에 중요한 역할을 합니다.
