package com.sinensia.apireservas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.apireservas.model.Hotel;
import com.sinensia.apireservas.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    
    /** 
     * VERIFICAR SI EL HOTEL ESTÁ DISPONIBLE PARA LA RESERVA
     * 
     * @param idHotel
     */
    @Override
    public void verificarDisponibilidadHotel(Long idHotel) {
        Hotel hotel = hotelRepository.findById(idHotel).orElse(null);
        if (hotel == null) {
            throw new IllegalArgumentException("Hotel no encontrado");
        }
    }

    
    /** 
     * OBTENER HOTEL POR ID SOLICITADO
     * 
     * @param idHotel
     * @return Hotel
     */
    @Override
    public Hotel obtenerHotelPorId(Long idHotel) {
        return hotelRepository.findById(idHotel).orElse(null);
    }

    
    /** 
     * OBTENER ID DE HOTEL A TRAVÉS DE SU NOMBRE
     * 
     * @param nombre
     * @return Long
     */
    @Override
    public Long obtenerIdHotelPorNombre(String nombre) {
        Hotel hotel = hotelRepository.findByNombre(nombre);
        if (hotel != null) {
            return hotel.getIdHotel();
        } else {
            throw new IllegalArgumentException("Hotel no encontrado");
        }
    }
}
