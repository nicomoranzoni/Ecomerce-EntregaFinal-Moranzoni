package com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Repositories;

import com.example.ECommerce.Trabajo.Final.Java.Inicial.Moranzoni.Entity.Linea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaRepository extends JpaRepository<Linea, Integer> {
}
