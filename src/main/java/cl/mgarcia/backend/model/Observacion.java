package cl.mgarcia.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "observacion")
@ApiModel(description = "Modelo de Observación")
public class Observacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "item", nullable = false, foreignKey = @ForeignKey(name = "observacion_fk_item"))
    private Item item;

    @NotNull
    @Column(name = "codigo", nullable = false)
    private Integer codigo;

    @NotNull
    @ApiModelProperty(notes = "El valor de la observación es entre 1 y 30 caracteres")
    @Size(min = 1, max = 30, message = "El valor de la observación es entre 1 y 30 caracteres")
    @Column(name = "valor", nullable = false, length = 30)
    private String valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
