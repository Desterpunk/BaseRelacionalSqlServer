package sofka.app.services_hibernate;

import org.hibernate.Session;
import sofka.app.entities.Proveedore;
import sofka.app.entities.Venta;
import sofka.app.utils.HibernateUtil;

import java.util.List;

public class VentasServiceHibernate {

    private Session session;

    public VentasServiceHibernate() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        session = HibernateUtil.getCurrentSession();
    }

    public Venta saveSell(Venta venta) {
        session.persist(venta);
        session.beginTransaction().commit();
        return venta;
    }

    public Venta findSellById(Integer id) {
        Venta venta = session.find(Venta.class, id);
        session.beginTransaction().commit();
        return venta;
    }

    public Venta updateSell(Venta venta) {
        session.beginTransaction();
        Venta findedVenta = session.find(Venta.class, venta.getId());
        findedVenta.setIdFactura(venta.getIdFactura());
        findedVenta.setIdProducto(venta.getIdProducto());
        findedVenta.setCantidad(venta.getCantidad());
        session.getTransaction().commit();
        return findedVenta;
    }

    public List<Venta> findALlSells() {
        List<Venta> ventas = this.session.createQuery("from Venta").list();
        session.beginTransaction().commit();
        return ventas;
    }

    public void deleteSell(Integer id) {
        session.beginTransaction();
        Venta findVenta= session.find(Venta.class, id);
        session.remove(findVenta);
        session.getTransaction().commit();
    }
    public void commitEntityTransaction() {
        session.getTransaction().commit();
    }
}
