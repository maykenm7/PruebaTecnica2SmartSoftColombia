package com.smartsoft.tienda.service;

import com.smartsoft.tienda.dto.ProductoDto;

public interface ServiceProducto {
    Long guardarProducto(ProductoDto productoDto);
    ProductoDto obtenerProducto(Long id_producto);
    
}
