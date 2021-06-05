package cl.mgarcia.backend.controller;

import cl.mgarcia.backend.model.Cliente;
import cl.mgarcia.backend.service.ClienteService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @ApiOperation(value = "Obtener el cliente por id",
            notes = "Se debe pasar el id",
            response = Cliente.class,
            responseContainer = "Cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "Id del cliente", dataType = "Integer")})
    @GetMapping("/{id}")
    public Cliente findById(@PathVariable("id") Integer id) throws Exception {
        return clienteService.findById(id);
    }

    @ApiOperation(value = "Obtener todos los clientes",
            response = List.class,
            responseContainer = "Cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/findAll")
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @ApiOperation(value = "Ingresar un cliente",
            notes = "Se debe pasar el objeto del modelo cliente",
            response = Cliente.class,
            responseContainer = "Cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) throws Exception {
        return clienteService.save(cliente);
    }

    @ApiOperation(value = "Actualizar un cliente",
            notes = "Se debe pasar el objeto del modelo cliente",
            response = Cliente.class,
            responseContainer = "Cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Cliente update(@RequestBody Cliente cliente) throws Exception {
        return clienteService.update(cliente);
    }
}
