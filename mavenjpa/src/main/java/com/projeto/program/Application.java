package com.projeto.program;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projeto.model.entity.Person;

public class Application {

    public static void main(String[] args) {
        
        Person p1 = new Person(null, "Vermelho", "vermelho@gmail.com");
        Person p2 = new Person(null, "Preto", "preto@gmail.com");
        Person p3 = new Person(null, "Branco", "branco@gmail.com");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Concluído");
    }
}