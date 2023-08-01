package com.smartsoft.tienda.service;

import com.smartsoft.tienda.dto.DetalleDto;
import com.smartsoft.tienda.dto.FacturaDto;
import com.smartsoft.tienda.dto.ProductoDto;
import com.smartsoft.tienda.model.Cliente;
import com.smartsoft.tienda.model.Detalle;
import com.smartsoft.tienda.model.Factura;
import com.smartsoft.tienda.model.Producto;
import com.smartsoft.tienda.repository.RepositoryCliente;
import com.smartsoft.tienda.repository.RepositoryFactura;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceFacturaImpl implements ServiceFactura{

    private final RepositoryFactura repositoryFactura;
    private final RepositoryCliente repositoryCliente;
    @Override
    public Long guardarFactura(FacturaDto facturaDto) {
        Optional<Cliente> cliente = repositoryCliente.findById(facturaDto.getClienteId());
        if (cliente.isPresent()) {
            Factura factura = convertirFacturaDtoAFactura(cliente.get());
            repositoryFactura.save(factura);
            return factura.getId();
        }
        throw new IllegalArgumentException("El cliente asociado a la factura no existe.");
    }

    @Override
    public FacturaDto obtenerFactura(Long id) {
        Optional<Factura> factura = repositoryFactura.findById(id);
        if (factura.isPresent()) {
            return convertirFacturaAFacturaDto(factura.get());
        }
        throw new IllegalArgumentException("La factura no existe");
    }

    private Factura convertirFacturaDtoAFactura(Cliente cliente){
        Factura factura = new Factura();
        factura.setCliente(cliente);
        factura.setFecha(LocalDate.now());
        return factura;
    }

    private FacturaDto convertirFacturaAFacturaDto(Factura factura){
        FacturaDto facturaDto = new FacturaDto();
        facturaDto.setId(factura.getId());
        facturaDto.setClienteId(factura.getCliente().getId());
        facturaDto.setFecha(factura.getFecha());
        List<DetalleDto> detallesDto = new ArrayList<>();
        List<Detalle> detalles = factura.getDetalles();
        if(detalles != null) {
            for (Detalle detalle : detalles) {
                DetalleDto detalleDto = new DetalleDto();
                detalleDto.setId(detalle.getId());
                detalleDto.setFacturaId(detalle.getFactura().getId());
                detalleDto.setProductoId(detalle.getProducto().getId());
                detalleDto.setCantidad(detalle.getCantidad());
                detalleDto.setPrecio(detalle.getPrecio());
                detallesDto.add(detalleDto);
            }
        }
        facturaDto.setDetalles(detallesDto);
        return facturaDto;
    }

}
