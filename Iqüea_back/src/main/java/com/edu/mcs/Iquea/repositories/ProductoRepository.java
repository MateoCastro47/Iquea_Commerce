package com.edu.mcs.Iquea.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.mcs.Iquea.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    boolean existsBySku(String sku);

    Optional<Producto> findBySku(String sku);

    List<Producto> findByNombreContainingIgnoreCaseOrDescripcionContainingIgnoreCase(String nombre, String descripcion);

    @Query("SELECT p FROM Producto p WHERE p.categoria.categoria_id = :categoriaId")
    List<Producto> findByCategoriaId(@Param("categoriaId") Long categoriaId);

    @Query("SELECT p FROM Producto p WHERE p.es_destacado = :es_destacado")
    List<Producto> findByEs_destacado(@Param("es_destacado") Boolean es_destacado);

    List<Producto> findByPrecioCantidadBetween(BigDecimal precioMinimo, BigDecimal precioMaximo);
}
