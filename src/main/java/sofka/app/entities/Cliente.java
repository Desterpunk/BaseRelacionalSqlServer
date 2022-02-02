package sofka.app.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "CLIENTES")
@Entity
@NamedQueries({
        @NamedQuery(name = "Cliente.findById", query = "Select c from Cliente c where c.id = :id"),
        @NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c"),
        @NamedQuery(name="Cliente.findByName", query="SELECT c FROM Cliente c WHERE c.nombre = :nombre")
})
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

    @OneToMany( mappedBy = "idCliente",cascade = CascadeType.ALL)
    private List<Factura> facturas;

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

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
}