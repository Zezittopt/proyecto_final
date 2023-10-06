package com.sinensia.apireservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.apireservas.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
}
