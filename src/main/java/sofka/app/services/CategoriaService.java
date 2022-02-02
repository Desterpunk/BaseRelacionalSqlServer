package sofka.app.services;

import sofka.app.entities.Categoria;
import sofka.app.entities.Cliente;

import javax.persistence.*;
import java.util.List;

public class CategoriaService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public CategoriaService () {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("clientPersistence");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityTransaction = entityManager.getTransaction();
    }

    public Categoria saveCategory(Categoria categoria) {
        entityManager.persist(categoria);
        return categoria;
    }

    public Categoria findCategoryById(Integer id) {
        Categoria categoria = entityManager.find(Categoria.class, id);
        return categoria;
    }

    public Categoria updateCategory(Categoria categoria) {
        Categoria findedCategoria = entityManager.find(Categoria.class, categoria.getId());
        findedCategoria.setDescripcion(categoria.getDescripcion());

        return findedCategoria;
    }

    public List<Categoria> findALlCategories() {
        Query queryCliente = entityManager.createQuery("FROM Categoria");
        List<Categoria> categorias=(List<Categoria>)queryCliente.getResultList();
        return categorias;
    }

    public void deleteCategory(Integer id) {
        Categoria findCategory = entityManager.find(Categoria.class, id);
        entityManager.remove(findCategory);
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
