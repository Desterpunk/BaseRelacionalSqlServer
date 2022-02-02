package sofka.app.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "PROVEEDORES")
@Entity
public class Proveedore {
    @Id
    @Column(name = "ID_PROVEEDOR", nullable = false, length = 50)
    private String id;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "DIRECCION", nullable = false, length = 50)
    private String direccion;

    @Column(name = "TELEFONO", nullable = false, length = 50)
    private String telefono;

    @OneToMany( mappedBy = "idProveedor",cascade = CascadeType.ALL)
    private List<Producto> idProducto;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Producto> getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(List<Producto> idProducto) {
        this.idProducto = idProducto;
    }
}