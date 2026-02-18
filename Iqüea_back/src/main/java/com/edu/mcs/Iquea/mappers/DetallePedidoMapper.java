package com.edu.mcs.Iquea.mappers;

import java.math.BigDecimal;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.edu.mcs.Iquea.models.Detalle_pedido;
import com.edu.mcs.Iquea.models.dto.detalle.DetallePedidoDTO;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class, PedidoMapper.class})
public interface DetallePedidoMapper {

    @Mapping(target = "subtotal", expression = "java(calcularSubTotal(detallePedido))")
    DetallePedidoDTO toDTO(Detalle_pedido detallePedido);

    Detalle_pedido toEntity(DetallePedidoDTO dto);

    List<DetallePedidoDTO> toDTOlist(List<Detalle_pedido> detallePedidos);

    void updateFromEntity(DetallePedidoDTO dto, @MappingTarget Detalle_pedido detallePedido);

    default BigDecimal calcularSubTotal(Detalle_pedido detallePedido) {
        if (detallePedido.getPrecioUnitario() == null || detallePedido.getCantidad() == null) {
            return BigDecimal.ZERO;
        }
        return detallePedido.getPrecioUnitario().multiply(new BigDecimal(detallePedido.getCantidad()));
    }
}
