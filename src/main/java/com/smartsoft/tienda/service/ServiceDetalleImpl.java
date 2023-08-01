package com.smartsoft.tienda.service;

import com.smartsoft.tienda.dto.DetalleDto;
import com.smartsoft.tienda.dto.ProductoDto;
import com.smartsoft.tienda.model.Factura;
import com.smartsoft.tienda.model.Detalle;
import com.smartsoft.tienda.model.Producto;
import com.smartsoft.tienda.repository.RepositoryFactura;
import com.smartsoft.tienda.repository.RepositoryDetalle;
import com.smartsoft.tienda.repository.RepositoryProducto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceDetalleImpl implements ServiceDetalle{

    private final RepositoryDetalle repositoryDetalle;
    private final RepositoryFactura repositoryFactura;
    private final RepositoryProducto repositoryProducto;
    @Override
    public Long guardarDetalle(DetalleDto detalleDto) {
        Optional<Factura> factura = repositoryFactura.findById(detalleDto.getFacturaId());
        Optional<Producto> producto = repositoryProducto.findById(detalleDto.getProductoId());
        if (factura.isPresent() && producto.isPresent()) {
            if(detalleDto.getCantidad() > producto.get().getStock()){
                throw new IllegalArgumentException("La cantidad de productos solicidadas excende el stock disponible");
            }
            Detalle detalle = convertirDetalleDtoADetalle(detalleDto, producto.get(), factura.get());
            repositoryDetalle.save(detalle);
            return detalle.getId();
        }
        throw new IllegalArgumentException("El producto o factura asociado al detalle no existe.");
    }

    @Override
    public DetalleDto obtenerDetalle(Long id) {
        Optional<Detalle> detalle = repositoryDetalle.findById(id);
        if (detalle.isPresent()) {
            return convertirDetalleADetalleDto(detalle.get());
        }
        throw new IllegalArgumentException("El detalle no existe");
    }

    private Detalle convertirDetalleDtoADetalle(DetalleDto detalleDto, Producto producto, Factura factura){
        Detalle detalle = new Detalle();
        detalle.setCantidad(detalleDto.getCantidad());
        producto.setStock(producto.getStock()-detalleDto.getCantidad());
        detalle.setPrecio(detalleDto.getCantidad() * producto.getPrecio());
        detalle.setFactura(factura);
        detalle.setProducto(producto);
        return detalle;
    }

    private DetalleDto convertirDetalleADetalleDto(Detalle detalle){
        DetalleDto detalleDto = new DetalleDto();
       detalleDto.setId(detalle.getId());
        detalleDto.setFacturaId(detalle.getFactura().getId());
        detalleDto.setProductoId(detalle.getProducto().getId());
        detalleDto.setPrecio(detalle.getPrecio());
        detalleDto.setCantidad(detalle.getCantidad());
        return detalleDto;
    }

}
