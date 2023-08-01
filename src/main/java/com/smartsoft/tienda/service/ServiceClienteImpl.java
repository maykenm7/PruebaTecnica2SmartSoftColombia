package com.smartsoft.tienda.service;

import com.smartsoft.tienda.dto.ClienteDto;
import com.smartsoft.tienda.dto.FacturaDto;
import com.smartsoft.tienda.model.Cliente;
import com.smartsoft.tienda.model.Factura;
import com.smartsoft.tienda.repository.RepositoryCliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceClienteImpl implements ServiceCliente{

    private final RepositoryCliente repositoryCliente;

    @Override
    public Long guardarCliente(ClienteDto clienteDto) {
        Cliente cliente = convertirClienteDtoACliente(clienteDto);
        repositoryCliente.save(cliente);
        return cliente.getId();
    }

    @Override
    public ClienteDto obtenerCliente(Long id) {
        Optional<Cliente> cliente = repositoryCliente.findById(id);
        if (cliente.isPresent()) {
            return convertirClienteAClienteDto(cliente.get());
        }
        throw new IllegalArgumentException("El cliente no existe");
    }

    private Cliente convertirClienteDtoACliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setDireccion(clienteDto.getDireccion());
        cliente.setFechaNacimiento(clienteDto.getFechaNacimiento());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setEmail(clienteDto.getEmail());
        return cliente;
    }

    private ClienteDto convertirClienteAClienteDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(cliente.getId());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setApellido(cliente.getApellido());
        clienteDto.setDireccion(cliente.getDireccion());
        clienteDto.setFechaNacimiento(cliente.getFechaNacimiento());
        clienteDto.setTelefono(cliente.getTelefono());
        clienteDto.setEmail(cliente.getEmail());
        return clienteDto;
    }

}
