package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Repositories;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante, Integer> {
}
