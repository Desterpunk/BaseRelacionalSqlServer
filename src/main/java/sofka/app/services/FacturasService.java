package sofka.app.services;

import sofka.app.entities.Cliente;
import sofka.app.entities.Factura;

import javax.persistence.*;
import java.util.List;

public class FacturasService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public FacturasService () {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("clientPersistence");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityTransaction = entityManager.getTransaction();
    }

    public Factura saveBill(Factura factura) {
        entityManager.persist(factura);
        return factura;
    }

    public Factura findBillById(Integer id) {
        Factura factura = entityManager.find(Factura.class, id);
        return factura;
    }

    public Factura updateBill(Factura factura) {
        Factura findedFactura = entityManager.find(Factura.class, factura.getId());
        findedFactura.setFecha(factura.getFecha());
        findedFactura.setIdCliente(factura.getIdCliente());
        return findedFactura;
    }

    public List<Factura> findALlBills() {
        Query queryCliente = entityManager.createQuery("FROM Factura");
        List<Factura> facturas=(List<Factura>)queryCliente.getResultList();
        return facturas;
    }

    public void deleteBill(Integer id) {
        Factura findedBill = entityManager.find(Factura.class, id);
        entityManager.remove(findedBill);
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
