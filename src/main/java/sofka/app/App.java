package sofka.app;

import sofka.app.entities.Cliente;
import sofka.app.entities.Producto;

import javax.persistence.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("clientPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Cliente cliente = new Cliente();
        cliente.setId(8);
        cliente.setNombre("jhon");
        cliente.setDireccion("medellin");
        cliente.setTelefono("32133912620");
//        entityManager.persist(cliente);

        System.out.println("------------- find By Id -------------");
        Cliente findCliente = entityManager.find(Cliente.class, 1);
        System.out.println(findCliente.getId());
        System.out.println(findCliente.getNombre());
        System.out.println(findCliente.getDireccion());
        System.out.println(findCliente.getTelefono());

        Cliente updateCliente = findCliente;
        updateCliente.setNombre("carlos");
        entityTransaction.commit();
        System.out.println("------------- Update -------------");
        System.out.println(findCliente.getId());
        System.out.println(findCliente.getNombre());
        System.out.println(findCliente.getDireccion());
        System.out.println(findCliente.getTelefono());

        entityTransaction.begin();
        Cliente deleteCLiente = entityManager.find(Cliente.class, 8);
//        entityManager.remove(deleteCLiente);
        entityTransaction.commit();

        System.out.println("------------- find All By Query -------------");

        Query queryCliente = entityManager.createQuery("SELECT C FROM Cliente C WHERE C.nombre LIKE 'Andres'");
        List<Cliente> clientes=(List<Cliente>)queryCliente.getResultList( );

        for (Cliente c: clientes){
            System.out.println("Cliente Id: " + c.getId());
            System.out.println("Cliente Nombre: " + c.getNombre());
        }

        Query queryProductos = entityManager.createQuery("SELECT P FROM Producto P WHERE  P.precio Between 500 and 1000");
        List<Producto> productos=(List<Producto>)queryProductos.getResultList( );

        for (Producto p: productos){
            System.out.println("Producto Id: " + p.getId());
            System.out.println("Producto Precio: " + p.getPrecio());
        }

        System.out.println("------------- find By Id  NamedQuery -------------");
        Query query = entityManager.createNamedQuery("Cliente.findById");
        query.setParameter("id", 1);
        List<Cliente> listfindById = query.getResultList( );
        for( Cliente c:listfindById )
        {
            System.out.print("ID Cliente: "+c.getId( ));
            System.out.println("\t Nombre Cliente: "+c.getNombre( ));
        }

        System.out.println("------------- find All NamedQuery -------------");
        Query query2 = entityManager.createNamedQuery("Cliente.findAll");
        List<Cliente> listfindAll = query2.getResultList( );
        for( Cliente c:listfindAll )
        {
            System.out.print("ID Cliente: "+c.getId( ));
            System.out.println("\t Nombre Cliente: "+c.getNombre( ));
        }

        System.out.println("------------- find By Name  NamedQuery -------------");
        Query query3 = entityManager.createNamedQuery("Cliente.findByName");
        query3.setParameter("nombre", "andres");
        List<Cliente> listfindByName = query3.getResultList( );
        for( Cliente c:listfindByName )
        {
            System.out.print("ID Cliente: "+c.getId( ));
            System.out.println("\t Nombre Cliente: "+c.getNombre( ));
        }
        entityManager.close();
    }
}
