package cl.mgarcia.backend.service;

import cl.mgarcia.backend.model.Usuario;

import java.util.Optional;

public interface UsuarioService extends ICRUD<Usuario> {

    public Usuario findOneByUsername(String username);
}
