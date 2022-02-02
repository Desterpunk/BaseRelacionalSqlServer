package sofka.app.services;

import sofka.app.entities.Factura;
import sofka.app.entities.Venta;

import javax.persistence.*;
import java.util.List;

public class VentasService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public VentasService () {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("clientPersistence");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityTransaction = entityManager.getTransaction();
    }

    public Venta saveSell(Venta venta) {
        entityManager.persist(venta);
        return venta;
    }

    public Venta findSellById(Integer id) {
        Venta venta = entityManager.find(Venta.class, id);
        return venta;
    }

    public Venta updateSell(Venta venta) {
        Venta findedSell = entityManager.find(Venta.class, venta.getId());
        findedSell.setIdFactura(venta.getIdFactura());
        findedSell.setIdProducto(venta.getIdProducto());
        findedSell.setCantidad(venta.getCantidad());
        return findedSell;
    }

    public List<Venta> findALlSells() {
        Query query = entityManager.createQuery("FROM Venta");
        List<Venta> ventas=(List<Venta>)query.getResultList();
        return ventas;
    }

    public void deleteSell(Integer id) {
        Venta findedSell = entityManager.find(Venta.class, id);
        entityManager.remove(findedSell);
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
