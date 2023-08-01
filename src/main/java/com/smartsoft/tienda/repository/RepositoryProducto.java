package com.smartsoft.tienda.repository;

import com.smartsoft.tienda.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProducto extends JpaRepository<Producto,Long>{


}
