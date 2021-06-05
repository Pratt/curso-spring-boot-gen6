package cl.mgarcia.backend.service.impl;

import cl.mgarcia.backend.exception.ModeloNotFoundException;
import cl.mgarcia.backend.model.Aduana;
import cl.mgarcia.backend.repository.AduanaRepository;
import cl.mgarcia.backend.service.AduanaService;
import cl.mgarcia.backend.service.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AduanaServiceImpl implements AduanaService {

    @Autowired
    private AduanaRepository aduanaRepository;

    @Override
    public Aduana findById(Integer id) throws Exception {
        Optional<Aduana> opt = aduanaRepository.findById(id);
        if (!opt.isPresent()) {
            throw new ModeloNotFoundException("Aduana no encontrada con id: " + id);
        } else {
            return opt.get();
        }
    }

    @Override
    public List<Aduana> findAll() {
        return aduanaRepository.findAll();
    }

    @Override
    public Aduana save(Aduana aduana) throws Exception {
        ServiceUtil.<Aduana>validarModelo(aduana);
        Aduana check = aduanaRepository.findByNombre(aduana.getNombre());
        if (check != null) {
            throw new Exception("Aduana ya existe: " + aduana.getNombre());
        }
        aduanaRepository.save(aduana);
        return aduana;
    }

    @Override
    public Aduana update(Aduana aduana) throws Exception {
        ServiceUtil.<Aduana>validarModelo(aduana);
        if (aduana.getId() == null) {
            throw new Exception("Falta el id");
        }
        Optional<Aduana> check = aduanaRepository.findById(aduana.getId());
        if (!check.isPresent()) {
            throw new ModeloNotFoundException("Aduana con id " + aduana.getId() + " no existe");
        }
        aduanaRepository.save(aduana);
        return aduana;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        aduanaRepository.deleteById(id);
        return true;
    }
}
