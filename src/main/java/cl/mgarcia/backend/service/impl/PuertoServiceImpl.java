package cl.mgarcia.backend.service.impl;

import cl.mgarcia.backend.exception.ModeloNotFoundException;
import cl.mgarcia.backend.model.Puerto;
import cl.mgarcia.backend.repository.PuertoRepository;
import cl.mgarcia.backend.service.PuertoService;
import cl.mgarcia.backend.service.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuertoServiceImpl implements PuertoService {

    @Autowired
    private PuertoRepository puertoRepository;

    @Override
    public Puerto findById(Integer id) throws Exception {
        Optional<Puerto> opt = puertoRepository.findById(id);
        if (!opt.isPresent()) {
            throw new ModeloNotFoundException("Puerto no encontrado con id: " + id);
        } else {
            return opt.get();
        }
    }

    @Override
    public List<Puerto> findAll() {
        return puertoRepository.findAll();
    }

    @Override
    public Puerto save(Puerto puerto) throws Exception {
        ServiceUtil.<Puerto>validarModelo(puerto);
        Puerto check = puertoRepository.findByNombre(puerto.getNombre());
        if (check != null) {
            throw new Exception("Puerto ya existe: " + puerto.getNombre());
        }
        puertoRepository.save(puerto);
        return puerto;
    }

    @Override
    public Puerto update(Puerto puerto) throws Exception {
        ServiceUtil.<Puerto>validarModelo(puerto);
        if (puerto.getId() == null) {
            throw new Exception("Falta el id");
        }
        Optional<Puerto> check = puertoRepository.findById(puerto.getId());
        if (!check.isPresent()) {
            throw new ModeloNotFoundException("Puerto con id " + puerto.getId() + " no existe");
        }
        puertoRepository.save(puerto);
        return puerto;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        puertoRepository.deleteById(id);
        return true;
    }
}
