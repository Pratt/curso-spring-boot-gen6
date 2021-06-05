package cl.mgarcia.backend.repository;

import cl.mgarcia.backend.model.Aduana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AduanaRepository extends JpaRepository<Aduana, Integer> {

    public Aduana findByNombre(String nombre);
}
