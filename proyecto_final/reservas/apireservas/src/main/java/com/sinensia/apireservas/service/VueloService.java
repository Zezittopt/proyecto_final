package com.sinensia.apireservas.service;

import com.sinensia.apireservas.model.Vuelo;

public interface VueloService {
    public void verificarDisponibilidadPlazas(Long idVuelo, int plazasSolicitadas);
    public Vuelo obtenerVueloPorId(Long idVuelo);
    public void actualizarPlazasDisponibles(Long idVuelo, int nuevasPlazasDisponibles);
}
