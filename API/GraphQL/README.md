# GraphQL(GQL)

GQL(Graph Query Language)은 QL(쿼리 언어)로, 웹 클라이언트가 데이터를 서버로부터 효율적으로 가져오는 것을 목적으로하는 언어이다.

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



참조 : https://tech.kakao.com/2019/08/01/graphql-basic/