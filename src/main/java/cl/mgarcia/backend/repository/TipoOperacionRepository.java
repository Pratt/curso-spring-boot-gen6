package cl.mgarcia.backend.repository;

import cl.mgarcia.backend.model.TipoOperacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoOperacionRepository extends JpaRepository<TipoOperacion, Integer> {

    public TipoOperacion findByNombre(String nombre);
}
