package com.sinensia.apireservas.service;


import java.util.Optional;

import com.sinensia.apireservas.model.Reserva;

public interface ReservaService {
    void realizarReserva(Long idVuelo, Long idHotel, String nombre, String dni, int totalPersonas);
    Optional<Reserva> obtenerReservasPorHotel(Long idHotel);
}
