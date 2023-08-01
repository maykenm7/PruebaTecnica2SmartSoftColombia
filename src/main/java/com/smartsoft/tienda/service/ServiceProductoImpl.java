package com.smartsoft.tienda.service;

import com.smartsoft.tienda.dto.ClienteDto;
import com.smartsoft.tienda.dto.DetalleDto;
import com.smartsoft.tienda.dto.ProductoDto;
import com.smartsoft.tienda.model.Cliente;
import com.smartsoft.tienda.model.Detalle;
import com.smartsoft.tienda.model.Producto;
import com.smartsoft.tienda.repository.RepositoryProducto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceProductoImpl implements ServiceProducto{

    private final RepositoryProducto repositoryProducto;
    @Override
    public Long guardarProducto(ProductoDto productoDto) {
       Producto producto = convertirProductoDtoAProducto(productoDto);
       repositoryProducto.save(producto);
       return producto.getId();
    }

    @Override
    public ProductoDto obtenerProducto(Long id) {
        Optional<Producto> producto = repositoryProducto.findById(id);
        if (producto.isPresent()) {
            return convertirProductoAProductoDto(producto.get());
        }
        throw new IllegalArgumentException("El producto no existe.");
    }


    private Producto convertirProductoDtoAProducto(ProductoDto productoDto){
        Producto producto = new Producto();
        producto.setNombre(productoDto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        producto.setStock(productoDto.getStock());
        return producto;
    }
    private ProductoDto convertirProductoAProductoDto(Producto producto){
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(producto.getId());
        productoDto.setNombre(producto.getNombre());
        productoDto.setPrecio(producto.getPrecio());
        productoDto.setStock(producto.getStock());
        return productoDto;
    }

}
