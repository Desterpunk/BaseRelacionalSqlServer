package sofka.app.entities;

import javax.persistence.*;

@Table(name = "PRODUCTOS")
@Entity
public class Producto {
    @Id
    @Column(name = "ID_PRODUCTO", nullable = false)
    private Integer id;

    @Column(name = "DESCRIPCION", length = 50)
    private String descripcion;

    @Column(name = "PRECIO")
    private Integer precio;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private Categoria idCategoria;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_PROVEEDOR", nullable = false)
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