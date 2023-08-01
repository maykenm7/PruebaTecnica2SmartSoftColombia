package com.smartsoft.tienda.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smartsoft.tienda.model.Factura;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private String telefono;
    private String email;
}
