package cl.mgarcia.backend.repository;

import cl.mgarcia.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("from Item i where i.declaracion.id = :idDeclaracion")
    public List<Item> findAllByDeclaracion(@Param("idDeclaracion") Integer idDeclaracion);
}
