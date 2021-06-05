package cl.mgarcia.backend.repository;

import cl.mgarcia.backend.model.Observacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservacionRepository extends JpaRepository<Observacion, Integer> {
}
