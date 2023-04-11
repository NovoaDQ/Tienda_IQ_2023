package com.Tienda_IQ23.Tienda_IQ23.service;

import com.Tienda_IQ23.Tienda_IQ23.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria); //tanto para insertar como modificar un registro
    
    public void delete(Categoria categoria);
    
}
