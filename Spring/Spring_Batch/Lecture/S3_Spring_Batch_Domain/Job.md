# Job

## [기본개념]
> Job 은 배치 계층 구조에서 가장 상위에 있는 개념으로 하나의 배치작업 자체를 의미한다.
> 
> 또한 Job Configuration을 통해 객체 단위로서 존재하며, 배치 작업을 어떻게 구성하고 실행할 것인지 전체적으로 설정하고 명세 해놓은 것이다.
> 
> 즉, Job 자체가 배치 하나라고 생각하고 배치의 명세서라고 생각하면된다.
> 
> Spring Batch 는 배치 Job 을 구성하기 위한 최상위 인터페이스이며 Job 을 위해 기본 구현체를 제공한다.
> 
> Job 은 여러 Step을 포함하고 있는 컨테이너로서 반드시 하나 이상의 Step 으로 구성되어야 한다.
>
## [기본 구현체]
> Spring Batch 가 제공하는 구현체는 총 2가지다
> 1. SimpleJob
> - 가장 보편적인 구현체로 순차적으로 step을 실행시키는 Job이다.
> - 모든 Job에서 유용하게 사용할 수 있는 표준 기능을 가지고 있다.
>
> 2. FlowJob
> - 특정한 조건과 흐름에 따라 Step을 구성하여 실행시키는 Job이다.
> - Flow 객체를 실행시켜서 작업을 진행할 수 있다.

## [Job 실행 구조]
> ![image](https://github.com/ByeonChanHO/Back_End_Study/assets/38696775/acb04e0e-b5e9-41ea-94c7-253277279846)
>
> JobParameters 로 파라미터 인자값과 실행할 Job을 JobLauncher에 넣어주면, JobLauncher가 Job을 실행하게 되고 Job은 JobExecution 인자값을 받아 execute 실행을 하여 각 Step들을 생성해 실행된다.
>
> Job이 실행 될때에는 AbstractJob 들로 구성되어 실행이 되는데, 자세한 인자들의 설명은 위의 그림과 같다.
>
## [간단 Job 코드 실행 순서]
> Job에 start 와 next 을 사용해서 step을 지정하면 job은 simpleJobBuilder 을 통해 해당 step들을 step list 변수에 넣고 SimpleJob을 선언하여 해당 SimpleJob에 설정한 Job 이름과 step list 들을 넣어준다.
>
> 이후 JobLauncherApplicationRunner을 통해 jobLauncher와 jobExplorer, jobRepository 를 가져와 jobLauncher에 파라미터 및 job을 넣어 원하는 job을 실행 시킨다.
>
> 여기서 jobLauncher은 SimpleJobLauncher을 통해 실행된다.
