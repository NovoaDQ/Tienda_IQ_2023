package com.Tienda_IQ23.Tienda_IQ23.controller;

import com.Tienda_IQ23.Tienda_IQ23.domain.Cliente;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author diego
 */
@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizando MVC");
        String mensaje= "Estamos en semana 4, saludos!";
        model.addAttribute("MensajeSaludo", mensaje);
        
        Cliente cliente = new Cliente("Diego", "Novoa Quiros", "diegoalonsonovoa2013@gmail.com", "87222725");
        Cliente cliente2 = new Cliente("Alonso", "Quiros Ramirez", "equiros@gmail.com", "834952714");
        //model.addAttribute("cliente",cliente);
        
        List<Cliente> clientes = Arrays.asList(cliente,cliente2);
        model.addAttribute("clientes", clientes);
        return "index";
    }

}
