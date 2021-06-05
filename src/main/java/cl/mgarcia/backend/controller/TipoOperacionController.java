package cl.mgarcia.backend.controller;

import cl.mgarcia.backend.model.TipoOperacion;
import cl.mgarcia.backend.service.TipoOperacionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoOperacion")
public class TipoOperacionController {

    @Autowired
    private TipoOperacionService tipoOperacionService;

    @ApiOperation(value = "Obtener todos los tipos de operación",
            response = List.class,
            responseContainer = "Operacion")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/findAll")
    public List<TipoOperacion> findAll() {
        return tipoOperacionService.findAll();
    }

    @ApiOperation(value = "Crear un tipo de operación",
            notes = "Se debe pasar el objeto del modelo TipoOperacion",
            response = TipoOperacion.class,
            responseContainer = "TipoOperacion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public TipoOperacion save(@RequestBody TipoOperacion tipoOperacion) throws Exception {
        return tipoOperacionService.save(tipoOperacion);
    }

    @ApiOperation(value = "Actualizar un tipo de operación",
            notes = "Se debe pasar el objeto del modelo TipoOperacion",
            response = TipoOperacion.class,
            responseContainer = "TipoOperacion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public TipoOperacion update(@RequestBody TipoOperacion tipoOperacion) throws Exception {
        return tipoOperacionService.update(tipoOperacion);
    }
}
