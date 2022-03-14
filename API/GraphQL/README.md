# GraphQL(GQL)

GQL(Graph Query Language)은 QL(쿼리 언어)로, 웹 클라이언트가 데이터를 서버로부터 효율적으로 가져오는 것을 목적으로하는 언어이다.

## 배경
    iOS, Android 등 다양한 기기에서 필요한 정보의 형태가 조금씩 달랐고 기존의 REST API로는 이 것들을 일일이 구현하는 것이 힘들었기에
    
    정보를 요청하는 쪽에서 원하는 형태로 정보를 가져오고 수정할 수 있는 QL 를 만들었다.
    
    그게 GraphQL 인다.
    
    
## GraphQL로 해결한 문제(REST API와 비교)
1. **Over-Fetching**
    + 필요한 정보보다 더 많은 데이터를 전달 받는 것
    + 불필요한 리소스 낭비 발생
    + 필요한 정보만 골라내는 추가 작업이 발생
2. **Under-Fetching**
    + 필요한 데이터를 만들기 위해 여러 번의 호출이 필요
    + 추가적인 리소스 요청이 발생
    + 여러 요청을 통해 전달받은 정보를 조합하는 추가 작업이 발생
3. **단 한 개의 URL만 존재로 여러개의 URL을 통합**
    + 여러개의 URL로 나눠야하는 것을 하나의 URL로 만들 수 있다.

## GraphQL 의 Operation type
- **Query**
    + 데이터 조회

- **Mutation**
    + 데이터 수정

- **subscription**
    + 주로 실시간 애플리케이션 구현을 위해 사용





## GQL vs SQL

### SQL
1. SQL 은 Structed Query Language 로 데이터베이스 시스템에 저장된 데이터를 효육적으로 가져오는 것을 목적으로 한다.
2. 주로 백앤드 시스템에서 작성하고 호출

```SQL
SELECT plot_id, species_id, sex FROM surveys;
```

### GQL
1. GQL 은  Graph Query Language로 웹 클라이언트가 데이터를 서버로부터 효율적으로 가져오는 것을 목적으로 한다.
2. 주로 클라이언트 시스템에서 작성하고 호출한다.
3. 한번의 요청으로 데이터를 가지고 올 수 있다.

```GQL
{
    hero {
        name
        friends{
            name
        }
    }
}
```



## 참조
https://tech.kakao.com/2019/08/01/graphql-basic/
https://www.howtographql.com/basics/0-introduction/
