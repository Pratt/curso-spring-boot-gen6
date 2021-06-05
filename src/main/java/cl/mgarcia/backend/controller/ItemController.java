package cl.mgarcia.backend.controller;

import cl.mgarcia.backend.model.Declaracion;
import cl.mgarcia.backend.model.Item;
import cl.mgarcia.backend.service.DeclaracionService;
import cl.mgarcia.backend.service.ItemService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private DeclaracionService declaracionService;

    @ApiOperation(value = "Obtener todos los ítems de una declaración",
            notes = "Se debe pasar el id de la declaración",
            response = List.class,
            responseContainer = "Item")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "Id de la declaración", dataType = "Integer")})
    @GetMapping("/findAllByDeclaracion/{id}")
    public List<Item> findAllByDeclaracion(@PathVariable("id") Integer idDeclaracion) throws Exception {
        Declaracion declaracion = declaracionService.findById(idDeclaracion);
        return itemService.findAllByDeclaracion(declaracion.getId());
    }

    @ApiOperation(value = "Crear un ítem",
            notes = "Se debe pasar el objeto del modelo Ítem",
            response = Item.class,
            responseContainer = "Item")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Item save(@RequestBody Item item) throws Exception {
        return itemService.save(item);
    }

    @ApiOperation(value = "Actualizar un ítem",
            notes = "Se debe pasar el objeto del modelo Ítem",
            response = Item.class,
            responseContainer = "Item")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Item update(@RequestBody Item item) throws Exception {
        return itemService.save(item);
    }

    @ApiOperation(value = "Eliminar un ítem",
            notes = "Se debe pasar el id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "Borrado OK")})
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Integer id) throws Exception {
        return itemService.deleteById(id);
    }
}
