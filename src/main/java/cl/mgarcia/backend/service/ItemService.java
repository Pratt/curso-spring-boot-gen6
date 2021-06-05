package cl.mgarcia.backend.service;

import cl.mgarcia.backend.model.Item;

import java.util.List;

public interface ItemService extends ICRUD<Item> {

    public List<Item> findAllByDeclaracion(Integer idDeclaracion);
}
