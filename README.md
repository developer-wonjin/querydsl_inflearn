# QueryDSL 프로젝트
- JPA, SQL, Mongodb, Lucene 등을 QueryDSL이 지원한다.
- SpringData 프로젝트가 아래 DB를 지원하는 것과 유사
  - common, jpa, redis 등등

# Querydsl의 필요성
개발시 다음과 같은 문제로 개발에 어려움을 겪는다
- 복잡한 쿼리
- 동적 쿼리

## Querydsl을 통해 할 수 있는 것
- query --> java   (쿼리문을 자바코드로 변환함)
- sql이 java문법으로 컴파일 시점에 검사되어 런타임예외를 피할 수 있다.
    - JPQL java String보다 더 좋은 이유
    - 아래 예시에서 JPQL은 컴파일시점에 오류를 잡지 못한다.

```java
//JPQL의 단점 예시
//`where`앞에 띄어쓰기가 없는 상태
String query = "select m from Member m" + 
        "where m.username = :username";
```
- 쉬운 SQL스타일 문법
- 단순 반복하지 않을 수 있다


