package com.edu.mcs.Iquea.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.mcs.Iquea.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    boolean existsBySku(String sku);
    Optional<Producto> findBySku(String sku);

    List<Producto> findbyNombreContainingCase(String nombre);

    List<Producto> findbyCategoriaId(Long categoriaId);

    List<Producto> findbyes_destacado(Boolean es_destacado);

    List<Producto> findbyPrecioCantidadBetween(BigDecimal precioMinimo, BigDecimal precioMaximo);
}
