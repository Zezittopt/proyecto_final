package com.sinensia.apihotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.apihotel.model.Hotel;
import com.sinensia.apihotel.repository.HotelRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelRepository hotelRepository;

    
    /** 
     * Listamos los hoteles disponibles.
     * 
     * @return List<Hotel>
     */
    @Override
    public List<Hotel> hotelesDisponibles() {
        return hotelRepository.findByDisponibleTrue();
    }

    
    /** 
     * Buscamos los hoteles por su nombre.
     * 
     * @param nombre
     * @return Hotel
     * @throws EntityNotFoundException
     */
    @Override
    public Hotel hotelPorNombre(String nombre) throws EntityNotFoundException{
		Optional<Hotel> optionalHotel = hotelRepository.findByNombre(nombre);
		
		if(optionalHotel.isEmpty()) {
			throw new EntityNotFoundException();
		}
		
		return optionalHotel.get();
	}
    
}
