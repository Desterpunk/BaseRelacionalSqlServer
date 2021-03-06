package sofka.app.entities;

import sofka.app.entities.Cliente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "FACTURAS")
@Entity
public class Factura {
    @Id

    @Column(name = "ID_FACTURA", nullable = false, length = 50)
    private Integer id;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente idCliente;

    @OneToMany( mappedBy = "idFactura",cascade = CascadeType.ALL)
    private List<Venta> ventas;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

}