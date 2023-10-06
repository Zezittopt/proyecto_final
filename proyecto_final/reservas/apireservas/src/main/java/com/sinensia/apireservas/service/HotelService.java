package com.sinensia.apireservas.service;

import com.sinensia.apireservas.model.Hotel;

public interface HotelService {
    public void verificarDisponibilidadHotel(Long idHotel);
    public Hotel obtenerHotelPorId(Long idHotel);
    public Long obtenerIdHotelPorNombre(String nombre);
}
