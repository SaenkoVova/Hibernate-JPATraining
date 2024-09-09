package com.taskbot.vs;

import com.taskbot.vs.models.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(EntityManagerFactory entityManagerFactory =
                    Persistence.createEntityManagerFactory("HelloWorldPU")) {

            EntityManager entityManager = entityManagerFactory.createEntityManager();

            EntityTransaction tx = entityManager.getTransaction();

            tx.begin();

            entityManager.persist(new Message());

            tx.commit();

            entityManager.close();

            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();

            EntityManagerFactory entityManagerFactory1 = session.getEntityManagerFactory();
            entityManagerFactory1.createEntityManager();

            session.beginTransaction();

            session.getTransaction().getStatus();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}