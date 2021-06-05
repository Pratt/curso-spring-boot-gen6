package cl.mgarcia.backend.service.impl;

import cl.mgarcia.backend.exception.ModeloNotFoundException;
import cl.mgarcia.backend.model.TipoOperacion;
import cl.mgarcia.backend.repository.TipoOperacionRepository;
import cl.mgarcia.backend.service.ServiceUtil;
import cl.mgarcia.backend.service.TipoOperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoOperacionServiceImpl implements TipoOperacionService {

    @Autowired
    private TipoOperacionRepository tipoOperacionRepository;

    @Override
    public TipoOperacion findById(Integer id) throws Exception {
        Optional<TipoOperacion> opt = tipoOperacionRepository.findById(id);
        if (!opt.isPresent()) {
            throw new ModeloNotFoundException("Tipo de operación no encontrado con id: " + id);
        } else {
            return opt.get();
        }
    }

    @Override
    public List<TipoOperacion> findAll() {
        return tipoOperacionRepository.findAll();
    }

    @Override
    public TipoOperacion save(TipoOperacion tipoOperacion) throws Exception {
        ServiceUtil.<TipoOperacion>validarModelo(tipoOperacion);
        TipoOperacion check = tipoOperacionRepository.findByNombre(tipoOperacion.getNombre());
        if (check != null) {
            throw new Exception("Tipo de operación ya existe: " + tipoOperacion.getNombre());
        }
        tipoOperacionRepository.save(tipoOperacion);
        return tipoOperacion;
    }

    @Override
    public TipoOperacion update(TipoOperacion tipoOperacion) throws Exception {
        ServiceUtil.<TipoOperacion>validarModelo(tipoOperacion);
        if (tipoOperacion.getId() == null) {
            throw new Exception("Falta el id");
        }
        Optional<TipoOperacion> check = tipoOperacionRepository.findById(tipoOperacion.getId());
        if (!check.isPresent()) {
            throw new ModeloNotFoundException("Tipo de operación con id " + tipoOperacion.getId() + " no existe");
        }
        tipoOperacionRepository.save(tipoOperacion);
        return tipoOperacion;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        tipoOperacionRepository.deleteById(id);
        return true;
    }
}
