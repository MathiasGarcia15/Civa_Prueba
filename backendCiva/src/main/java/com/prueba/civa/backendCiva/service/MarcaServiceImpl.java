package com.prueba.civa.backendCiva.service;

import com.prueba.civa.backendCiva.dto.request.MarcaRequest;
import com.prueba.civa.backendCiva.dto.response.MarcaResponse;
import com.prueba.civa.backendCiva.entity.Marca;
import com.prueba.civa.backendCiva.mapper.Mapper;
import com.prueba.civa.backendCiva.repository.MarcaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService{
    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public MarcaResponse addMarca(MarcaRequest request) {
        Marca marca = Marca.builder()
                .nombre(request.getNombre())
                .build();
        return Mapper.toResponse(marcaRepository.save(marca));
    }
}
