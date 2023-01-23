package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse;

import lombok.Data;

@Data
public class LineaResponse {

    private Integer idVenta;
    private Integer codigoProducto;
    private String descripcionProducto;
    private Float precioProdcuto;
    private Integer cantidadComprada;
    private Integer idComprobante;




}
