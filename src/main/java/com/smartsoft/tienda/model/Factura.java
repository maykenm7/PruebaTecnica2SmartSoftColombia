package com.smartsoft.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long id;
    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente", foreignKey = @ForeignKey(name = "fk_factura_cliente"))
    private Cliente cliente;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "factura")
    private List<Detalle> detalles;

    public void setAllJoins() {
        if (detalles != null) {
            detalles.forEach(d -> {
                d.setFactura(this);
            });
        }
    }
}
