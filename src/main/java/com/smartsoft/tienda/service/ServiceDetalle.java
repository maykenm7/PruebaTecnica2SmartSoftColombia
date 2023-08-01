package com.smartsoft.tienda.service;

import com.smartsoft.tienda.dto.DetalleDto;

public interface ServiceDetalle {
    Long guardarDetalle(DetalleDto detalleDto);
    DetalleDto obtenerDetalle(Long id_detalle);
    
}
