package com.prueba.civa.backendCiva.controller;

import com.prueba.civa.backendCiva.dto.request.MarcaRequest;
import com.prueba.civa.backendCiva.dto.response.MarcaResponse;
import com.prueba.civa.backendCiva.service.MarcaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    @PostMapping
    public ResponseEntity<MarcaResponse> crearMarca(@RequestBody @Valid MarcaRequest request){
        MarcaResponse creado = marcaService.addMarca(request);
        return ResponseEntity.created(URI.create("/marcas/" + creado.getId())).body(creado);
    }
}
