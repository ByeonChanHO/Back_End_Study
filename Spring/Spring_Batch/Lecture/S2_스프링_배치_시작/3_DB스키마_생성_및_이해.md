
# DB 스키마 생성 및 이해


## Spring Batch DB Schema(스프링 배치 DB 스키마)
### - 배경
  >  Job 및 Step, Tasklet 을 실행 시키기 위해서는 해당 파트들의 상태 및 파라미터 등의 정보가 존재있어야 한다.
  >
  > 즉, JOb 이나 Step, Tasklet이 실행하기 위해서는 여러 도메인들의 정보들이 필요하다는 뜻이다
  >
  > 그렇기 떄문에, Spring Batch 는 메타 데이터들을 테이블로 만들어 저장할 수 있는 DB schema 를 자체적으로 제공을 한다.
  > 
  > ( 참고, 여러 도메인들 정보를 메타 데이터라고 하며, 해당 메타 데이터를 저장하기 위해서는 해당 메타 테이블이 생성되어야 한다 )
### - 목적
  > 1. 스프링 배치의 실행 및 관리를 위한 목적으로 여러 도메인들(Job, Step, JobParameters..) 의 정보들을 저장, 업데이트, 조회할 수 있도록 Schema 를 제공
  > 2. 과거, 현재의 실행에 대한 세세한 정보, 실행에 대한 성공과 실패 여부 등을 일목요연하게 관리함으로서 배치 운용에 있어 리스크 발생시 빠른 대처를 가능하도록 하기 위해
  > 3. DB 와 연동할 경우 필수적으로 메타 테이블이 생성 되어야 하기 때문에 (수동으로 생성해야한다는 소리 )

### - DB 스키마 생성 설정
  > **제공 파일 위치** : /org/springframework/batch/core/schema-*.sql ( DB 유형 별로 이름이 다름)
  >
  > **스키마 수동 생성 설정** : 해당 파일 위치에 있는 쿼리를 복사 후 직접 실행
  > 
  > **스키마 자동 생성 설정** : spring.batch.jdbc.initialize-schema 설정을 내부적으로 처리하면 된다.
  > 
        - ALWAYS : 스크립트가 항상 실행되면서 자동으로 스키마가 생성함
                 : RDBMS 설저이 되어 있을 경우 내장 DB 보다 우선적으로 실행됨
        - EMBEDDED : 내장 DB 일 때만 실행 되며 스키마가 자동 생성됨, 기본값으로
        - NEVER : 스크립트가 항상 실행이 안됨
                : 내장 DB 일 경우, 스크립트가 생성이 안되기 떄문에 오류 발생
                : 운영에서 수동으로 스크립트 생성 후 설정하는 것을 권장
  > 
  
### - DB 스키마 테이블 구조
> ![image](https://github.com/ByeonChanHO/Back_End_Study/assets/38696775/9e8932e5-b5f0-49b6-9364-1d644371c48c)
>
>
>
>
> #### **Job 관련 테이블**
>
    Batch_Job_Instance
      - Job 이 실행될 때 JobInstance 정보가 저장되며 job_nam과 job_key를 키로 하여 하나의 데이터가 저장
      - 동일한 job_name 과 job_key 로 중복 저장될 수 없다.(즉, job_name과 job_key 는 유니크한 값으로 설정됨)

    Batch_Job_Execution
      - job의 실행정보가 저장되며 Job 생성, 시작, 종료 시간, 실행상태, 메시지 등을 관리

    Batch_Job_Execution_Params
      - Job과 함께 실행되는 JobParameter 정보를 저장

    Batch_Job_Execution_Context
      - Job 의 실행동안 여러가지 상태정보, 공유 데이터를 직렬화 (Json 형식) 해서 저장
      - Step 간 서로 공유 가능

> #### **Step 관련 테이블**
>
    Batch_Step_Execution
      - Step 의 실행정보가 저장되며 생성, 시작, 종료시간, 실행상태, 메시지 등을 관리

    Batch_Step_Execution_Context
      - Step 의 실행동안 여러가지 상태정보, 고유 데이터를 직렬화(Json 형식) 해서 저장
      - Step 별로 저장되며 Step 간 서로 공유할 수 없음

# 알고 가면 좋은 것
> 설정 파일인 application yml 에서 각 목적에 따른 설정 방식을 따로 분리해서 저장할 수 있다. 그게 spring.active.profile 이라는 것인데, 이걸 처음에 application.yml 에 적고 현재 적용하고 싶은 설정의 profile 이름을 적으면 된다.
> 
> 각 설정에는 spring.config.activate.on-profile 로 이름을 짓고 그 밑에 spring.* 로 설정하면 된다.


> # 참고
> https://coding-factory.tistory.com/216
> https://blogshine.tistory.com/527
> hikari
