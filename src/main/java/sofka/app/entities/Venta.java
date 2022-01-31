package sofka.app.entities;

import javax.persistence.*;

@Table(name = "VENTAS")
@Entity
public class Venta {
    @Id
    @Column(name = "ID_VENTA", nullable = false, length = 50)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_FACTURA", nullable = false)
    private Factura idFactura;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Producto idProducto;

    @Column(name = "CANTIDAD", nullable = false)
    private Long cantidad;

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}