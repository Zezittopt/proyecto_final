package com.sinensia.apihotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.apihotel.model.Hotel;
import com.sinensia.apihotel.repository.HotelRepository;
import com.sinensia.apihotel.service.HotelService;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class HotelController {
    
    @Autowired
    private HotelService hotelService;

	@Autowired
	private HotelRepository hotelRepository;


    private static final String CURSO_NOT_FOUND = "Los argumentos introducidos no fueron encontrados";

    // BUSCAR TODOS LOS HOTELES
    // http://localhost:8081/hoteles
	
    @GetMapping(value = "hoteles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> hotelesDisponibles(){
		List<Hotel> listaHoteles = hotelRepository.findByDisponibleTrue();
		return ResponseEntity.ok(listaHoteles);
	}
    
    // BUSCAR HOTEL POR NOMBRE
    // http://localhost:8081/hoteles/{nombre}

    @GetMapping(value = "hoteles/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> hotelPorNombre(@PathVariable("nombre") String nombre) {
		try {
			Hotel hotel = hotelService.hotelPorNombre(nombre);
			return ResponseEntity.ok(hotel);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CURSO_NOT_FOUND);
		}
	}
}
