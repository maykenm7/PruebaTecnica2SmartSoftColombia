package com.smartsoft.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long id;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id_producto", foreignKey = @ForeignKey(name = "fk_detalle_producto"))
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "factura_id", referencedColumnName = "id_factura", foreignKey = @ForeignKey(name = "fk_detalle_producto"))
    private Factura factura;
}
