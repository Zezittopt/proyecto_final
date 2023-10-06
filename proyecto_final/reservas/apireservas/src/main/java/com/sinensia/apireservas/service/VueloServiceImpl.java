package com.sinensia.apireservas.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.apireservas.model.Vuelo;
import com.sinensia.apireservas.repository.VueloRepository;

@Service
public class VueloServiceImpl implements VueloService {

    @Autowired
    VueloRepository vueloRepository;

    
    /** 
     * VERIFICAR SI VUELO TIENE LAS PLAZAS NECESARIAS
     * 
     * @param idVuelo
     * @param plazasSolicitadas
     */
    @Override
    public void verificarDisponibilidadPlazas(Long idVuelo, int plazasSolicitadas) {
        Optional<Vuelo> optionalVuelo = vueloRepository.findById(idVuelo);

        if (optionalVuelo.isPresent()) {
            Vuelo vuelo = optionalVuelo.get();
            if (vuelo.getPlazasDisponibles() < plazasSolicitadas) {
                throw new IllegalArgumentException("No hay suficientes plazas disponibles para la reserva");
            }
        } else {
            throw new IllegalArgumentException("Vuelo no encontrado");
        }
    }

    
    /** 
     * OBTENER VUELO A TRAVÉS DE SU ID PERSONAL
     * 
     * @param idVuelo
     * @return Vuelo
     */
    @Override
    public Vuelo obtenerVueloPorId(Long idVuelo) {
        return vueloRepository.findById(idVuelo).orElse(null);
    }

     
     /** 
      * ACTUALIZAR EL NUMERO DE ASIENTOS DISPONIBLES EN UN VUELO
      *
      * @param idVuelo
      * @param nuevasPlazasDisponibles
      */
     @Override
    public void actualizarPlazasDisponibles(Long idVuelo, int nuevasPlazasDisponibles) {
        Vuelo vuelo = vueloRepository.findById(idVuelo)
                .orElseThrow(() -> new NoSuchElementException("Vuelo no encontrado"));

        int plazasOcupadas = vuelo.getPlazasDisponibles() - nuevasPlazasDisponibles;

        if (plazasOcupadas >= 0) {
            vuelo.setPlazasDisponibles(plazasOcupadas);
            vueloRepository.actualizarPlazasDisponibles(idVuelo, plazasOcupadas);
        } else {
            throw new IllegalStateException("No hay suficientes plazas disponibles para la reserva.");
        }
    }
}
