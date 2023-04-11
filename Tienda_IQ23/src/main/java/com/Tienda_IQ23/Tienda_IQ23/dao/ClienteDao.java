package com.Tienda_IQ23.Tienda_IQ23.dao;

import com.Tienda_IQ23.Tienda_IQ23.domain.Cliente;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long>{
    
}