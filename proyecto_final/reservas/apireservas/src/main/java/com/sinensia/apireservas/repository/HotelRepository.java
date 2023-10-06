package com.sinensia.apireservas.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sinensia.apireservas.model.Hotel;


public interface HotelRepository extends JpaRepository<Hotel, Long> {
    
    // SELECCIONAR HOTELES QUE COINCIDAN EN NOMBRE

    @Query("SELECT c FROM hoteles c WHERE c.nombre = :nombre")
    Hotel findByNombre(@Param("nombre")String nombre);
}
