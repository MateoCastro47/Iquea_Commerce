package com.edu.mcs.Iquea.models.Vo;

import java.util.Objects;
import java.util.regex.Pattern;

import jakarta.persistence.Embeddable;

@Embeddable
public final class Email{
    public final String value;

    public static final Pattern PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    protected Email() {
        this.value = "invalid@email";
    }

    public Email(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value){
        if(value == null || value.isBlank()){
            throw new IllegalArgumentException("El email no puede ser nulo");
        }

        if(!PATTERN.matcher(value).matches()){
            throw new IllegalArgumentException("Formato de email invalido");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Email: " + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email other)) return false;
        return Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    
}