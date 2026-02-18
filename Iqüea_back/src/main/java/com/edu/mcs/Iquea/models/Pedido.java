package com.edu.mcs.Iquea.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.edu.mcs.Iquea.models.Enums.EstadoPedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedido_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha_pedido", nullable = false)
    private LocalDateTime fechaPedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoPedido estado;

    @Column(name = "referencia", unique = true, nullable = false, length = 10)
    private String referencia;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Detalle_pedido> detalles = new ArrayList<>();

    @com.fasterxml.jackson.annotation.JsonIgnore
    public static String generarCodigoAleatorio() {
        String caracteres = "ABCDEFGHJKLMNPQRSTUVWXYZ0123456789";
        java.security.SecureRandom random = new java.security.SecureRandom();
        StringBuilder codigo = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            codigo.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return codigo.toString();
    }

    @jakarta.persistence.PrePersist
    private void generarReferencia() {
        if (this.referencia == null) {
            this.referencia = generarCodigoAleatorio();
        }
    }

    public Pedido() {
    }

    public Pedido(EstadoPedido estado, LocalDateTime fechaPedido, Long pedido_id, Usuario usuario) {
        this.estado = estado;
        this.fechaPedido = fechaPedido;
        this.pedido_id = pedido_id;
        this.usuario = usuario;
    }

    public void agregarProducto(Producto producto, Integer cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (cantidad == null || cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }

        Detalle_pedido detalle = new Detalle_pedido(this, producto, cantidad, producto.getPrecio().getCantidad());
        this.detalles.add(detalle);
    }

    public BigDecimal calcularTotal() {
        return detalles.stream()
                .map(detalle -> detalle.getPrecioUnitario().multiply(new BigDecimal(detalle.getCantidad())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public List<Detalle_pedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle_pedido> detalles) {
        this.detalles = detalles;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
