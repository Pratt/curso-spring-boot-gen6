package cl.mgarcia.backend.controller;

import cl.mgarcia.backend.model.Declaracion;
import cl.mgarcia.backend.model.Observacion;
import cl.mgarcia.backend.service.ObservacionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/observacion")
public class ObservacionController {

    @Autowired
    private ObservacionService observacionService;

    @ApiOperation(value = "Obtener todas las observaciones",
            response = List.class,
            responseContainer = "Observacion")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/findAll")
    public List<Observacion> findAll() {
        return observacionService.findAll();
    }

    @ApiOperation(value = "Crear una observación",
            notes = "Se debe pasar el objeto del modelo Observación",
            response = Observacion.class,
            responseContainer = "Observacion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Observacion save(@RequestBody Observacion observacion) throws Exception {
        return observacionService.save(observacion);
    }

    @ApiOperation(value = "Modificar una observación",
            notes = "Se debe pasar el objeto del modelo Observación",
            response = Observacion.class,
            responseContainer = "Observacion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Observacion update(@RequestBody Observacion observacion) throws Exception {
        return observacionService.update(observacion);
    }
}
