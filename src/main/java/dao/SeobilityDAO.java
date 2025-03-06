package dao;

import entity.Seobility.SeoResult;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SeobilityDAO {
    public SeoResult findById(Long id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        SeoResult seoResult = entityManager.find(SeoResult.class, id); // Fetch SeoResult

        if (seoResult != null) {
            // Force loading hints and keywords (if not using EAGER fetching)
            seoResult.getHints().size();
            seoResult.getKeywords().size();
        }

        entityManager.close();
        return seoResult;
    }


    public void persist(SeoResult seoData) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(seoData);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
    public void delete(SeoResult seoData) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(seoData);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
