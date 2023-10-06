package com.sinensia.apireservas.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    private String nombreCliente;
    private String dni;
    private int totalPersonas;

    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "idVuelo")
    private Vuelo vuelo;

    public Reserva() {
        super();
    }

    public Reserva(String nombreCliente, String dni, int totalPersonas) {
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.totalPersonas = totalPersonas;
    }

    public Reserva(String nombreCliente, String dni, Vuelo vuelo) {
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.vuelo = vuelo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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

    public Long getIdReserva() {
        return idReserva;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    @Override
	public int hashCode() {
		return Objects.hash(idReserva);
	}


    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(idReserva, other.idReserva);
	}

    @Override
    public String toString() {
        return "Reserva [idReserva=" + idReserva + ", nombreCliente=" + nombreCliente + ", dni=" + dni
                + ", totalPersonas=" + totalPersonas + ", hotel=" + hotel + ", vuelo=" + vuelo + "]";
    }

    
}
