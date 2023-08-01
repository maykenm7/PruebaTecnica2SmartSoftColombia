package com.smartsoft.tienda.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDto {
    private Long id;
    private Long clienteId;
    private LocalDate fecha;

    private List<DetalleDto> detalles;
}
