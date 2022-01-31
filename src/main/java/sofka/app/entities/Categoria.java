package sofka.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "CATEGORIAS")
@Entity
public class Categoria {
    @Id
    @Column(name = "ID_CATEGORIA", nullable = false, length = 50)
    private String id;

    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}