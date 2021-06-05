package cl.mgarcia.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "item")
@ApiModel(description = "Modelo de Ítem")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "declaracion", nullable = false, foreignKey = @ForeignKey(name = "item_fk_declaracion"))
    private Declaracion declaracion;

    @NotNull
    @Column(name = "nro_item", nullable = false)
    private Integer nroItem;

    @NotNull
    @NotEmpty
    @ApiModelProperty(notes = "El nombre de la mercancía es entre 1 y 270 caracteres")
    @Size(min = 1, max = 270, message = "El nombre de la mercancía es entre 1 y 270 caracteres")
    @Column(name = "nombre_mercancia", nullable = false)
    private String nombreMercancia;

    @NotNull
    @NotEmpty
    @ApiModelProperty(notes = "La partida arancelaria es de 8 caracteres")
    @Size(min = 8, max = 8, message = "La partida arancelaria es de 8 caracteres")
    @Column(name = "partida_arancelaria", nullable = false)
    private String partidaArancelaria;

    @NotNull
    @PositiveOrZero
    @Column(name = "valor_factura", nullable = false)
    private Double valorFactura;

    @PositiveOrZero
    @Column(name = "kilos_brutos")
    private Double kilosBrutos;

    @JsonManagedReference
    @OneToMany(mappedBy = "item", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Observacion> observaciones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Declaracion getDeclaracion() {
        return declaracion;
    }

    public void setDeclaracion(Declaracion declaracion) {
        this.declaracion = declaracion;
    }

    public Integer getNroItem() {
        return nroItem;
    }

    public void setNroItem(Integer nroItem) {
        this.nroItem = nroItem;
    }

    public String getNombreMercancia() {
        return nombreMercancia;
    }

    public void setNombreMercancia(String nombreMercancia) {
        this.nombreMercancia = nombreMercancia;
    }

    public String getPartidaArancelaria() {
        return partidaArancelaria;
    }

    public void setPartidaArancelaria(String partidaArancelaria) {
        this.partidaArancelaria = partidaArancelaria;
    }

    public Double getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(Double valorFactura) {
        this.valorFactura = valorFactura;
    }

    public Double getKilosBrutos() {
        return kilosBrutos;
    }

    public void setKilosBrutos(Double kilosBrutos) {
        this.kilosBrutos = kilosBrutos;
    }

    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
    }
}
