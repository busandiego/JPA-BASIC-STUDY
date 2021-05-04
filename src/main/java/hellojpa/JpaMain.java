package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test2");

        EntityManager em = emf.createEntityManager();

        // 트랜잭션
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {


            Member member = new Member();
            member.setUsername("member1");
            member.setId(1L);

            em.persist(member);

            Team team = new Team();
            team.setName("teamA");

            // 애매해지는 부분
            // 왜래키가 member 테이블에 있음
            // member를 업데이트 쳐줌.
            team.getMembers().add(member);

            em.persist(team);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }


}
