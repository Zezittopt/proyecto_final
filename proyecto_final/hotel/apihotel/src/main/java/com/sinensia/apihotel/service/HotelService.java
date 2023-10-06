package com.sinensia.apihotel.service;

import java.util.List;

import com.sinensia.apihotel.model.Hotel;

public interface HotelService {
    public List<Hotel> hotelesDisponibles();
    public Hotel hotelPorNombre(String nombre);
}
