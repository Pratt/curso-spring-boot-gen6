package cl.mgarcia.backend.repository;

import cl.mgarcia.backend.model.Puerto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuertoRepository extends JpaRepository<Puerto, Integer> {

    public Puerto findByNombre(String nombre);
}
