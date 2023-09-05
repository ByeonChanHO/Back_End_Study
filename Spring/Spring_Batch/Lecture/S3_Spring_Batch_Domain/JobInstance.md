# JobInstance

## [기본 개념]
> Job, Step, Flow 등이 실행될 때마다 생성되는 도메인이 있다. 생성되는 도메인들 중 하나가 바로 JobInstance 이다
> 
> JobInstance 는 Job이 실행될 때 생성되는 Job의 논리적 실행단위 객체로서 고유하게 식별 가능한 작업 실행을 말한다.
> 
> 즉, JobInstance 는 똑같은 Job이 실행되어도 안에 돌아가는 데이터 또는 파라미터 등 처리하는 내용이 다른 것을 구분하는 객체이다.
> 
> 예시, Job이 2022년 데이터를 다루도록 실행시키고 또 다시 Job 이 2023년 데이터를 다루도록 실행시킨다. 이때 JobInstance 은 2개가 생성된다. 총 2022년 데이터 하나, 2023년 데이터를 가진 Job 하나 이렇게 말이다.


## [JobInstance 생성]
> JobInstance = Job + JobParameter 으로 생성되는데, 같은 Job과 JobParameter 가 수행되면 이미 존재하는 JobInstance을 리턴한다.
>>  - 정확히 내부적으로 JobName + JobKey(JobParametes의 해시값)을 가지고 JobInstance 객체를 생성한다.
>>  - Job과는 1:M 관계로 똑같은 Job에 JobParameter을 가지고 두번 실행하면 실행되지 않는다
>>    - (이를 판단하는 기준은 BATCH_JOB_INSTANCE 테이블과 매핑으로 정해진다)
>
## [ JobInstance 저장 ]
> JobInstance의 객체는 JobName 과 JobKey(JobParametes의 해시값) 으로 정해지는데 이를 BATCH_JOB_INSTANCE 테이블에 key값(고유값)들로 저장한다.
> - 당연히 동일한 데이터는 중복해서 저장이 되지 않는다.

## [ JobInstance 생성 구조 ]
> 아래의 그림과 같이 JobLauncher 을 통해 Job을 실행시키면 해당 메타데이터를 저장하는 <strong>JobRepository(강의 후 수정 필요)</strong> 가 실행되는 Job과 JobParameter로 DB를 조회한다.
> 
> 만약 실행한 JobName과 JobKey 가 DB에 존재한다면 JobInstance가 이미 생성되었다는 것을 의미해 기존 JobInstance를 리턴한다.
>
> 만약 DB에 없다면, 기존 프로그램에 JobInstacne가 존재하는 지 체크하고 없으면 새로운 JobInstacne를 생성한다.
> ![image](https://github.com/ByeonChanHO/Back_End_Study/assets/38696775/1ca27c58-cf57-4052-a90c-9df8b7ecf419)

## [ Job 실행시 JobInstance 생성된 예제 ]
> 아래 그림과 같이 같은 Job이 실행되더라도 JobParameter가 다르면 각자의 JobInstance 가 생기며 DB 테이블에 다르게 Job Key 가 저장된다.
> ![image](https://github.com/ByeonChanHO/Back_End_Study/assets/38696775/ab1cb953-4546-4a01-b9ae-10922ab136a2)


## [알아두면 좋은 참조]
> - main으로 SpringApplication 에 run을 다른 클래스에서 ApplicationRunner을 implements 하면 우리가 run 을 override 할 수 있다.
>>
>> 이떄 override 하여 run에 원해는 실행을 넣으면 된다.
>>
>> 뭐 여기에 JobLauncher을 구현해서 넣으면 자동적으로 원하는 Job을 실행하게 할 수 있다.
>
> - application.yml 에 spring.batch.job.enabled 을 통해 자동적으로 job이 실행되는 걸 막을 수 있다.
