package com.prueba.civa.backendCiva.service;

import com.prueba.civa.backendCiva.dto.request.BusRequest;
import com.prueba.civa.backendCiva.dto.response.BusResponse;
import com.prueba.civa.backendCiva.entity.Bus;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BusService {
    Page<BusResponse> obtenerBuses(int page, int size);
    BusResponse obtenerBusById(Long id);
    BusResponse addBus(BusRequest request);
}
