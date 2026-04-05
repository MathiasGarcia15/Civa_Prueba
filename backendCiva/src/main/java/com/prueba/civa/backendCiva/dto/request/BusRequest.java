package com.prueba.civa.backendCiva.dto.request;

import com.prueba.civa.backendCiva.entity.Marca;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusRequest {
    private String numeroBus;
    private String placa;
    private String caracteristicas;
    private Long marcaId;
    private Boolean activo;
}
