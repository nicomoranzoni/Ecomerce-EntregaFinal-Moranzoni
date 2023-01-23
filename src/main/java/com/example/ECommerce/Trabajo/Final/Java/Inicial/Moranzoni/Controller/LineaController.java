package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Controller;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Linea;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse.LineaRequest;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse.LineaResponse;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Linea.LineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/linea")
public class LineaController {

    @Autowired
    LineaService lineaService;

    @GetMapping("/all")
    public List<Linea> mostrarTodasLasVentas(){
        return lineaService.mostrarTodasLasVentas();
    }

    @PostMapping("/vender")
    public LineaResponse vender (@RequestBody LineaRequest request) throws Exception{
        return lineaService.realizarVenta(request);
    }


}
