package cl.mgarcia.backend.service.impl;

import cl.mgarcia.backend.exception.ModeloNotFoundException;
import cl.mgarcia.backend.model.Observacion;
import cl.mgarcia.backend.repository.ObservacionRepository;
import cl.mgarcia.backend.service.ObservacionService;
import cl.mgarcia.backend.service.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObservacionServiceImpl implements ObservacionService {

    @Autowired
    private ObservacionRepository observacionRepository;

    @Override
    public Observacion findById(Integer id) throws Exception {
        Optional<Observacion> opt = observacionRepository.findById(id);
        if (!opt.isPresent()) {
            throw new ModeloNotFoundException("Observación no encontrada con id: " + id);
        } else {
            return opt.get();
        }
    }

    @Override
    public List<Observacion> findAll() {
        return observacionRepository.findAll();
    }

    @Override
    public Observacion save(Observacion observacion) throws Exception {
        ServiceUtil.<Observacion>validarModelo(observacion);
        observacionRepository.save(observacion);
        return observacion;
    }

    @Override
    public Observacion update(Observacion observacion) throws Exception {
        ServiceUtil.<Observacion>validarModelo(observacion);
        if (observacion.getId() == null) {
            throw new Exception("Falta el id");
        }
        Optional<Observacion> check = observacionRepository.findById(observacion.getId());
        if (!check.isPresent()) {
            throw new ModeloNotFoundException("Observacion con id " + observacion.getId() + " no existe");
        }
        observacionRepository.save(observacion);
        return observacion;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        observacionRepository.deleteById(id);
        return true;
    }
}
