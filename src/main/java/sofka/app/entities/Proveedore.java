package sofka.app.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "PROVEEDORES")
@Entity
public class Proveedore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PROVEEDOR", nullable = false, length = 50)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "DIRECCION", nullable = false, length = 50)
    private String direccion;

    @Column(name = "TELEFONO", nullable = false, length = 50)
    private String telefono;

    @OneToMany( mappedBy = "idProveedor",cascade = CascadeType.ALL)
    private List<Producto> productos;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}