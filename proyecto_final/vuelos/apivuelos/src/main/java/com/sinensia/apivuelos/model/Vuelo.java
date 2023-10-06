package com.sinensia.apivuelos.model;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vuelos")
public class Vuelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVuelo;
    private String compania;
    private Date fechaVuelo;
    private double precio;
    private int plazasDisponibles;

    public Vuelo() {
        super();
    }

    public Vuelo(String compania, Date fechaVuelo, double precio, int plazasDisponibles) {
        super();
        this.compania = compania;
        this.fechaVuelo = fechaVuelo;
        this.precio = precio;
        this.plazasDisponibles = plazasDisponibles;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public Date getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(Date fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public void setPlazasDisponibles(int plazasDisponibles) {
        this.plazasDisponibles = plazasDisponibles;
    }

    public Long getIdVuelo() {
        return idVuelo;
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(idVuelo);
	}


    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(idVuelo, other.idVuelo);
	}

    @Override
    public String toString() {
        return "Vuelo [idVuelo=" + idVuelo + ", compania=" + compania + ", fechaVuelo=" + fechaVuelo + ", precio="
                + precio + ", plazasDisponibles=" + plazasDisponibles + "]";
    }
    
}
