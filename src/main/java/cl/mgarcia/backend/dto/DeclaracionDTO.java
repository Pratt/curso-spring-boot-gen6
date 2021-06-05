package cl.mgarcia.backend.dto;

import cl.mgarcia.backend.model.Declaracion;
import cl.mgarcia.backend.model.Item;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

public class DeclaracionDTO extends RepresentationModel implements Serializable {

    private Declaracion declaracion;
    private List<Item> items;

    public DeclaracionDTO() {
    }

    public DeclaracionDTO(Declaracion declaracion, List<Item> items) {
        this.declaracion = declaracion;
        this.items = items;
    }

    public Declaracion getDeclaracion() {
        return declaracion;
    }

    public void setDeclaraciones(Declaracion declaracion) {
        this.declaracion = declaracion;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
