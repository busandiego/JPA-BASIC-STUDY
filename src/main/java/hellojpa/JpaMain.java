package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test2");

        EntityManager em = emf.createEntityManager();

        // 트랜잭션
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Order order = em.find(Order.class, 1L);

            order.getMember().getName();

            Long memberId = order.getMemberId();

            em.find(Member.class, memberId);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }


}
