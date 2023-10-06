package com.sinensia.apireservas.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.apireservas.model.Reserva;
import com.sinensia.apireservas.model.ReservaRequest;
import com.sinensia.apireservas.service.HotelService;
import com.sinensia.apireservas.service.ReservaService;
import com.sinensia.apireservas.service.VueloService;

@RestController
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @Autowired
    HotelService hotelService;

    @Autowired
    VueloService vueloService;

    
    /** 
     * REALIZAR UNA NUEVA RESERVA CON REQUEST JSON
     * 
     * @param reservaRequest
     * @return ResponseEntity<String>
     */
    @PostMapping(value="reservas/nueva", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> realizarReserva(@RequestBody ReservaRequest reservaRequest) {
        // Realizar la reserva en la base de datos
        reservaService.realizarReserva(
                reservaRequest.getIdVuelo(),
                reservaRequest.getIdHotel(),
                reservaRequest.getNombre(),
                reservaRequest.getDni(),
                reservaRequest.getTotalPersonas()
        );

        // Interactuar con el servicio de vuelos para actualizar las plazas disponibles
        vueloService.actualizarPlazasDisponibles(reservaRequest.getIdVuelo(), reservaRequest.getTotalPersonas());

        return ResponseEntity.ok("Reserva realizada con éxito.");
    }

    
    /** 
     * OBTENER LISTA DE RESERVAS REALIZADAS EN UN HOTEL QUE COINCIDA CON EL NOMBRE
     * 
     * @param nombreHotel
     * @return List<Reserva>
     */
    @GetMapping(value = "reservas/{nombreHotel}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reserva> obtenerReservasPorNombreHotel(@RequestParam("nombreHotel") String nombreHotel) {
        // Obtener el idHotel utilizando el servicio de hoteles
        Long idHotel = hotelService.obtenerIdHotelPorNombre(nombreHotel);

        // Obtener las reservas para el hotel con el idHotel obtenido
        Optional<Reserva> reservas = reservaService.obtenerReservasPorHotel(idHotel);

        List<Reserva> reservaDTOs = reservas.stream()
                .map(reserva -> new Reserva(
                        reserva.getNombreCliente(),
                        reserva.getDni(),
                        reserva.getVuelo()))
                .collect(Collectors.toList());

        return reservaDTOs;
    }
}

