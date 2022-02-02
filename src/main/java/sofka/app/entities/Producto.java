package sofka.app.entities;

import sofka.app.entities.Categoria;
import sofka.app.entities.Proveedore;

import javax.persistence.*;
import java.util.List;

@Table(name = "PRODUCTOS")
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PRODUCTO", nullable = false)
    private Integer id;

    @Column(name = "DESCRIPCION", length = 50)
    private String descripcion;

    @Column(name = "PRECIO")
    private Integer precio;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private Categoria idCategoria;

    @ManyToOne
    @JoinColumn(name = "ID_PROVEEDOR")
    private Proveedore idProveedor;

    public Proveedore getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedore idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}