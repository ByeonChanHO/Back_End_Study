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


## GraphQL 사용법
```GQL
query{
    req1 : getPhotos{
        url
        tag
    }
    req 2: getById(id:3){
        id
        url
        tag
    }
    req3 : getByCategory(category:"animal"){
        url
        tag
    }
}
```
+ **query**
    + GraphQL의 operation type

+ **getPHotos**
    + 호출할 API 명

+ **url** 과 **tag**
    + 변수명


## GraphQL 과 REST API
+ REST API
    + 요청은 쉽지만 응답 받은 데이터는 비효율적
+ GraphQL
    + 요청은 복잡하지만 응답 받은 데이터는 효적




## 참조

https://www.youtube.com/watch?v=xiE9-S7s9rs
