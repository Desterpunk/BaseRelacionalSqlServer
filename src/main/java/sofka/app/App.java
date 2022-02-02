package sofka.app;

import sofka.app.entities.Cliente;
import sofka.app.entities.Factura;
import sofka.app.entities.Producto;
import sofka.app.services.ClientService;
import sofka.app.services.ProductService;

import javax.xml.transform.Source;
import java.util.List;


public class App {
    public static void main(String[] args) {

        crudClient();
    }

    private static void crudClient() {
        ClientService clientService = new ClientService();
        clientService.startEntityTransaction();

        System.out.println("------------- Create Cliente-------------");
        Cliente cliente = new Cliente();
        cliente.setNombre("jhon");
        cliente.setDireccion("medellin");
        cliente.setTelefono("32133912620");
        Cliente saved = clientService.saveClient(cliente);
        System.out.println(saved.getId() + " " + saved.getNombre());

        System.out.println("------------- Find Cliente By Id -------------");
        Cliente findCliente = clientService.findClienteById(1);
        System.out.println(findCliente.getId());
        System.out.println(findCliente.getNombre());
        System.out.println(findCliente.getDireccion());
        System.out.println(findCliente.getTelefono());

        System.out.println("------------- find All Clientes -------------");
        List<Cliente> clientes =  clientService.findALlClientes();
        for (Cliente c: clientes){
            System.out.println("Id Cliente: " + c.getId());
            System.out.println("Nombre Cliente: " + c.getNombre());
            System.out.println("Direccion Cliente: " + c.getDireccion());
            System.out.println("Telefono Cliente: " + c.getTelefono());
            System.out.println("Facturas: ");
            if (c.getIdFactura() != null){
                for (Factura f: c.getIdFactura()){
                    System.out.println("Id Factura: " + f.getId());
                    System.out.println("Fecha Factura: " + f.getFecha());
                    System.out.println("Id Cliente " + f.getIdCliente());
                }
            }
        }

        System.out.println("------------- Update Cliente -------------");
        Cliente updateCliente = new Cliente();
        updateCliente.setId(1);
        updateCliente.setNombre("Paco");
        updateCliente.setDireccion("medellin");
        updateCliente.setTelefono("32133912620");
        Cliente result = clientService.updateCliente(updateCliente);
        System.out.println(result.getNombre());

        System.out.println("------------- Delete Cliente -------------");
        clientService.deleteCliente(saved.getId());
        System.out.println(saved.getId() + " deleted");

        clientService.commitEntityTransaction();
        clientService.closeEntityTransaction();
    }

//    private static void crudProducto() {
//        ProductService productService = new ProductService();
//        productService.startEntityTransaction();
//
//        System.out.println("------------- Create Product-------------");
//        Producto producto = new Producto();
//        producto.setDescripcion("gameplay");
//        producto.setPrecio(5000);
//        producto.setIdCategoria(1);
//        Cliente saved = clientService.saveClient(cliente);
//        System.out.println(saved.getId() + " " + saved.getNombre());
//
//        System.out.println("------------- Find Cliente By Id -------------");
//        Cliente findCliente = clientService.findClienteById(1);
//        System.out.println(findCliente.getId());
//        System.out.println(findCliente.getNombre());
//        System.out.println(findCliente.getDireccion());
//        System.out.println(findCliente.getTelefono());
//
//        System.out.println("------------- find All Clientes -------------");
//        List<Cliente> clientes =  clientService.findALlClientes();
//        for (Cliente c: clientes){
//            System.out.println("Id Cliente: " + c.getId());
//            System.out.println("Nombre Cliente: " + c.getNombre());
//            System.out.println("Direccion Cliente: " + c.getDireccion());
//            System.out.println("Telefono Cliente: " + c.getTelefono());
//            System.out.println("Facturas: ");
//            if (c.getIdFactura() != null){
//                for (Factura f: c.getIdFactura()){
//                    System.out.println("Id Factura: " + f.getId());
//                    System.out.println("Fecha Factura: " + f.getFecha());
//                    System.out.println("Id Cliente " + f.getIdCliente());
//                }
//            }
//        }
//
//        System.out.println("------------- Update Cliente -------------");
//        Cliente updateCliente = new Cliente();
//        updateCliente.setId(1);
//        updateCliente.setNombre("Paco");
//        updateCliente.setDireccion("medellin");
//        updateCliente.setTelefono("32133912620");
//        Cliente result = clientService.updateCliente(updateCliente);
//        System.out.println(result.getNombre());
//
//        System.out.println("------------- Delete Cliente -------------");
//        clientService.deleteCliente(saved.getId());
//        System.out.println(saved.getId() + " deleted");
//
//        clientService.commitEntityTransaction();
//        clientService.closeEntityTransaction();
//    }
}
