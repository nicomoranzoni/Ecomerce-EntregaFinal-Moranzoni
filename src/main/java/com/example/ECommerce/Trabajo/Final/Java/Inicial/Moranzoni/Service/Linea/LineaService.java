package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Linea;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Linea;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse.LineaRequest;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse.LineaResponse;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface LineaService {

    List<Linea> mostrarTodasLasVentas();

    Linea buscarVentaPorId(Integer id_venta);

    LineaResponse realizarVenta (LineaRequest venta) throws Exception;


}
