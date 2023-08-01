package com.smartsoft.tienda.repository;

import com.smartsoft.tienda.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCliente extends JpaRepository<Cliente,Long>{


}
