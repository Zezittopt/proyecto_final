package com.sinensia.apihotel.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hoteles")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHotel;
    private String nombre;
    private int categoria;
    private double precio;
    private boolean disponible;
    
    public Hotel() {
        super();
    }

    public Hotel(String nombre, int categoria, double precio, boolean disponible) {
        super();
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.disponible = disponible;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


    @Override
	public int hashCode() {
		return Objects.hash(idHotel);
	}


    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(idHotel, other.idHotel);
	}

    @Override
    public String toString() {
        return "Hotel [idHotel=" + idHotel + ", nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio
                + ", disponible=" + disponible + "]";
    }



    
}
