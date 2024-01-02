# Partner Domain 개발

### 요구사항
+ 해당 pdf 를 참조
### 도메인 계층 설계 및 구현
+ 해당 pdf 를 참조


도메인의 emtity 와 로직만 보면 한 눈에 보이도록 만들어야 한다.
서비스 간에는 참조관계를 하지 말자
    서비스간의 상하 관계가 생기고 root 레벨의 의존관계가 많아져 로직이 뚱뚱해진다.



## 대체키와 DIP
+ [대체키의 필요성]
    + pdf 참조(예시1)
    + pdf 참조(예시2)

    + [구현 방법]
        + pdf 참조(구현)
        + 시간을 순서를 바꾸어 시간을 앞에 두고 랜덤으로 UUID를 사용하면 성능이 좋아지는 현상 경험이 있다고 함
        + pdf 의 그래프를 보고 공부 ㄱㄱ
    
+ [DIP, 의존성역전 원칙]
    + [정의]
        + pdf 참조
        + 하이레벨 로직이 low 로직을 의존하는 경향이 있었다. 예시로 JPA 를 쓰고 한 트랜잭션에 3개의 서비스가 있다고 하면 1개의 서비스에 Spring JPA 조회 로직, PG 연동 로직, email 발송로직의 low level 이 필요하다. high level은 low level 구현체에 의존하고 있기 때문에 만약 low level 의 구현체가 변경이 되면 high level 도 변경이 되어야한다. 이는 high level이 변경이 없는데 low level 때문에 변경되는 이슈가 생기게 된 것이다.
        + 해결방법은 DIP 를 사용하는 것이다. high level 이 low 레벨을 의존하는 게 아니라 low level 이 high level 을 의존하게 만드는 의존 역전을 사용하는 것이다. 이를 실행시키기 위해서는 interface를 사용한느 것이다. 각 구현체인 Sprin JPA 조회 로직, PG 연동 로직, Email 발송 로직을 interface 로 구현하여 각 구현체를 interface에 의존하게 만든다.
        + 결론적으로 high level의 API는 interface 까지 합친 Domain layer 을 만들게 되는 것이고 여기서 interface를 의존하는 impl 을 만들고 이게 repositoiry를 의존하여 기술을 보충하는 식으로 intfa layer 을 만들게 된다.
        + repository 인 JPA가 바뀌더라도 impl 만 바뀌면 된지 high level 에 있는 놈들은 안 바꿔도 되게 된다.


## Entity, Service 구현

+ [프로젝트 생성]
    + 프로젝트 만들때 Lombok, Spring Web, Spring Data JPA, MySQL Driver, Flyway Migration 을 dependency 하였다.
    + layer 로 만들꺼기 때문에 package에 application, common, config, domain, infrastructure, interface를 만들었다.

+ [Partner, Entity 생성]
    + @Entity 와 @slf4j, @Table(name = 'partner') 어노테이션 사용
    + @Id, @GeneratedValue(strategy = GenerationType.IDENTITY) 어노테이션을 변수에 사용
    + @Enumerated(EnumType.String) 어노테이션 사용
    + Setter 어노테이션은 문제가 있기때문에 set이 없는 변수들은 생성사로 필수값을 넣어서 만들면 된다.(@Builder 어노테이션 사용)
    + 데이터의 생성시간과 업데이트시간을 설정하는게 중요하다.
        + ZoneDateTime 이나 LocalDate 를 쓴다.
    + StringUtills.isEmpty 를 쓰면 null 이나 lenth가 0일때 true를 던진다.
    + Token의 값을 랜덤으로 생성하기 위해 TokenGenerator.randomCharacterWithPrefix(""); 을 사용

+ [AbstractEntity]   
    + @MappedSuperclass 와 @EntityListeners를 사용하였다.
    + @CreationTimestamp 와 Updatetimestamp 어노테이션 사용

+ [PartnerService, Interface]
    + 등록일때만 command 를 사용하고
    + 모든 것들의 return 은 info 로 할 것이다.

+ [PartnerCommand, Command]
    + 커맨드 구현
    
+ [PartnerInfo, Info]
    + return 값인 info 선언

+ [PartnerServiceImp, Service들]
    + 각 서비스를 주요 기능을 나열하고 그 주요 기능 이외에는 infrastructure로 보내야한다.
    + @resouce 와 @Qurify 를 사용
    + @transactional 을 사용

## Application, Interface 개요

+ [응용 계층, 외부 인터페이스 계층 구현]
    + [Facade 구현]
        + pdf 참고






