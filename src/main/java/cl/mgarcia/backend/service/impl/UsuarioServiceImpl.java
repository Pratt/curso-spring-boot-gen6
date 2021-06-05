package cl.mgarcia.backend.service.impl;

import cl.mgarcia.backend.model.Usuario;
import cl.mgarcia.backend.repository.UsuarioRepository;
import cl.mgarcia.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findById(Integer id) throws Exception {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuario;
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuario;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        usuarioRepository.deleteById(id);
        return false;
    }

    @Override
    public Usuario findOneByUsername(String username) {
        return usuarioRepository.findOneByUsername(username);
    }
}
