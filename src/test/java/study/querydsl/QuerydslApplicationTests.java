package study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Hello;
import study.querydsl.entity.QHello;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;
import static study.querydsl.entity.QHello.hello;


@SpringBootTest
@Transactional
class QuerydslApplicationTests {

    @Autowired
//    @PersistenceContext
    EntityManager em;

    @Test
    void contextLoads() {
        Hello helloEntity = new Hello();
        em.persist(helloEntity);

        JPAQueryFactory query = new JPAQueryFactory(em);

        Hello result = query
                .selectFrom(hello) //static import로 QType을 줄일 수 있다.
                .fetchOne();

        assertThat(result).isEqualTo(helloEntity);
        assertThat(result.getId()).isEqualTo(helloEntity.getId());
    }

}
