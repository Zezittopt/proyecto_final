package com.sinensia.apireservas.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sinensia.apireservas.model.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    
    // ACTUALIZAR LAS PLAZAS DE UN VUELO

    @Query("UPDATE Vuelo v SET v.plazasDisponibles = :plazasDisponibles WHERE v.idVuelo = :idVuelo")
    void actualizarPlazasDisponibles(@Param("idVuelo") Long idVuelo, @Param("plazasDisponibles") int plazasDisponibles);
}
