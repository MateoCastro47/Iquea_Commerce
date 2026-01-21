package com.edu.mcs.Iquea.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.edu.mcs.Iquea.models.Pedido;
import com.edu.mcs.Iquea.models.dto.detalle.PedidoDetalleDTO;

@Mapper(componentModel = "spring", uses = {UsuarioMapperResumen.class, DetallePedidoMapper.class})
public interface PedidoMapper {
    
   
    PedidoDetalleDTO toDTO(Pedido pedido);
    
    
    Pedido toEntity(PedidoDetalleDTO dto);

    List<PedidoDetalleDTO> toDTOlist(List<Pedido> pedidos);

    void updateFromEntity(PedidoDetalleDTO dto, @MappingTarget Pedido pedido);
}
