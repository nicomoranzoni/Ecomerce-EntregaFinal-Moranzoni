package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Repositories;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Controller.ClienteController;
import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
