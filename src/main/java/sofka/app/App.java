package sofka.app;

import sofka.app.entities.*;
import sofka.app.services.*;

import java.time.LocalDate;
import java.util.List;


public class App {
    public static void main(String[] args) {

        crudClient();
        crudProveedor();
        crudCategoria();
        crudFacturas();
        crudProducto();
        crudVentas();
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
            if (c.getFacturas() != null){
                for (Factura f: c.getFacturas()){
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
            if (p.getProductos() != null){
                for (Producto pro: p.getProductos()){
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
            if (c.getProductos() != null){
                for (Producto pro: c.getProductos()){
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

    private static void crudFacturas() {
        FacturasService facturasService = new FacturasService();
        facturasService.startEntityTransaction();
        ClientService clientService = new ClientService();
        clientService.startEntityTransaction();

        System.out.println("------------- Create Bill-------------");
        Factura factura = new Factura();
        factura.setFecha(LocalDate.now());
        factura.setIdCliente(clientService.findClienteById(1));
        Factura saved = facturasService.saveBill(factura);
        System.out.println(saved.getId() + " " + saved.getFecha());

        System.out.println("------------- Find Bill By Id -------------");
        Factura findCategory = facturasService.findBillById(1);
        System.out.println(findCategory.getId());
        System.out.println(findCategory.getFecha());

        System.out.println("------------- find All Bills -------------");
        List<Factura> facturas =  facturasService.findALlBills();
        for (Factura f: facturas){
            System.out.println("Id Factura: " + f.getId());
            System.out.println("Fecha Factura" + f.getFecha());
            System.out.println("Cliente: ");
            System.out.println("Id Cliente: " + f.getIdCliente().getId());
            System.out.println("Nombre Cliente: " + f.getIdCliente().getNombre());
            System.out.println("Direccion Cliente: " + f.getIdCliente().getDireccion());
            System.out.println("Telefono Cliente: " + f.getIdCliente().getTelefono());
            System.out.println("Ventas: ");
            if (f.getVentas() != null){
                for (Venta v: f.getVentas()){
                    System.out.println("Id Venta: " + v.getId());
                    System.out.println("Id Factura: " + v.getIdFactura());
                    System.out.println("Id Producto: " + v.getIdProducto());
                    System.out.println("Cantidad: " + v.getCantidad());
                }
            }
        }

        System.out.println("------------- Update Bill -------------");
        Factura updateBill = new Factura();
        updateBill.setId(1);
        updateBill.setFecha(LocalDate.now());
        updateBill.setIdCliente(clientService.findClienteById(1));
        Factura result = facturasService.updateBill(updateBill);
        System.out.println(result.getId());

        System.out.println("------------- Delete Category -------------");
        facturasService.deleteBill(saved.getId());
        System.out.println(saved.getId() + " deleted");

        facturasService.commitEntityTransaction();
        facturasService.closeEntityTransaction();
        clientService.commitEntityTransaction();
        clientService.closeEntityTransaction();
    }

    private static void crudProducto() {
        ProductService productService = new ProductService();
        productService.startEntityTransaction();
        CategoriaService categoriaService = new CategoriaService();
        categoriaService.startEntityTransaction();
        ProveedoresService proveedoresService = new ProveedoresService();
        proveedoresService.startEntityTransaction();

        System.out.println("------------- Create Product-------------");
        Producto producto = new Producto();
        producto.setDescripcion("gameplay");
        producto.setPrecio(5000);
        producto.setIdCategoria(categoriaService.findCategoryById(1));
        producto.setIdProveedor(proveedoresService.findProveedorById(1));
        Producto saved = productService.saveProducto(producto);
        System.out.println(saved.getId() + " " + saved.getDescripcion());

        System.out.println("------------- Find Product By Id -------------");
        Producto findProduct = productService.findProductoById(1);
        System.out.println(findProduct.getId());
        System.out.println(findProduct.getDescripcion());
        System.out.println(findProduct.getIdCategoria());
        System.out.println(findProduct.getIdProveedor());

        System.out.println("------------- find All Products -------------");
        List<Producto> productos =  productService.findALlProductos();
        for (Producto p: productos){
            System.out.println("Id Producto: " + p.getId());
            System.out.println("Descripcion Producto: " + p.getDescripcion());
            System.out.println("Precio Producto: " + p.getPrecio());
            System.out.println("Categoria: ");
            if (p.getIdCategoria() != null){
                    System.out.println("Id Categoria: " + p.getIdCategoria().getId());
                    System.out.println("Descripcion Categoria: " + p.getIdCategoria().getDescripcion());
            }
            System.out.println("Ventas: ");
            if (p.getVentas() != null){
                for (Venta v: p.getVentas()){
                    System.out.println("Id Venta: " + v.getId());
                    System.out.println("Id Factura: " + v.getIdFactura());
                    System.out.println("Id Producto: " + v.getIdProducto());
                    System.out.println("Cantidad: " + v.getCantidad());
                }
            }
        }

        System.out.println("------------- Update Product -------------");
        Producto updateProduct = new Producto();
        updateProduct.setId(1);
        updateProduct.setDescripcion("gameplay");
        updateProduct.setPrecio(5000);
        updateProduct.setIdCategoria(categoriaService.findCategoryById(2));
        updateProduct.setIdProveedor(proveedoresService.findProveedorById(2));

        Producto resultProduct = productService.updateProducto(updateProduct);
        System.out.println(resultProduct.getDescripcion());

        System.out.println("------------- Delete Cliente -------------");
        productService.deleteProducto(saved.getId());
        System.out.println(saved.getId() + " deleted");

        productService.commitEntityTransaction();
        productService.closeEntityTransaction();
        categoriaService.commitEntityTransaction();
        categoriaService.closeEntityTransaction();
        proveedoresService.commitEntityTransaction();
        proveedoresService.closeEntityTransaction();
    }

    private static void crudVentas() {
        VentasService ventasService = new VentasService();
        ventasService.startEntityTransaction();
        FacturasService facturasService = new FacturasService();
        facturasService.startEntityTransaction();
        ProductService productService = new ProductService();
        productService.startEntityTransaction();

        System.out.println("------------- Create Sell-------------");
        Venta venta = new Venta();
        venta.setIdFactura(facturasService.findBillById(1));
        venta.setIdProducto(productService.findProductoById(1));
        venta.setCantidad(10);
        Venta saved = ventasService.saveSell(venta);
        System.out.println(saved.getId() + " " + saved.getCantidad());

        System.out.println("------------- Find Sell By Id -------------");
        Venta findCategory = ventasService.findSellById(1);
        System.out.println(findCategory.getId());
        System.out.println(findCategory.getCantidad());

        System.out.println("------------- find All Sells -------------");
        List<Venta> ventas =  ventasService.findALlSells();
        for (Venta v: ventas){
            System.out.println("Id Venta: " + v.getId());
            System.out.println("Factura Ventas: ");
            if (v.getIdFactura() != null){
                System.out.println("Id Factura: " + v.getIdFactura().getId());
                System.out.println("Fecha Factura" + v.getIdFactura().getFecha());
                System.out.println("Cliente: " + v.getIdFactura().getIdCliente());
            }
            System.out.println("Producto: ");
            if (v.getIdProducto() != null){
                System.out.println("Id Producto: " + v.getIdProducto() .getId());
                System.out.println("Descripcion Producto: " + v.getIdProducto() .getDescripcion());
                System.out.println("Precio Producto: " + v.getIdProducto() .getPrecio());
            }
            System.out.println("Cantidad Ventas: " + v.getCantidad());
        }

        System.out.println("------------- Update Sell -------------");
        Venta updateSell = new Venta();
        updateSell.setId(1);
        updateSell.setIdFactura(facturasService.findBillById(1));
        updateSell.setIdProducto(productService.findProductoById(1));
        updateSell.setCantidad(200);
        Venta result = ventasService.updateSell(updateSell);
        System.out.println(result.getId());

        System.out.println("------------- Delete Sell -------------");
        ventasService.deleteSell(saved.getId());
        System.out.println(saved.getId() + " deleted");

        ventasService.commitEntityTransaction();
        ventasService.closeEntityTransaction();
        facturasService.commitEntityTransaction();
        facturasService.closeEntityTransaction();
        productService.commitEntityTransaction();
        productService.closeEntityTransaction();

    }
}
