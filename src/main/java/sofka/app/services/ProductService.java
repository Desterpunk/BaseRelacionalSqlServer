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

    public Producto saveProducto(Producto producto) {
        entityManager.persist(producto);
        return producto;
    }

    public Producto findProductoById(Integer id) {
        Producto producto = entityManager.find(Producto.class, id);
        return producto;
    }

    public Producto updateProducto(Producto producto) {
        Producto findedProducto = entityManager.find(Producto.class, producto.getId());
        findedProducto.setDescripcion(producto.getDescripcion());
        findedProducto.setPrecio(producto.getPrecio());
        findedProducto.setIdCategoria(producto.getIdCategoria());
        findedProducto.setIdProveedor(producto.getIdProveedor());
        return findedProducto;
    }

    public List<Producto> findALlProductos() {
        Query queryProducto = entityManager.createQuery("FROM Producto");
        List<Producto> productos=(List<Producto>)queryProducto.getResultList();
        return productos;
    }

    public void deleteProducto(Integer id) {
        Producto findProducto = entityManager.find(Producto.class, id);
        entityManager.remove(findProducto);
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