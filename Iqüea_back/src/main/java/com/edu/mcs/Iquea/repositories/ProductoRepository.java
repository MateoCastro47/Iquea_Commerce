package com.edu.mcs.Iquea.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.mcs.Iquea.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    boolean existsBySku(String sku);

    Optional<Producto> findBySku(String sku);

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByCategoriaCategoria_id(Long categoriaId);

    List<Producto> findByEs_destacado(Boolean es_destacado);

    List<Producto> findByPrecioCantidadBetween(BigDecimal precioMinimo, BigDecimal precioMaximo);
}
