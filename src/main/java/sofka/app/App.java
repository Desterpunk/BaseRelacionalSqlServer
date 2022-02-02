package sofka.app;

import sofka.app.entities.*;
import sofka.app.services.CategoriaService;
import sofka.app.services.ClientService;
import sofka.app.services.ProductService;
import sofka.app.services.ProveedoresService;

import javax.xml.transform.Source;
import java.util.List;


public class App {
    public static void main(String[] args) {

        crudClient();
        crudProveedor();
        crudCategoria();
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

    private static void crudProveedor() {
        ProveedoresService proveedoresService = new ProveedoresService();
        proveedoresService.startEntityTransaction();

        System.out.println("------------- Create Provider-------------");
        Proveedore proveedor = new Proveedore();
        proveedor.setNombre("jhon");
        proveedor.setDireccion("medellin");
        proveedor.setTelefono("32133912620");
        Proveedore saved = proveedoresService.saveProveedor(proveedor);
        System.out.println(saved.getId() + " " + saved.getNombre());

        System.out.println("------------- Find Provider By Id -------------");
        Proveedore findCliente = proveedoresService.findProveedorById(1);
        System.out.println(findCliente.getId());
        System.out.println(findCliente.getNombre());
        System.out.println(findCliente.getDireccion());
        System.out.println(findCliente.getTelefono());

        System.out.println("------------- find All Providers -------------");
        List<Proveedore> proveedores =  proveedoresService.findALlProveedores();
        for (Proveedore p: proveedores){
            System.out.println("Id Proveedor: " + p.getId());
            System.out.println("Nombre Proveedor: " + p.getNombre());
            System.out.println("Direccion Proveedor: " + p.getDireccion());
            System.out.println("Telefono Proveedor: " + p.getTelefono());
            System.out.println("Productos: ");
            if (p.getIdProducto() != null){
                for (Producto pro: p.getIdProducto()){
                    System.out.println("Id Producto: " + pro.getId());
                    System.out.println("Descripcion Producto: " + pro.getDescripcion());
                    System.out.println("Precio Producto: " + pro.getPrecio());
                }
            }
        }

        System.out.println("------------- Update Provider -------------");
        Proveedore updateProvider = new Proveedore();
        updateProvider.setId(1);
        updateProvider.setNombre("Paco");
        updateProvider.setDireccion("medellin");
        updateProvider.setTelefono("32133912620");
        Proveedore result = proveedoresService.updateProveedor(updateProvider);
        System.out.println(result.getNombre());

        System.out.println("------------- Delete Cliente -------------");
        proveedoresService.deleteProveedor(saved.getId());
        System.out.println(saved.getId() + " deleted");

        proveedoresService.commitEntityTransaction();
        proveedoresService.closeEntityTransaction();
    }

    private static void crudCategoria() {
        CategoriaService categoriaService = new CategoriaService();
        categoriaService.startEntityTransaction();

        System.out.println("------------- Create Category-------------");
        Categoria categoria = new Categoria();
        categoria.setDescripcion("Juegos");
        Categoria saved = categoriaService.saveCategory(categoria);
        System.out.println(saved.getId() + " " + saved.getDescripcion());

        System.out.println("------------- Find Category By Id -------------");
        Categoria findCategory = categoriaService.findCategoryById(1);
        System.out.println(findCategory.getId());
        System.out.println(findCategory.getDescripcion());

        System.out.println("------------- find All Categories -------------");
        List<Categoria> categorias =  categoriaService.findALlCategories();
        for (Categoria c: categorias){
            System.out.println("Id Categoria: " + c.getId());
            System.out.println("Descripcion Categoria: " + c.getDescripcion());
            System.out.println("Productos: ");
            if (c.getIdProducto() != null){
                for (Producto pro: c.getIdProducto()){
                    System.out.println("Id Producto: " + pro.getId());
                    System.out.println("Descripcion Producto: " + pro.getDescripcion());
                    System.out.println("Precio Producto: " + pro.getPrecio());
                }
            }
        }

        System.out.println("------------- Update Category -------------");
        Categoria updateCategory = new Categoria();
        updateCategory.setId(1);
        updateCategory.setDescripcion("Aseo");
        Categoria result = categoriaService.updateCategory(updateCategory);
        System.out.println(result.getDescripcion());

        System.out.println("------------- Delete Category -------------");
        categoriaService.deleteCategory(saved.getId());
        System.out.println(saved.getId() + " deleted");

        categoriaService.commitEntityTransaction();
        categoriaService.closeEntityTransaction();
    }

//    private static void crudProducto() {
//        ProductService productService = new ProductService();
//        productService.startEntityTransaction();
//
//        System.out.println("------------- Create Product-------------");
//        Producto producto = new Producto();
//        producto.setDescripcion("gameplay");
//        producto.setPrecio(5000);
//        Producto saved = productService.saveProducto(producto);
//        System.out.println(saved.getId() + " " + saved.getDescripcion());
//
//        System.out.println("------------- Find Product By Id -------------");
//        Producto findProduct = productService.findProductoById(1);
//        System.out.println(findProduct.getId());
//        System.out.println(findProduct.getDescripcion());
//        System.out.println(findProduct.getIdCategoria());
//        System.out.println(findProduct.getIdProveedor());
//
//        System.out.println("------------- find All Products -------------");
//        List<Producto> productos =  productService.findALlProductos();
//        for (Producto p: productos){
//            System.out.println("Id Producto: " + p.getId());
//            System.out.println("Descripcion Producto: " + p.getDescripcion());
//            System.out.println("Precio Producto: " + p.getPrecio());
//            System.out.println("Categoria: ");
//            if (p.getIdCategoria() != null){
//                    System.out.println("Id Categoria: " + p.getIdCategoria().getId());
//                    System.out.println("Descripcion Categoria: " + p.getIdCategoria().getDescripcion());
//            }
//        }
//
//        System.out.println("------------- Update Product -------------");
//        Producto updateProduct = new Producto();
//        updateProduct.setId(1);
//        updateProduct.setDescripcion("gameplay");
//        updateProduct.setPrecio(5000);
//        Producto resultProduct = productService.updateProducto(updateProduct);
//        System.out.println(resultProduct.getDescripcion());
//
//        System.out.println("------------- Delete Cliente -------------");
//        productService.deleteProducto(saved.getId());
//        System.out.println(saved.getId() + " deleted");
//
//        productService.commitEntityTransaction();
//        productService.closeEntityTransaction();
//    }
}
