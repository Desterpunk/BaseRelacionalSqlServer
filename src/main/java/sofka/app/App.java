package sofka.app;

import sofka.app.entities.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("clientPersistence");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Cliente cliente = new Cliente();
        cliente.setId(8);
        cliente.setNombre("jhon");
        cliente.setDireccion("medellin");
        cliente.setTelefono("32133912620");
        em.persist(cliente);
        tx.commit();
        em.close();
    }
}
