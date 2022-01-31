package sofka.app.entities;

import javax.persistence.*;

@Table(name = "CLIENTES")
@Entity
public class Cliente {
    @Id

    @Column(name = "ID_CLIENTE", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "DIRECCION", nullable = false, length = 50)
    private String direccion;

    @Column(name = "TELEFONO", nullable = false, length = 50)
    private String telefono;

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
}