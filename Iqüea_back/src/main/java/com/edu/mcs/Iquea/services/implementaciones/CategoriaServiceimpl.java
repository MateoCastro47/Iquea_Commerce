package com.edu.mcs.Iquea.services.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.mcs.Iquea.mappers.CategoriaMapper;
import com.edu.mcs.Iquea.models.Categorias;
import com.edu.mcs.Iquea.models.dto.detalle.CategoriaDetalleDTO;
import com.edu.mcs.Iquea.repositories.CategoriasRepository;
import com.edu.mcs.Iquea.services.ICategoriaService;

@Service
public class CategoriaServiceimpl implements ICategoriaService{
    
    private final CategoriasRepository categoriasRepository;
    private final CategoriaMapper categoriaMapper;

    
    public CategoriaServiceimpl(CategoriasRepository categoriasRepository, CategoriaMapper categoriaMapper) {
        this.categoriasRepository = categoriasRepository;
        this.categoriaMapper = categoriaMapper;
    }


    @Override
    public Categorias actualizarCategoria(CategoriaDetalleDTO dto, String nombre) {
        try{
            Categorias categoriaActualizada = categoriasRepository.findByNombre(nombre)
            .orElseThrow(() -> new RuntimeException("No existe categoria con nombre: " + nombre));
            
            categoriaMapper.updatefromEntity(dto, categoriaActualizada);

            return categoriasRepository.save(categoriaActualizada);
        } catch(IllegalArgumentException e){
            throw new RuntimeException("Datos de la categoria no válidos");
        }

    }


    @Override
    public void borrarCategoria(String nombre) {
        if (categoriasRepository.existsByNombre(nombre)) {
            categoriasRepository.deleteByNombre(nombre);
        }
    }


    @Override
    public Categorias crearCategoria(CategoriaDetalleDTO dto) {
        if (categoriasRepository.existsByNombre(dto.getNombre())) {
            throw new IllegalArgumentException("Ya existe una categoria con nombre: " + dto.getNombre());
        }

        Categorias categorias = categoriaMapper.toEntity(dto);
        return categoriasRepository.save(categorias);
    }


    @Override
    public Optional<Categorias> obtenerCategoriaPorNombre(String nombre){
        return categoriasRepository.findByNombre(nombre);
    }


    @Override
    public List<Categorias> obtenerTodaslasCategorias() {
        return categoriasRepository.findAll();
    }

    
}
