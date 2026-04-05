package com.prueba.civa.backendCiva.mapper;

import com.prueba.civa.backendCiva.dto.response.BusResponse;
import com.prueba.civa.backendCiva.dto.response.MarcaResponse;
import com.prueba.civa.backendCiva.entity.Bus;
import com.prueba.civa.backendCiva.entity.Marca;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public static BusResponse toResponse(Bus bus){
        if(bus == null) return null;

        return BusResponse.builder()
                .id(bus.getId())
                .numBus(bus.getNumBus())
                .placa(bus.getPlaca())
                .fechaCrea(bus.getFechaCrea())
                .caracteristicas(bus.getCaracteristicas())
                .marca(bus.getMarca() != null ? bus.getMarca().getNombre() : null)
                .activo(bus.getActivo())
                .build();
    }

    public static MarcaResponse toResponse(Marca marca){
        if(marca == null) return null;

        return MarcaResponse.builder()
                .id(marca.getId())
                .nombre(marca.getNombre())
                .build();
    }
}
