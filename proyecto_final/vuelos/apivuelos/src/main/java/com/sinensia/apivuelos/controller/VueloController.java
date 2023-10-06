package com.sinensia.apivuelos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.apivuelos.model.Vuelo;
import com.sinensia.apivuelos.service.VueloService;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class VueloController {
    
    @Autowired
    VueloService vueloService;

    private static final String CURSO_NOT_FOUND = "Los argumentos introducidos no han sido encontrado";

    
	/** 
	 * BUSCAR TODOS LOS VUELOS CON PLAZAS DISPONIBLES
     * http://localhost:8081/vuelos/15
	 * @param plazasSolicitadas
	 * @return ResponseEntity<?>
	 */
	@GetMapping(value = "vuelos/{plazasSolicitadas}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerVuelosDisponibles(@PathVariable int plazasSolicitadas){
		try {
			List<Vuelo> vuelosDisponibles = vueloService.obtenerVuelosDisponibles(plazasSolicitadas);
			return ResponseEntity.ok(vuelosDisponibles);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CURSO_NOT_FOUND);
		}
    }

    
	/** 
	 * ACTUALIZAR EL VUELO CON LAS PLAZAS SOLICITADAS
     * http://localhost:8081/vuelos/1/15
	 * @param @RequestParam("idVuelo"
	 * @return ResponseEntity<?>
	 */
	@PutMapping(value = "vuelos/{idVuelo}/{plazasSolicitadas}")
	public ResponseEntity<?> actualizarVuelo(@RequestParam("idVuelo") Long idVuelo,
			@PathVariable int plazasSolicitadas) {
		try {
			vueloService.actualizarVuelo(idVuelo, plazasSolicitadas);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CURSO_NOT_FOUND);
		}

	}

}
