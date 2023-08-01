package com.smartsoft.tienda.controller;

import com.smartsoft.tienda.dto.FacturaDto;
import com.smartsoft.tienda.model.Factura;
import com.smartsoft.tienda.service.ServiceFactura;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("facturas")
@RequiredArgsConstructor

public class ControllerFactura {

    private final ServiceFactura serviceFactura;

    @PostMapping
    public ResponseEntity guardarFactura(@RequestBody FacturaDto facturaDto){
        try{
            return new ResponseEntity(serviceFactura.guardarFactura(facturaDto), HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id_factura}")
    public ResponseEntity obtenerFactura(@PathVariable("id_factura") Long id_factura){
        try{
            return new ResponseEntity(serviceFactura.obtenerFactura(id_factura), HttpStatus.CREATED.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
