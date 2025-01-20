package dao;

import entity.Website;
import jakarta.persistence.*;

import java.math.BigDecimal;

public class WebsiteDAO {
    public Website findById(Long id) {
        //return entityManager.find(Website.class, id);
        return null;
    }

    public void persist(Website website) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(website);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
    public void delete(Website website) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(website);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
