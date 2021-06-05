package cl.mgarcia.backend.controller;

import cl.mgarcia.backend.model.Declaracion;
import cl.mgarcia.backend.model.Pais;
import cl.mgarcia.backend.service.PaisService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @ApiOperation(value = "Obtener todos los Países",
            response = List.class,
            responseContainer = "Pais")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/findAll")
    public List<Pais> findAll() {
        return paisService.findAll();
    }

    @ApiOperation(value = "Crear un país",
            notes = "Se debe pasar el objeto del modelo País",
            response = Pais.class,
            responseContainer = "Pais")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Pais save(@RequestBody Pais pais) throws Exception {
        return paisService.save(pais);
    }

    @ApiOperation(value = "Modificar un país",
            notes = "Se debe pasar el objeto del modelo País",
            response = Pais.class,
            responseContainer = "Pais")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Pais update(@RequestBody Pais pais) throws Exception {
        return paisService.update(pais);
    }
}
