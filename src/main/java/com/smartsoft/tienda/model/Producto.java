package com.smartsoft.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private double precio;
    @Column(nullable = false)
    private Integer stock;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Detalle> detalles;

    public void setAllJoins() {
        if (detalles != null) {
            detalles.forEach(d -> {
                d.setProducto(this);
            });
        }
    }
}
