package com.smartsoft.tienda.service;

import com.smartsoft.tienda.dto.ClienteDto;
import com.smartsoft.tienda.model.Cliente;

public interface ServiceCliente {
    Long guardarCliente(ClienteDto clienteDto);
    ClienteDto obtenerCliente(Long id_cliente);
}
