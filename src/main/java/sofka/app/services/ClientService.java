package sofka.app.services;

import sofka.app.entities.Cliente;
import sofka.app.entities.Producto;
import sofka.app.entities.Proveedore;

import javax.persistence.*;
import java.util.List;

public class ClientService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public ClientService () {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("clientPersistence");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityTransaction = entityManager.getTransaction();
    }

    public Cliente saveClient(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }

    public Cliente findClienteById(Integer id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        return cliente;
    }

    public Cliente updateCliente(Cliente cliente) {
        Cliente findedCliente = entityManager.find(Cliente.class, cliente.getId());
        findedCliente.setNombre(cliente.getNombre());
        findedCliente.setTelefono(cliente.getTelefono());
        findedCliente.setDireccion(cliente.getDireccion());
        return findedCliente;
    }

    public List<Cliente> findALlClientes() {
        Query queryCliente = entityManager.createQuery("FROM Cliente");
        List<Cliente> clientes=(List<Cliente>)queryCliente.getResultList();
        return clientes;
    }

    public void deleteCliente(Integer id) {
        Cliente findCLiente = entityManager.find(Cliente.class, id);
        entityManager.remove(findCLiente);
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
