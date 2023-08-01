package com.smartsoft.tienda.service;

import com.smartsoft.tienda.dto.FacturaDto;

public interface ServiceFactura {
    Long guardarFactura(FacturaDto facturaDto);
    FacturaDto obtenerFactura(Long id_factura);
    
}
