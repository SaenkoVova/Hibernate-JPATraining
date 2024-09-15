package com.taskbot.vs.models.advanced;

import com.taskbot.vs.models.simple.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;

public class LazyProperties {
    public void findItemById(String id) {
        try(EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HelloWorldPU")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Item item = entityManager.find(Item.class, id);

            InputStream imageDataStream = item.getImage().getBinaryStream();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            imageDataStream.transferTo(outputStream);

            byte[] imageBytes = outputStream.toByteArray();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveImage(InputStream imageInputStream, long bytesLength) {
        try(EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HelloWorldPU")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Session session = entityManager.unwrap(Session.class);
            Blob blob = session.getLobHelper().createBlob(imageInputStream, bytesLength);

            Item item = new Item();

            item.setImage(blob);
            entityManager.persist(item);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
