package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.util.List;

@Entity
@Table (name = "CLIENTES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Integer id_cliente;

    @Column (name = "NOMBRE")
    private String nombre;

    @Column (name = "APELLIDO")
    private String apellido;

    @Column (name = "DNI")
    private Integer dni;


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comprobante> comprobanteList;


}
