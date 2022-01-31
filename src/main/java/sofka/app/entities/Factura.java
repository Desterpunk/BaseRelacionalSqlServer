package sofka.app.entities;

import sofka.app.entities.Cliente;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "FACTURAS")
@Entity
public class Factura {
    @Id
    @Column(name = "ID_FACTURA", nullable = false, length = 50)
    private String id;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente idCliente;

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}