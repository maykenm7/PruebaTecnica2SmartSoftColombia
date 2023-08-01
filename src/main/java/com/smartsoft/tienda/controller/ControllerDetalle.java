package com.smartsoft.tienda.controller;

import com.smartsoft.tienda.dto.DetalleDto;
import com.smartsoft.tienda.service.ServiceDetalle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("detalles")
@RequiredArgsConstructor

public class ControllerDetalle {

    private final ServiceDetalle serviceDetalle;

    @PostMapping
    public ResponseEntity guardarDetalle(@RequestBody DetalleDto detalleDto){
        try{
            return new ResponseEntity(serviceDetalle.guardarDetalle(detalleDto), HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id_detalle}")
    public ResponseEntity obtenerDetalle(@PathVariable("id_detalle") Long id_detalle){
        try{
            return new ResponseEntity(serviceDetalle.obtenerDetalle(id_detalle), HttpStatus.CREATED.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
