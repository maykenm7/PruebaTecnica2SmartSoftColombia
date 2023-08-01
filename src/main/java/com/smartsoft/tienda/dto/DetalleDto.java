package com.smartsoft.tienda.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleDto {
    private Long id;
    private Long facturaId;
    private Long productoId;
    private Integer cantidad;
    private Double precio;
}
