package sofka.app.services_hibernate;

import org.hibernate.Session;
import sofka.app.entities.Cliente;
import sofka.app.utils.HibernateUtil;

import javax.persistence.*;
import java.util.List;

public class ClientServiceHibernate {

    private Session session;

    public ClientServiceHibernate() {
        HibernateUtil.buildSessionFactory();
        HibernateUtil.openSession();
        session = HibernateUtil.getCurrentSession();
    }

    public Cliente saveClient(Cliente cliente) {
        session.persist(cliente);
        session.beginTransaction().commit();
        return cliente;
    }

    public Cliente findClienteById(Integer id) {
        Cliente cliente = session.find(Cliente.class, id);
        session.beginTransaction().commit();
        return cliente;
    }

    public Cliente updateCliente(Cliente cliente) {
        Cliente findedCliente = session.find(Cliente.class, cliente.getId());
        findedCliente.setNombre(cliente.getNombre());
        findedCliente.setTelefono(cliente.getTelefono());
        findedCliente.setDireccion(cliente.getDireccion());
        return findedCliente;
    }

public List<Cliente> findAllClients() {
    List<Cliente> clientes = this.session.createQuery("from Cliente").list();
    session.beginTransaction().commit();
    return clientes;
}

    public void deleteCliente(Integer id) {
        session.beginTransaction();
        Cliente findCLiente = session.find(Cliente.class, id);
        session.remove(findCLiente);
        session.getTransaction().commit();
    }
    public void commitEntityTransaction() {
        session.getTransaction().commit();
    }
}