
package com.Tienda_IQ23.Tienda_IQ23.service;


import com.Tienda_IQ23.Tienda_IQ23.dao.ClienteDao;
import com.Tienda_IQ23.Tienda_IQ23.dao.CreditoDao;
import com.Tienda_IQ23.Tienda_IQ23.domain.Cliente;
import com.Tienda_IQ23.Tienda_IQ23.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service 
@Transactional(readOnly = true) 
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    CreditoDao creditoDao;

    @Autowired
    ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente){
    Credito credito = cliente.getCredito();
    creditoDao.save(credito);
    
    cliente.setCredito(credito);
    clienteDao.save (cliente);
}

@Override
@Transactional
public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }
    
    
}