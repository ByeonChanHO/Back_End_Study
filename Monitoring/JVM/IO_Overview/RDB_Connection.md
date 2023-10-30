# RDB Connection
RDB Connection은 관계형 데이터베이스 (Relational Database)와의 연결을 나타냅니다. RDBMS (Relational Database Management System)를 사용하는 애플리케이션은 데이터베이스와 통신하려면 RDB Connection을 설정하고 관리해야 합니다.

## 구성 요소
1. <strong>JDBC(Java Database Connectivity) 드라이버</strong>: Java 프로그램이 RDBMS와 통신할 수 있도록 하는 라이브러리 또는 드라이버입니다. 각 RDBMS 벤더(예: Oracle, MySQL, PostgreSQL, SQL Server)는 자체 JDBC 드라이버를 제공하며, Java 애플리케이션은 해당 드라이버를 사용하여 데이터베이스에 연결합니다.

2. <strong>Connection Pool</strong>: RDB Connection을 효율적으로 관리하기 위해 일반적으로 커넥션 풀을 사용합니다. 커넥션 풀은 미리 생성된 데이터베이스 연결을 관리하고 애플리케이션에서 필요할 때 제공합니다. 이로써 연결 생성 및 해제의 오버헤드를 줄일 수 있습니다.

3. <strong>연결 정보</strong>: 데이터베이스 서버의 주소, 포트, 데이터베이스 이름, 사용자 이름 및 암호와 같은 연결 정보가 필요합니다. 이 정보를 사용하여 애플리케이션은 데이터베이스에 연결합니다.

4. <strong>SQL 쿼리 및 명령어</strong>: 연결이 설정되면 애플리케이션은 SQL 쿼리 및 데이터베이스 명령어를 사용하여 데이터를 조회, 삽입, 업데이트 및 삭제할 수 있습니다.


## 장점
RDB Connection은 데이터베이스와의 효율적인 통신을 가능하게 하며, 대부분의 웹 애플리케이션 및 엔터프라이즈 애플리케이션에서 중요한 역할을 합니다. RDBMS를 사용하는 애플리케이션은 데이터베이스 연결을 확립하고 쿼리를 실행하여 데이터를 처리합니다. 이를 통해 데이터의 영속성(지속성)을 유지하고 데이터의 안정성과 일관성을 보장할 수 있습니다.

## 단점
다음에
