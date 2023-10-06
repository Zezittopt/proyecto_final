package com.sinensia.apivuelos.service;

import java.util.List;

import com.sinensia.apivuelos.model.Vuelo;

public interface VueloService {
    public List<Vuelo> obtenerVuelosDisponibles(int plazasSolicitadas);
    public void actualizarVuelo(Long idVuelo, int plazasReservadas);
}
