package com.sinensia.apireservas.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.apireservas.model.Reserva;
import com.sinensia.apireservas.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    HotelService hotelService;

    @Autowired
    VueloService vueloService;



    
    /** 
     * REALIZAR UNA NUEVA RESERVA
     * 
     * @param idVuelo
     * @param idHotel
     * @param nombre
     * @param dni
     * @param totalPersonas
     */
    @Override
    public void realizarReserva(Long idVuelo, Long idHotel, String nombre, String dni, int totalPersonas) {
        // Verificar disponibilidad de plazas en el vuelo
        vueloService.verificarDisponibilidadPlazas(idVuelo, totalPersonas);

        // Verificar disponibilidad en el hotel
        hotelService.verificarDisponibilidadHotel(idHotel);

        // Crear la reserva
        Reserva reserva = new Reserva();
        reserva.setNombreCliente(nombre);
        reserva.setDni(dni);
        reserva.setTotalPersonas(totalPersonas);
        reserva.setVuelo(vueloService.obtenerVueloPorId(idVuelo));
        reserva.setHotel(hotelService.obtenerHotelPorId(idHotel));

        reservaRepository.save(reserva);
    }

    
    /** 
     * OBTENER TODAS LAS RESERVAS EN UN HOTEL
     * 
     * @param idHotel
     * @return Optional<Reserva>
     */
    @Override
    public Optional<Reserva> obtenerReservasPorHotel(Long idHotel) {
        return reservaRepository.findById(idHotel);
    }
    
}
