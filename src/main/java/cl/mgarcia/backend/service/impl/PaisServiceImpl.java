package cl.mgarcia.backend.service.impl;

import cl.mgarcia.backend.exception.ModeloNotFoundException;
import cl.mgarcia.backend.model.Pais;
import cl.mgarcia.backend.repository.PaisRepository;
import cl.mgarcia.backend.service.PaisService;
import cl.mgarcia.backend.service.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public Pais findById(Integer id) throws Exception {
        Optional<Pais> opt = paisRepository.findById(id);
        if (!opt.isPresent()) {
            throw new ModeloNotFoundException("País no encontrado con id: " + id);
        } else {
            return opt.get();
        }
    }

    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @Override
    public Pais save(Pais pais) throws Exception {
        ServiceUtil.<Pais>validarModelo(pais);
        Pais check = paisRepository.findByNombre(pais.getNombre());
        if (check != null) {
            throw new Exception("País ya existe: " + pais.getNombre());
        }
        paisRepository.save(pais);
        return pais;
    }

    @Override
    public Pais update(Pais pais) throws Exception {
        ServiceUtil.<Pais>validarModelo(pais);
        if (pais.getId() == null) {
            throw new Exception("Falta el id");
        }
        Optional<Pais> check = paisRepository.findById(pais.getId());
        if (!check.isPresent()) {
            throw new ModeloNotFoundException("País con id " + pais.getId() + " no existe");
        }
        paisRepository.save(pais);
        return pais;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        paisRepository.deleteById(id);
        return true;
    }
}
