package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Linea;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ComprobanteResponse {

    private Integer id_comprobate;
    private String fecha;
    private Integer id_cliente;
    private Integer cantidad;
    private String nombreCompleto;
    private List<Linea> compraRealizada;
    private Integer totalArticulos;
    private Float total;
}
