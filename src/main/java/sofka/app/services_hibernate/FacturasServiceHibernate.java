package sofka.app.services_hibernate;

import org.hibernate.Session;
import sofka.app.entities.Factura;
import sofka.app.entities.Proveedore;
import sofka.app.utils.HibernateUtil;

import java.util.List;

public class FacturasServiceHibernate {

    private Session session;

    public FacturasServiceHibernate() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        session = HibernateUtil.getCurrentSession();
    }

    public Factura saveFacura(Factura factura) {
        session.persist(factura);
        session.beginTransaction().commit();
        return factura;
    }

    public Factura findFacturaById(Integer id) {
        Factura factura = session.find(Factura.class, id);
        session.beginTransaction().commit();
        return factura;
    }

    public Factura updateFactura(Factura factura) {
        session.beginTransaction();
        Factura findedFactura = session.find(Factura.class, factura.getId());
        findedFactura.setFecha(factura.getFecha());
        findedFactura.setIdCliente(factura.getIdCliente());
        session.getTransaction().commit();
        return findedFactura;
    }

    public List<Factura> findAllFacturas() {
        List<Factura> facturas = this.session.createQuery("from Factura").list();
        session.beginTransaction().commit();
        return facturas;
    }

    public void deleteFactura(Integer id) {
        session.beginTransaction();
        Factura findFactura= session.find(Factura.class, id);
        session.remove(findFactura);
        session.getTransaction().commit();
    }
    public void commitEntityTransaction() {
        session.getTransaction().commit();
    }
}