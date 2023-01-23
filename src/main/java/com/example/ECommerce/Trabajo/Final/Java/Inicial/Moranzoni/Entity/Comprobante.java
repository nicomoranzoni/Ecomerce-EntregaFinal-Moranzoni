package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "COMPROBANTE")
public class Comprobante {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_COMPROBANTE")
    private Integer id_comprobante;

    @Column(name = "ID_CLIENTE")
    private Integer id_cliente;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column (name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name = "FECHA")
    private Date fecha;

    @Column(name = "TOTAL")
    private Float total;


    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @OneToMany ( mappedBy = "comprobante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Linea> lineaList;





}
