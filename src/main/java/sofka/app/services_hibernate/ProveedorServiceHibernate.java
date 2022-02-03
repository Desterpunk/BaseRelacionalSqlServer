package sofka.app.services_hibernate;

import org.hibernate.Session;
import sofka.app.entities.Categoria;
import sofka.app.entities.Proveedore;
import sofka.app.utils.HibernateUtil;

import java.util.List;

public class ProveedorServiceHibernate {

    private Session session;

    public ProveedorServiceHibernate() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        session = HibernateUtil.getCurrentSession();
    }

    public Proveedore saveProveedor(Proveedore proveedore) {
        session.persist(proveedore);
        session.beginTransaction().commit();
        return proveedore;
    }

    public Proveedore findProveedorById(Integer id) {
        Proveedore proveedore = session.find(Proveedore.class, id);
        session.beginTransaction().commit();
        return proveedore;
    }

    public Proveedore updateProveedor(Proveedore proveedore) {
        session.beginTransaction();
        Proveedore findedProveedor = session.find(Proveedore.class, proveedore.getId());
        findedProveedor.setNombre(proveedore.getNombre());
        findedProveedor.setTelefono(proveedore.getTelefono());
        findedProveedor.setDireccion(proveedore.getDireccion());
        session.getTransaction().commit();
        return findedProveedor;
    }

    public List<Proveedore> findAllProveedores() {
        List<Proveedore> proveedores = this.session.createQuery("from Proveedore").list();
        session.beginTransaction().commit();
        return proveedores;
    }

    public void deleteProveedor(Integer id) {
        session.beginTransaction();
        Proveedore findProveedore= session.find(Proveedore.class, id);
        session.remove(findProveedore);
        session.getTransaction().commit();
    }
    public void commitEntityTransaction() {
        session.getTransaction().commit();
    }
}
