package cl.mgarcia.backend.controller;

import cl.mgarcia.backend.model.Aduana;
import cl.mgarcia.backend.service.AduanaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aduana")
public class AduanaController {

    @Autowired
    private AduanaService aduanaService;

    @ApiOperation(value = "Obtener el listado de Aduanas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @GetMapping("/findAll")
    public List<Aduana> findAll() {
        return aduanaService.findAll();
    }

    @ApiOperation(value = "Ingresar una Aduana",
            notes = "Se debe pasar el objeto del modelo Aduana",
            response = Aduana.class,
            responseContainer = "Aduana")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Aduana save(@RequestBody Aduana aduana) throws Exception {
        return aduanaService.save(aduana);
    }

    @ApiOperation(value = "Actualizar una Aduana",
            notes = "Se debe pasar el objeto del modelo Aduana",
            response = Aduana.class,
            responseContainer = "Aduana")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Aduana update(@RequestBody Aduana aduana) throws Exception {
        return aduanaService.update(aduana);
    }
}
