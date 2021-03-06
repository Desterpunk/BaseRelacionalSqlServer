package sofka.app.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "CATEGORIAS")
@Entity
public class Categoria {
    @Id

    @Column(name = "ID_CATEGORIA", nullable = false, length = 50)
    private Integer id;

    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;

    @OneToMany( mappedBy = "idCategoria",cascade = CascadeType.ALL)
    private List<Producto> productos;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer    id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}