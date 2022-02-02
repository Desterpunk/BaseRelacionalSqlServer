package sofka.app.services;

import sofka.app.entities.Producto;

import javax.persistence.*;
import java.util.List;

public class ProductService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public ProductService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("clientPersistence");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityTransaction = entityManager.getTransaction();
    }

    public List<Producto> findAllProductos() {
        Query queryProducto = entityManager.createQuery("From Producto");
        List<Producto> productos=(List<Producto>)queryProducto.getResultList();
        return productos;
    }

    public void startEntityTransaction() {
        entityTransaction.begin();
    }
    public void closeEntityTransaction() {
        entityManager.close();
    }
    public void commitEntityTransaction() {
        entityTransaction.commit();
    }
}
