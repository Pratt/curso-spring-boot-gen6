package cl.mgarcia.backend.repository;

import cl.mgarcia.backend.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Integer> {

    public Pais findByNombre(String nombre);
}
