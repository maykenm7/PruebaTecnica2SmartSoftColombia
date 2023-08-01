package com.smartsoft.tienda.controller;

import com.smartsoft.tienda.dto.ClienteDto;
import com.smartsoft.tienda.service.ServiceCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor

public class ControllerCliente {

    private final ServiceCliente serviceCliente;

    @PostMapping
    public ResponseEntity guardarCliente(@RequestBody ClienteDto clienteDto){
        try{
            return new ResponseEntity(serviceCliente.guardarCliente(clienteDto), HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id_cliente}")
    public ResponseEntity obtenerCliente(@PathVariable("id_cliente") Long id_cliente){
        try{
            return new ResponseEntity(serviceCliente.obtenerCliente(id_cliente), HttpStatus.CREATED.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
