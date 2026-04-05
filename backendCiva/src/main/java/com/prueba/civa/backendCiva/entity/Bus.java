package com.prueba.civa.backendCiva.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numBus;
    private String placa;

    @CreationTimestamp
    private LocalDate fechaCrea;

    private String caracteristicas;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    private Boolean activo;
}
