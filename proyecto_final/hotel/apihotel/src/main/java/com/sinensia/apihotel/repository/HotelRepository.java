package com.sinensia.apihotel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sinensia.apihotel.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

    // SELECCIONAMOS TODOS LOS HOTELES DISPONIBLES
    // SELECT * FROM hoteles WHERE disponible = 'si';
    @Query("SELECT c FROM hoteles c WHERE c.disponible = 'si'")
    List<Hotel> findByDisponibleTrue();

    // SELECCIONAMOS TODOS LOS HOTELES QUE COINCIDAN CON EL NOMBRE PASADO COMO PARAMETRO
    //SELECT * FROM hoteles WHERE nombre = ?;
    @Query("SELECT c FROM hoteles c WHERE c.nombre = :nombre")
    Optional<Hotel> findByNombre(@Param("nombre")String nombre);
}
