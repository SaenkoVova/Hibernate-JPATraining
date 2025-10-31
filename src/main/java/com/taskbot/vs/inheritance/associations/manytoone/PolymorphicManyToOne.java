package com.taskbot.vs.inheritance.associations.manytoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PolymorphicManyToOne {
    public void doSomething() {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");) {
            EntityManager em = emf.createEntityManager();
            CreditCard cc = new CreditCard("1234567890", "01", "2022");

            User user = new User();

            user.setBillingDetails(cc);
            em.persist(cc);
            em.persist(user);

            User foundUser = em.find(User.class, 10);

            BillingDetails billingDetails = foundUser.getBillingDetails();

            // CreditCard creditCard = (CreditCard) billingDetails; -> error here because of Lazy fetching. BillingDetails is a proxy object

            CreditCard creditCard = em.getReference(CreditCard.class, billingDetails.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
