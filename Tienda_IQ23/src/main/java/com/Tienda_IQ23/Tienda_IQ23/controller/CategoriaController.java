package com.Tienda_IQ23.Tienda_IQ23.controller;

import com.Tienda_IQ23.Tienda_IQ23.domain.Categoria;
import com.Tienda_IQ23.Tienda_IQ23.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
    
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("/categoria/listado")
    public String inicio(Model model) {        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("Categorias", categorias);

        return "/categorias/listado";
    }
    
    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria){
        return "/categoria/modificar";
    }
    @PostMapping("/categoria/guardar")
    public String guardarCategoria (Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping ("/categoria/modificar/{id:Categoria}")
    public String modificarCategoria(Categoria categoria, Model model){
      categoria = categoriaService.getCategoria(categoria);
      model.addAttribute("categoria", categoria);
      return "/categoria/modificar";
    }
    
    @GetMapping("/categoria/eliminar/{id:Categoria}")
    public String eliminarCategoria(Categoria categoria){
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
    
}