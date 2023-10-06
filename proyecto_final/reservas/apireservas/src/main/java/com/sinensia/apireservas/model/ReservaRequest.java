package com.sinensia.apireservas.model;

public class ReservaRequest {
    private Long idVuelo;
    private Long idHotel;
    private String nombre;
    private String dni;
    private int totalPersonas;
    
    public ReservaRequest(Long idVuelo, Long idHotel, String nombre, String dni, int totalPersonas) {
        this.idVuelo = idVuelo;
        this.idHotel = idHotel;
        this.nombre = nombre;
        this.dni = dni;
        this.totalPersonas = totalPersonas;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public int getTotalPersonas() {
        return totalPersonas;
    }
    public void setTotalPersonas(int totalPersonas) {
        this.totalPersonas = totalPersonas;
    }
    public Long getIdVuelo() {
        return idVuelo;
    }
    public Long getIdHotel() {
        return idHotel;
    }

    
}
