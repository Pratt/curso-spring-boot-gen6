package cl.mgarcia.backend.repository;

import cl.mgarcia.backend.model.Cliente;
import cl.mgarcia.backend.model.Declaracion;
import cl.mgarcia.backend.model.Pais;
import cl.mgarcia.backend.model.TipoOperacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeclaracionRepository extends JpaRepository<Declaracion, Integer> {

    public List<Declaracion> findAllByClienteId(Integer cliente);

    public List<Declaracion> findAllByTipoOperacion(TipoOperacion tipoOperacion);

    public List<Declaracion> findAllByPaisOrigen(Pais pais);

    public List<Declaracion> findAllByClienteAndPaisOrigen(Cliente cliente, Pais pais);

    @Query(nativeQuery = true,
            value = "select d.* from declaracion d " +
                    "inner join item i on i.declaracion = d.id " +
                    "where i.partida_arancelaria = :partidaArancelaria")
    public List<Declaracion> findAllByPartidaItem(@Param("partidaArancelaria") String partidaArancelaria);

    @Query("from Declaracion d inner join Item i on i.declaracion = d " +
            "where d.cliente.id = :idCliente " +
            "and i.partidaArancelaria = :partidaArancelaria")
    public List<Declaracion> findAllByIdClienteAndPartidaItem(@Param("idCliente") Integer idCliente,
                                                              @Param("partidaArancelaria") String partidaArancelaria);
}
