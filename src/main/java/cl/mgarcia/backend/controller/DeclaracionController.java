package cl.mgarcia.backend.controller;

import cl.mgarcia.backend.dto.DeclaracionDTO;
import cl.mgarcia.backend.model.*;
import cl.mgarcia.backend.service.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/declaracion")
public class DeclaracionController {

    @Autowired
    private DeclaracionService declaracionService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TipoOperacionService tipoOperacionService;

    @Autowired
    private PaisService paisService;

    @ApiOperation(value = "Obtener la declaración por id",
            notes = "Se debe pasar el id",
            response = Declaracion.class,
            responseContainer = "Declaracion")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "Id de la declaración", dataType = "Integer")})
    @GetMapping("/{id}")
    public Declaracion findById(@PathVariable("id") Integer id) throws Exception {
        return declaracionService.findById(id);
    }

    @ApiOperation(value = "Obtener todas las declaraciones",
            response = List.class,
            responseContainer = "Declaracion")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/findAll")
    public List<Declaracion> findAll() {
        return declaracionService.findAll();
    }

    @ApiOperation(value = "Crear una declaración",
            notes = "Se debe pasar el objeto del modelo Declaración",
            response = Declaracion.class,
            responseContainer = "Declaracion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Declaracion save(@RequestBody Declaracion declaracion) throws Exception {
        return declaracionService.save(declaracion);
    }

    @ApiOperation(value = "Modificar una declaración",
            notes = "Se debe pasar el objeto del modelo Declaración",
            response = Declaracion.class,
            responseContainer = "Declaracion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Declaracion update(@RequestBody Declaracion declaracion) throws Exception {
        return declaracionService.update(declaracion);
    }

    @ApiOperation(value = "Eliminar la declaración",
            notes = "Se debe pasar el id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "Borrado OK")})
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Integer id) throws Exception {
        Declaracion declaracion = declaracionService.findById(id);
        return declaracionService.deleteById(declaracion.getId());
    }

    @ApiOperation(value = "Obtener la declaración junto con sus ítems (DTO)",
            notes = "Se debe pasar el id de la declaración",
            response = DeclaracionDTO.class,
            responseContainer = "DeclaracionDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "Id de la declaración", dataType = "Integer")})
    @GetMapping("/conItems/{id}")
    public DeclaracionDTO findByIdConItems(@PathVariable("id") Integer id) throws Exception {
        Declaracion declaracion = declaracionService.findById(id);
        List<Item> items = itemService.findAllByDeclaracion(declaracion.getId());
        return new DeclaracionDTO(declaracion, items);
    }

    @ApiOperation(value = "Obtener todas la declaraciones de un cliente (DTO)",
            notes = "Se debe pasar el id del cliente",
            response = List.class,
            responseContainer = "DeclaracionDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @ApiImplicitParams({@ApiImplicitParam(name = "idCliente", value = "Id del cliente", dataType = "Integer")})
    @GetMapping("/findByCliente/{idCliente}")
    public List<DeclaracionDTO> findByCliente(@PathVariable("idCliente") Integer idCliente) throws Exception {
        List<DeclaracionDTO> resultado = new ArrayList<>();
        Cliente cliente = clienteService.findById(idCliente);
        List<Declaracion> declaraciones = declaracionService.findAllByCliente(cliente.getId());
        declaraciones.forEach(d -> {
            resultado.add(new DeclaracionDTO(d, itemService.findAllByDeclaracion(d.getId())));
        });
        return resultado;
    }

    @ApiOperation(value = "Obtener todas la declaraciones del tipo de operación (DTO)",
            notes = "Se debe pasar el id del tipo de operación",
            response = List.class,
            responseContainer = "DeclaracionDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @ApiImplicitParams({@ApiImplicitParam(name = "idTipoOperacion", value = "Id del tipo de operación", dataType = "Integer")})
    @GetMapping("/findByTipoOperacion/{idTipoOperacion}")
    public List<DeclaracionDTO> findByTipoOperacion(@PathVariable("idTipoOperacion") Integer idTipoOperacion) throws Exception {
        List<DeclaracionDTO> resultado = new ArrayList<>();
        TipoOperacion tipoOperacion = tipoOperacionService.findById(idTipoOperacion);
        List<Declaracion> declaraciones = declaracionService.findAllByTipoOperacion(tipoOperacion);
        declaraciones.forEach(d -> {
            resultado.add(new DeclaracionDTO(d, itemService.findAllByDeclaracion(d.getId())));
        });
        return resultado;
    }

    @ApiOperation(value = "Obtener todas la declaraciones con cierto país de origen (DTO)",
            notes = "Se debe pasar el id del país",
            response = List.class,
            responseContainer = "DeclaracionDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @ApiImplicitParams({@ApiImplicitParam(name = "idPais", value = "Id del país", dataType = "Integer")})
    @GetMapping("/findByPaisOrigen/{idPais}")
    public List<DeclaracionDTO> findByPaisOrigen(@PathVariable("idPais") Integer idPais) throws Exception {
        List<DeclaracionDTO> resultado = new ArrayList<>();
        Pais pais = paisService.findById(idPais);
        List<Declaracion> declaraciones = declaracionService.findAllByPaisOrigen(pais);
        declaraciones.forEach(d -> {
            resultado.add(new DeclaracionDTO(d, itemService.findAllByDeclaracion(d.getId())));
        });
        return resultado;
    }

    @ApiOperation(value = "Obtener todas la declaraciones de un cliente con cierto país de origen (DTO)",
            notes = "Se debe pasar el id del cliente y del país",
            response = List.class,
            responseContainer = "DeclaracionDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @ApiImplicitParams({@ApiImplicitParam(name = "idCliente", value = "Id del cliente", dataType = "Integer"),
            @ApiImplicitParam(name = "idPais", value = "Id del país", dataType = "Integer")})
    @GetMapping("/findByClienteAndPaisOrigen/{idCliente}/{idPais}")
    public List<DeclaracionDTO> findByClienteAndPaisOrigen(@PathVariable("idCliente") Integer idCliente,
                                                           @PathVariable("idPais") Integer idPais) throws Exception {
        List<DeclaracionDTO> resultado = new ArrayList<>();
        Cliente cliente = clienteService.findById(idCliente);
        Pais pais = paisService.findById(idPais);
        List<Declaracion> declaraciones = declaracionService.findAllByClienteAndPaisOrigen(cliente, pais);
        declaraciones.forEach(d -> {
            resultado.add(new DeclaracionDTO(d, itemService.findAllByDeclaracion(d.getId())));
        });
        return resultado;
    }

    @ApiOperation(value = "Obtener todas la declaraciones que tienen ítems con cierta partida arancelaria (DTO)",
            notes = "Se debe pasar la partida arancelaria",
            response = List.class,
            responseContainer = "DeclaracionDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @ApiImplicitParams({@ApiImplicitParam(name = "partidaArancelaria", value = "La partida arancelaria", dataType = "String")})
    @GetMapping("/findByPartidaItem/{partidaArancelaria}")
    public List<DeclaracionDTO> findByClienteAndPaisOrigen(@PathVariable("partidaArancelaria") String partidaArancelaria) throws Exception {
        List<DeclaracionDTO> resultado = new ArrayList<>();
        List<Declaracion> declaraciones = declaracionService.findAllByPartidaItem(partidaArancelaria);
        declaraciones.forEach(d -> {
            resultado.add(new DeclaracionDTO(d, itemService.findAllByDeclaracion(d.getId())));
        });
        return resultado;
    }

    @ApiOperation(value = "Obtener todas la declaraciones de un cliente que tienen ítems con cierta partida arancelaria (DTO)",
            notes = "Se debe pasar el id del cliente y la partida arancelaria",
            response = List.class,
            responseContainer = "DeclaracionDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @ApiImplicitParams({@ApiImplicitParam(name = "idCliente", value = "Id del cliente", dataType = "Integer"),
            @ApiImplicitParam(name = "partidaArancelaria", value = "La partida arancelaria", dataType = "String")})
    @GetMapping("/findByClienteAndPartidaItem/{idCliente}/{partidaArancelaria}")
    public List<DeclaracionDTO> findByClienteAndPartidaItem(@PathVariable("idCliente") Integer idCliente,
                                                            @PathVariable("partidaArancelaria") String partidaArancelaria) throws Exception {
        List<DeclaracionDTO> resultado = new ArrayList<>();
        Cliente cliente = clienteService.findById(idCliente);
        List<Declaracion> declaraciones = declaracionService.findByIdClienteAndPartidaItem(cliente.getId(), partidaArancelaria);
        declaraciones.forEach(d -> {
            resultado.add(new DeclaracionDTO(d, itemService.findAllByDeclaracion(d.getId())));
        });
        return resultado;
    }

}
