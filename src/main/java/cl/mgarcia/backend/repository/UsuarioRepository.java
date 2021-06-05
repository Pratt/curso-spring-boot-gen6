package cl.mgarcia.backend.repository;

import cl.mgarcia.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findOneByUsername(String username);
}
