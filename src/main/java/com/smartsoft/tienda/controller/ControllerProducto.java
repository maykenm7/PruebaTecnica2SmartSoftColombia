package com.smartsoft.tienda.controller;

import com.smartsoft.tienda.dto.ProductoDto;
import com.smartsoft.tienda.model.Producto;
import com.smartsoft.tienda.service.ServiceProducto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("productos")
@RequiredArgsConstructor

public class ControllerProducto {

    private final ServiceProducto serviceProducto;

    @PostMapping
    public ResponseEntity guardarProducto(@RequestBody ProductoDto productoDto){
        try{
            return new ResponseEntity(serviceProducto.guardarProducto(productoDto), HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id_producto}")
    public ResponseEntity obtenerProducto(@PathVariable("id_producto") Long id_producto){
        try{
            return new ResponseEntity(serviceProducto.obtenerProducto(id_producto), HttpStatus.CREATED.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
