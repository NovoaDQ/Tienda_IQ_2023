package com.Tienda_IQ23.Tienda_IQ23.service;

import com.Tienda_IQ23.Tienda_IQ23.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    
    public List<Articulo> getArticulos(boolean activos);
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save(Articulo articulo); //tanto para insertar como modificar un registro
    
    public void delete(Articulo articulo);
    
}
