package sofka.app.services_hibernate;

import org.hibernate.Session;
import sofka.app.entities.Categoria;
import sofka.app.utils.HibernateUtil;

import java.util.List;

public class CategoriaServiceHibernate {

    private Session session;

    public CategoriaServiceHibernate() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        session = HibernateUtil.getCurrentSession();
    }

    public Categoria saveCategoria(Categoria categoria) {
        session.persist(categoria);
        session.beginTransaction().commit();
        return categoria;
    }

    public Categoria findCategoriaById(Integer id) {
        Categoria categoria = session.find(Categoria.class, id);
        session.beginTransaction().commit();
        return categoria;
    }

    public Categoria updateCategoria(Categoria categoria) {
        session.beginTransaction();
        Categoria findedCategoria = session.find(Categoria.class, categoria.getId());
        findedCategoria.setDescripcion(categoria.getDescripcion());;
        session.getTransaction().commit();
        return findedCategoria;
    }

    public List<Categoria> findAllClients() {
        List<Categoria> categorias = this.session.createQuery("from Categoria").list();
        session.beginTransaction().commit();
        return categorias;
    }

    public void deleteCategoria(Integer id) {
        session.beginTransaction();
        Categoria findCategoria= session.find(Categoria.class, id);
        session.remove(findCategoria);
        session.getTransaction().commit();
    }
    public void commitEntityTransaction() {
        session.getTransaction().commit();
    }
}
