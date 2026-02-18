package com.edu.mcs.Iquea.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.mcs.Iquea.mappers.CategoriaMapper;
import com.edu.mcs.Iquea.models.Categorias;
import com.edu.mcs.Iquea.models.dto.detalle.CategoriaDetalleDTO;
import com.edu.mcs.Iquea.services.ICategoriaService;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    
    private final ICategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;
    
    public CategoriaController(ICategoriaService categoriaService, CategoriaMapper categoriaMapper) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDetalleDTO>> listarTodas(){
        List<Categorias> categorias = categoriaService.obtenerTodaslasCategorias();
        return ResponseEntity.ok(categorias.stream().map(categoriaMapper::toDTO).toList());
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<CategoriaDetalleDTO> obtenerPorNombre(@PathVariable String nombre){
        return categoriaService.obtenerCategoriaPorNombre(nombre)
        .map(c-> ResponseEntity.ok(categoriaMapper.toDTO(c)))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoriaDetalleDTO> crear(@RequestBody CategoriaDetalleDTO dto){
        Categorias creada = categoriaService.crearCategoria(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaMapper.toDTO(creada));
    }

    @PutMapping("/{nombre}")
    public ResponseEntity<CategoriaDetalleDTO> actualizar(
        @PathVariable String nombre,
        @RequestBody CategoriaDetalleDTO dto) {
        Categorias actualizada = categoriaService.actualizarCategoria(dto, nombre);
        return ResponseEntity.ok(categoriaMapper.toDTO(actualizada));
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> eliminar(@PathVariable String nombre){
        categoriaService.borrarCategoria(nombre);
        return ResponseEntity.noContent().build();
    }
    
}
