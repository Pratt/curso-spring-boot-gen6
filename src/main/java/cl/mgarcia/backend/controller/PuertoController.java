package cl.mgarcia.backend.controller;

import cl.mgarcia.backend.model.Declaracion;
import cl.mgarcia.backend.model.Puerto;
import cl.mgarcia.backend.service.PuertoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/puerto")
public class PuertoController {

    @Autowired
    private PuertoService puertoService;

    @ApiOperation(value = "Obtener todos los Puertos",
            response = List.class,
            responseContainer = "Puerto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/findAll")
    public List<Puerto> findAll() {
        return puertoService.findAll();
    }

    @ApiOperation(value = "Crear un puerto",
            notes = "Se debe pasar el objeto del modelo Puerto",
            response = Puerto.class,
            responseContainer = "Puerto")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Puerto save(@RequestBody Puerto puerto) throws Exception {
        return puertoService.save(puerto);
    }

    @ApiOperation(value = "Modificar un puerto",
            notes = "Se debe pasar el objeto del modelo Puerto",
            response = Puerto.class,
            responseContainer = "Puerto")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Puerto update(@RequestBody Puerto puerto) throws Exception {
        return puertoService.update(puerto);
    }
}
