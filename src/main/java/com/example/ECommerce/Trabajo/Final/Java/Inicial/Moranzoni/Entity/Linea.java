package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LINEA")
public class Linea {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_LINEA")
    private Integer id_linea;

    @Column(name = "CODIGO")
    private Integer codigo;

    @Column (name = "DESCRIPCION")
    private String descripcion;

    @Column (name = "PRECIO")
    private Float precio;

    @Column (name = "CANTIDAD")
    private Integer cantidad;

    @Column (name = "ID_COMPROBANTE")
    private Integer id_comprobante;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comprobante comprobante;

    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;
}
