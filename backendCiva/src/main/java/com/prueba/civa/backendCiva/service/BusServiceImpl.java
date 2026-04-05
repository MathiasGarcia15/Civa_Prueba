package com.prueba.civa.backendCiva.service;

import com.prueba.civa.backendCiva.dto.request.BusRequest;
import com.prueba.civa.backendCiva.dto.response.BusResponse;
import com.prueba.civa.backendCiva.entity.Bus;
import com.prueba.civa.backendCiva.entity.Marca;
import com.prueba.civa.backendCiva.mapper.Mapper;
import com.prueba.civa.backendCiva.repository.BusRepository;
import com.prueba.civa.backendCiva.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService{

    private final BusRepository busRepository;
    private final MarcaRepository marcaRepository;

    @Override
    public Page<BusResponse> obtenerBuses(int page, int size) {
        return busRepository.findAll(PageRequest.of(page, size)).map(Mapper::toResponse);
    }

    @Override
    public BusResponse obtenerBusById(Long id) {
        Bus bus = busRepository.findById(id).orElseThrow(()->new RuntimeException("Bus no encontrado"));
        return Mapper.toResponse(bus);
    }

    @Override
    public BusResponse addBus(BusRequest request) {
        Marca marca = marcaRepository.findById(request.getMarcaId())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));


        Bus bus = Bus.builder()
                .numBus(request.getNumeroBus())
                .placa(request.getPlaca())
                .caracteristicas(request.getCaracteristicas())
                .marca(marca)
                .activo(request.getActivo())
                .build();
        return Mapper.toResponse(busRepository.save(bus));
    }
}
