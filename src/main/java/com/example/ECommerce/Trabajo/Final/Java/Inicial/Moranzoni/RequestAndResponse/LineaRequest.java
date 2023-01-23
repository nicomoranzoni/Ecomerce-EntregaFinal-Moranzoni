package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.RequestAndResponse;

import lombok.Data;

@Data
public class LineaRequest {

    private Integer id_cliente;
    private Integer numeroComprobante;

    private Integer codigoProducto;
    private Integer cantidadComprada;


}
