package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Service.Comprobante;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Comprobante;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse.ComprobanteRequest;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse.ComprobanteResponse;

import java.util.List;

public interface ComprobanteService {

    List<Comprobante> mostrarTodos();

    Comprobante buscarComprobantePorID(Integer id);

    ComprobanteResponse crearCromprobante (ComprobanteRequest request) throws Exception;

    Comprobante actualizarComprobante( Comprobante comprobante) throws Exception;

    void eliminarComprobantePorId(Integer id);
}
