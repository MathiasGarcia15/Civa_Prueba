package com.prueba.civa.backendCiva.service;

import com.prueba.civa.backendCiva.dto.request.MarcaRequest;
import com.prueba.civa.backendCiva.dto.response.MarcaResponse;

public interface MarcaService {
    MarcaResponse addMarca(MarcaRequest request);
}
