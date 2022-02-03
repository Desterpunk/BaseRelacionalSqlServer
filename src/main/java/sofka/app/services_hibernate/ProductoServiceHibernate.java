package sofka.app.services_hibernate;

import org.hibernate.Session;
import sofka.app.entities.Producto;
import sofka.app.entities.Proveedore;
import sofka.app.utils.HibernateUtil;

import java.util.List;

public class ProductoServiceHibernate {

    private Session session;

    public ProductoServiceHibernate() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        session = HibernateUtil.getCurrentSession();
    }

    public Producto saveProoducto(Producto producto) {
        session.persist(producto);
        session.beginTransaction().commit();
        return producto;
    }

    public Producto findProductoById(Integer id) {
        Producto producto = session.find(Producto.class, id);
        session.beginTransaction().commit();
        return producto;
    }

    public Producto updateProducto(Producto producto) {
        session.beginTransaction();
        Producto findedProducto = session.find(Producto.class, producto.getId());
        findedProducto.setDescripcion(producto.getDescripcion());
        findedProducto.setPrecio(producto.getPrecio());
        findedProducto.setIdCategoria(producto.getIdCategoria());
        findedProducto.setIdProveedor(producto.getIdProveedor());
        session.getTransaction().commit();
        return findedProducto;
    }

    public List<Producto> findAllProductos() {
        List<Producto> productos = this.session.createQuery("from Producto").list();
        session.beginTransaction().commit();
        return productos;
    }

    public void deleteProducto(Integer id) {
        session.beginTransaction();
        Producto findProducto= session.find(Producto.class, id);
        session.remove(findProducto);
        session.getTransaction().commit();
    }
    public void commitEntityTransaction() {
        session.getTransaction().commit();
    }
}
