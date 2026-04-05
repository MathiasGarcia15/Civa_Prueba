package com.prueba.civa.backendCiva.dto.response;

import com.prueba.civa.backendCiva.entity.Marca;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusResponse {
    private Long id;
    private String numBus;
    private String placa;
    private LocalDate fechaCrea;
    private String caracteristicas;
    private String marca;
    private Boolean activo;
}
