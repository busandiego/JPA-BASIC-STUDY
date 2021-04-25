package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        
        // 트랜잭션
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//            Member m = new Member();
//            m.setId(2L);
//            m.setName("JPA 2");
//            em.persist(m);
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                                .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}