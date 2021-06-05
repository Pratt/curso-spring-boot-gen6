package cl.mgarcia.backend.service.impl;

import cl.mgarcia.backend.exception.ModeloNotFoundException;
import cl.mgarcia.backend.model.Cliente;
import cl.mgarcia.backend.repository.ClienteRepository;
import cl.mgarcia.backend.service.ClienteService;
import cl.mgarcia.backend.service.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente findById(Integer id) throws Exception {
        Optional<Cliente> opt = clienteRepository.findById(id);
        if (!opt.isPresent()) {
            throw new ModeloNotFoundException("Cliente no encontrado con id: " + id);
        } else {
            return opt.get();
        }
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) throws Exception {
        ServiceUtil.<Cliente>validarModelo(cliente);
        clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) throws Exception {
        ServiceUtil.<Cliente>validarModelo(cliente);
        if (cliente.getId() == null) {
            throw new Exception("Falta el id");
        }
        Optional<Cliente> check = clienteRepository.findById(cliente.getId());
        if (!check.isPresent()) {
            throw new ModeloNotFoundException("Cliente con id " + cliente.getId() + " no existe");
        }
        clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        clienteRepository.deleteById(id);
        return true;
    }
}
