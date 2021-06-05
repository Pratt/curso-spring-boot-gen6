package cl.mgarcia.backend.service.impl;

import cl.mgarcia.backend.exception.ModeloNotFoundException;
import cl.mgarcia.backend.model.Item;
import cl.mgarcia.backend.repository.ItemRepository;
import cl.mgarcia.backend.service.ItemService;
import cl.mgarcia.backend.service.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item findById(Integer id) throws Exception {
        Optional<Item> opt = itemRepository.findById(id);
        if (!opt.isPresent()) {
            throw new ModeloNotFoundException("Ítem no encontrado con id: " + id);
        } else {
            return opt.get();
        }
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item save(Item item) throws Exception {
        ServiceUtil.<Item>validarModelo(item);
        itemRepository.save(item);
        return itemRepository.getById(item.getId());
    }

    @Override
    public Item update(Item item) throws Exception {
        ServiceUtil.<Item>validarModelo(item);
        if (item.getId() == null) {
            throw new Exception("Falta el id");
        }
        Optional<Item> check = itemRepository.findById(item.getId());
        if (!check.isPresent()) {
            throw new ModeloNotFoundException("Ítem con id " + item.getId() + " no existe");
        }
        itemRepository.save(item);
        return itemRepository.getById(item.getId());
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        itemRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Item> findAllByDeclaracion(Integer idDeclaracion) {
        return itemRepository.findAllByDeclaracion(idDeclaracion);
    }
}
