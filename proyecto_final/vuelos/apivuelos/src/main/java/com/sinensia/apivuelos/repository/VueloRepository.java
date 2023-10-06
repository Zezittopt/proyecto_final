package com.sinensia.apivuelos.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sinensia.apivuelos.model.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {

    // SELECCIONA TODOS LOS VUELOS CON SUFICIENTES PLAZAS DISPONIBLES
    // SELECT * FROM vuelos WHERE plazasDisponibles >= ?;
    @Query("SELECT c FROM vuelos c WHERE c.plazasDisponibles >= :plazasDisponibles")
    List<Vuelo> findByPlazasDisponiblesGreaterThanEqual
                (@Param("plazasDisponibles")int plazasSolicitadas);
}
