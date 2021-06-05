package cl.mgarcia.backend.service;

import cl.mgarcia.backend.model.Cliente;
import cl.mgarcia.backend.model.Declaracion;
import cl.mgarcia.backend.model.Pais;
import cl.mgarcia.backend.model.TipoOperacion;

import java.util.List;

public interface DeclaracionService extends ICRUD<Declaracion> {

    public Declaracion findById(Integer id) throws Exception;

    public List<Declaracion> findAllByCliente(Integer cliente);

    public List<Declaracion> findAll();

    public List<Declaracion> findAllByTipoOperacion(TipoOperacion tipoOperacion);

    public List<Declaracion> findAllByPaisOrigen(Pais pais);

    public List<Declaracion> findAllByClienteAndPaisOrigen(Cliente cliente, Pais pais);

    public List<Declaracion> findAllByPartidaItem(String partidaArancelaria);

    public List<Declaracion> findByIdClienteAndPartidaItem(Integer idCliente, String partidaArancelaria);
}
