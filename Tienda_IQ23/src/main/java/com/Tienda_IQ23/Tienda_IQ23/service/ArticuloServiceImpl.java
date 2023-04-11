package com.Tienda_IQ23.Tienda_IQ23.service;


import com.Tienda_IQ23.Tienda_IQ23.dao.ArticuloDao;
import com.Tienda_IQ23.Tienda_IQ23.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service //Anotación obligatoria para que los metodos funcionen
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activos) {
        var lista =(List<Articulo>)articuloDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.deleteById(articulo.getIdArticulo());
    }

}
