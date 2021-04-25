package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        
        // 트랜잭션
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member findMember = em.find(Member.class, 1L);
            System.out.println("getId: " + findMember.getId());
            System.out.println("getName: " + findMember.getName());

            findMember.setName("HelloJPA");

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
