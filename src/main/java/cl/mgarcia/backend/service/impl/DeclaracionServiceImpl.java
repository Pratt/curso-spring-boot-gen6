package cl.mgarcia.backend.service.impl;

import cl.mgarcia.backend.exception.ModeloNotFoundException;
import cl.mgarcia.backend.model.Cliente;
import cl.mgarcia.backend.model.Declaracion;
import cl.mgarcia.backend.model.Pais;
import cl.mgarcia.backend.model.TipoOperacion;
import cl.mgarcia.backend.repository.DeclaracionRepository;
import cl.mgarcia.backend.service.DeclaracionService;
import cl.mgarcia.backend.service.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeclaracionServiceImpl implements DeclaracionService {

    @Autowired
    private DeclaracionRepository declaracionRepository;

    @Override
    public Declaracion findById(Integer id) throws Exception {
        Optional<Declaracion> opt = declaracionRepository.findById(id);
        if (!opt.isPresent()) {
            throw new ModeloNotFoundException("Declaración no encontrada con id: " + id);
        } else {
            return opt.get();
        }
    }

    @Override
    public List<Declaracion> findAllByCliente(Integer cliente) {
        return declaracionRepository.findAllByClienteId(cliente);
    }

    @Override
    public List<Declaracion> findAll() {
        return declaracionRepository.findAll();
    }

    @Override
    public Declaracion save(Declaracion declaracion) throws Exception {
        ServiceUtil.<Declaracion>validarModelo(declaracion);
        declaracionRepository.save(declaracion);
        return declaracionRepository.getById(declaracion.getId());
    }

    @Override
    public Declaracion update(Declaracion declaracion) throws Exception {
        ServiceUtil.<Declaracion>validarModelo(declaracion);
        if (declaracion.getId() == null) {
            throw new Exception("Falta el id");
        }
        Optional<Declaracion> check = declaracionRepository.findById(declaracion.getId());
        if (!check.isPresent()) {
            throw new ModeloNotFoundException("Declaración con id " + declaracion.getId() + " no existe");
        }
        declaracionRepository.save(declaracion);
        return declaracionRepository.getById(declaracion.getId());
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        declaracionRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Declaracion> findAllByTipoOperacion(TipoOperacion tipoOperacion) {
        return declaracionRepository.findAllByTipoOperacion(tipoOperacion);
    }

    @Override
    public List<Declaracion> findAllByPaisOrigen(Pais pais) {
        return declaracionRepository.findAllByPaisOrigen(pais);
    }

    @Override
    public List<Declaracion> findAllByClienteAndPaisOrigen(Cliente cliente, Pais pais) {
        return declaracionRepository.findAllByClienteAndPaisOrigen(cliente, pais);
    }

    @Override
    public List<Declaracion> findAllByPartidaItem(String partidaArancelaria) {
        return declaracionRepository.findAllByPartidaItem(partidaArancelaria);
    }

    @Override
    public List<Declaracion> findByIdClienteAndPartidaItem(Integer idCliente, String partidaArancelaria) {
        return declaracionRepository.findAllByIdClienteAndPartidaItem(idCliente, partidaArancelaria);
    }

}
