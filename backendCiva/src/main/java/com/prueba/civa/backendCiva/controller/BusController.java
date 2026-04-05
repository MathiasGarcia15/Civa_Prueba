package com.prueba.civa.backendCiva.controller;

import com.prueba.civa.backendCiva.dto.request.BusRequest;
import com.prueba.civa.backendCiva.dto.response.BusResponse;
import com.prueba.civa.backendCiva.entity.Bus;
import com.prueba.civa.backendCiva.repository.BusRepository;
import com.prueba.civa.backendCiva.service.BusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {
    @Autowired
    BusService busService;

    @GetMapping
    public ResponseEntity<Page<BusResponse>> obtenerBuses(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size){

        return ResponseEntity.ok(busService.obtenerBuses(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusResponse> obtenerBusById(@PathVariable Long id){
        return ResponseEntity.ok(busService.obtenerBusById(id));
    }

    @PostMapping
    public ResponseEntity<BusResponse> crearUsuario(@RequestBody @Valid BusRequest request){
        BusResponse creado = busService.addBus(request);
        return ResponseEntity.created(URI.create("/bus/" + creado.getId())).body(creado);
    }

}
