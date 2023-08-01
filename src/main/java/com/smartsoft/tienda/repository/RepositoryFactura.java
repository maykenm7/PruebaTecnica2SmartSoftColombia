package com.smartsoft.tienda.repository;

import com.smartsoft.tienda.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFactura extends JpaRepository<Factura,Long>{


}
