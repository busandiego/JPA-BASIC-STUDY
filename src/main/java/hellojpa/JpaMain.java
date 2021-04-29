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
        System.out.println("aaa");
        try {

            Member member = new Member();
            member.setName("안녕");

            System.out.println("=====================");
            em.persist(member);
            System.out.println("member.id: " + member.getId());
            System.out.println("=====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
