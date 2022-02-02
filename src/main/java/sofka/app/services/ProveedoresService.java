package sofka.app.services;

import sofka.app.entities.Cliente;
import sofka.app.entities.Proveedore;

import javax.persistence.*;
import java.util.List;

public class ProveedoresService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public ProveedoresService () {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("clientPersistence");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityTransaction = entityManager.getTransaction();
    }

    public Proveedore saveProveedor(Proveedore proveedore) {
        entityManager.persist(proveedore);
        return proveedore;
    }

    public Proveedore findProveedorById(Integer id) {
        Proveedore proveedore = entityManager.find(Proveedore.class, id);
        return proveedore;
    }

    public Proveedore updateProveedor(Proveedore proveedore) {
        Proveedore findedProveedor = entityManager.find(Proveedore.class, proveedore.getId());
        findedProveedor.setNombre(proveedore.getNombre());
        findedProveedor.setTelefono(proveedore.getTelefono());
        findedProveedor.setDireccion(proveedore.getDireccion());
        return findedProveedor;
    }

    public List<Proveedore> findALlProveedores() {
        Query queryCliente = entityManager.createQuery("FROM Proveedore");
        List<Proveedore> proveedores=(List<Proveedore>)queryCliente.getResultList();
        return proveedores;
    }

    public void deleteProveedor(Integer id) {
        Proveedore findProveedor = entityManager.find(Proveedore.class, id);
        entityManager.remove(findProveedor);
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
