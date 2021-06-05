package cl.mgarcia.backend.controller;

import cl.mgarcia.backend.model.Usuario;
import cl.mgarcia.backend.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ApiOperation(value = "Obtener todos los usuarios",
            response = List.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/findAll")
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @ApiOperation(value = "Ingresar un usuario",
            notes = "Se debe pasar el objeto del modelo Usuario",
            response = Usuario.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) throws Exception {
        return usuarioService.save(usuario);
    }

    @ApiOperation(value = "Modificar un usuario",
            notes = "Se debe pasar el objeto del modelo Usuario",
            response = Usuario.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) throws Exception {
        return usuarioService.update(usuario);
    }
}
