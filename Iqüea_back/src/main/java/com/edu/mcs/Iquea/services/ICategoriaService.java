package com.edu.mcs.Iquea.services;

import java.util.List;
import java.util.Optional;

import com.edu.mcs.Iquea.models.Categorias;
import com.edu.mcs.Iquea.models.dto.detalle.CategoriaDetalleDTO;

public interface ICategoriaService {
    
    Categorias crearCategoria(CategoriaDetalleDTO dto);

    Optional<Categorias> obtenerCategoriaPorNombre(String nombre);

    List<Categorias> obtenerTodaslasCategorias();

    Categorias actualizarCategoria(CategoriaDetalleDTO dto, String nombre);

    void borrarCategoria(String nombre);
}
