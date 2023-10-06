package com.sinensia.apivuelos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.apivuelos.model.Vuelo;
import com.sinensia.apivuelos.repository.VueloRepository;


@Service
public class VueloServiceImpl implements VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    
    /** 
     * SE OBTIENEN LOS VUELOS DISPONIBLES
     * 
     * @param plazasSolicitadas
     * @return List<Vuelo>
     */
    @Override
    public List<Vuelo> obtenerVuelosDisponibles(int plazasSolicitadas) {
        return vueloRepository.findByPlazasDisponiblesGreaterThanEqual(plazasSolicitadas);
    }

    
    /** 
     * ACTUALIZAR VUELO EN LA BASE DE DATOS
     * 
     * @param idVuelo
     * @param plazasReservadas
     */
    @Override
    public void actualizarVuelo(Long idVuelo, int plazasReservadas) {
        Optional<Vuelo> optionalVuelo = vueloRepository.findById(idVuelo);
        
        if (optionalVuelo.isPresent()) {
            Vuelo vuelo = optionalVuelo.get();
            int plazasDisponibles = vuelo.getPlazasDisponibles();

            if (plazasDisponibles >= plazasReservadas) {
                vuelo.setPlazasDisponibles(plazasDisponibles - plazasReservadas);
                vueloRepository.save(vuelo);
            } else {
                throw new IllegalArgumentException("No hay suficientes plazas disponibles para la reserva.");
            }
        } else {
            throw new IllegalArgumentException("Vuelo no encontrado.");
        }
    }
}
