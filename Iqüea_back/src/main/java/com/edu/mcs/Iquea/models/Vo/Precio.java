package com.edu.mcs.Iquea.models.Vo;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jakarta.persistence.Embeddable;

@Embeddable
public final class Precio {
    private final BigDecimal cantidad;
    private final String moneda;

    protected Precio(){
        this.cantidad = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        this.moneda = "EUR";
    }

     public Precio(BigDecimal cantidad, String moneda){
        validate(cantidad, moneda);
        this.cantidad = cantidad.setScale(2, RoundingMode.HALF_UP);
        this.moneda = moneda.toUpperCase();
    }

    private void validate(BigDecimal cantidad, String moneda){
        if(cantidad ==null){
            throw new IllegalArgumentException("El precio no puede ser nulo");
        }
        if(cantidad.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        if(moneda == null || moneda.isBlank()){
            throw new IllegalArgumentException("La moneda no puede ser nula ni vacia");
        }
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public String getMoneda() {
        return moneda;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
        result = prime * result + ((moneda == null) ? 0 : moneda.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Precio other)) return false;

        return cantidad.compareTo(other.cantidad) == 0 && moneda.equals(other.moneda);
    }


    
}
