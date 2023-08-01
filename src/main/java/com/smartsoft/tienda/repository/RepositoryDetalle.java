package com.smartsoft.tienda.repository;

import com.smartsoft.tienda.model.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDetalle extends JpaRepository<Detalle,Long>{


}
