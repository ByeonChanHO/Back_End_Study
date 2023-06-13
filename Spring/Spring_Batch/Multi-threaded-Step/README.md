![image](https://github.com/ByeonChanHO/Back_End_Study/assets/38696775/077c8b8a-1114-49d4-8a2e-ed820a28fe8d)

![image](https://github.com/ByeonChanHO/Back_End_Study/assets/38696775/8feedaca-31e9-40ba-924c-3a2b61512633)
![image](https://github.com/ByeonChanHO/Back_End_Study/assets/38696775/0ff26d72-56a6-44f1-b2eb-16b8ff088541)



[ChunkorientedTasklet]
![image](https://github.com/ByeonChanHO/Back_End_Study/assets/38696775/50c54d32-a1be-40ba-90be-b4d51bbf334a)



## 문제점
+ 새로운 Thread가 생성되어 실행될 경우가 있다
  + 예를 들어, 이름에 21번의 Thread까지 생성 되었다가 22번의 Thread가 생성될때가 있어 난감하다
  + 해당 22번 Thread 가 그럼 계속 작업하는 여부도 확인해야된다.

+ 1년이 안지난 데이터를 조회할 경우, chunk 에 보낼 데이터를 null로 설정하면, 모든 스레드 작업이 같이 종료된다.
  + (TaskExcutorReapeatTemplate에 있는 

## 해결법
 + 새로운 Thread가 생성되어 실행될 경우가 있다
  + => 해당 삭제하는 일자를 정하고 stack 이나 queue 로 넣어서 Thread 반호 상관없이 해당 일자를 영구적으로 줘서 작업 처리
  + => 해당 Thread sleep 으로 재워버리기
