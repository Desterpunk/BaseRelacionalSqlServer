package sofka.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PROVEEDORES")
@Entity
public class Proveedore {
    @Id
    @Column(name = "ID_PROVEEDOR", nullable = false, length = 50)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}