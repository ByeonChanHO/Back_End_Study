![image](https://github.com/ByeonChanHO/Back_End_Study/assets/38696775/077c8b8a-1114-49d4-8a2e-ed820a28fe8d)


## 문제점
+ 새로운 Thread가 생성되어 실행될 경우가 있다
  + 예를 들어, 이름에 21번의 Thread까지 생성 되었다가 22번의 Thread가 생성될때가 있어 난감하다

+ 1년이 안지난 데이터를 조회할 경우, chunk 에 보낼 데이터를 null로 설정하면, 모든 스레드 작업이 같이 종료된다.
  + (TaskExcutorReapeatTemplate에 있는 
