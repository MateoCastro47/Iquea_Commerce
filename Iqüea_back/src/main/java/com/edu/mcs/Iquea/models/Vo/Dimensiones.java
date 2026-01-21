package com.edu.mcs.Iquea.models.Vo;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class Dimensiones {
    public final Double ancho;
    public final Double alto;
    public final Double profundidad;

    protected Dimensiones(){
        this.ancho = 0.0;
        this.alto = 0.0;
        this.profundidad = 0.0;
    }

    public Dimensiones(Double alto, Double ancho, Double profundidad) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        validate();
    }

    private void validate(){
        if(alto == null || ancho == null || profundidad == null){
            throw new IllegalArgumentException("Las dimensiones no pueden ser nulas");
        }
        if(alto <= 0 || ancho <=0 || profundidad <= 0){
            throw new IllegalArgumentException("Las dimensiones deben ser mayores que 0");
        }
    }

    public Double getAncho() {
        return ancho;
    }

    public Double getAlto() {
        return alto;
    }

    public Double getProfundidad() {
        return profundidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dimensiones other)) return false;
        return Objects.equals(ancho, other.ancho)
                && Objects.equals(alto, other.alto)
                && Objects.equals(profundidad, other.profundidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alto,ancho,profundidad);
    }

    @Override
    public String toString() {
        return "Dimensiones [ancho=" + ancho + ", alto=" + alto + ", profundidad=" + profundidad + "]";
    }


    
}
