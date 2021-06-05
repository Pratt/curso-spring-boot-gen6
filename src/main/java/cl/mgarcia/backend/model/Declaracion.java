package cl.mgarcia.backend.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "declaracion")
@ApiModel(description = "Modelo de la Declaración")
public class Declaracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_operacion", nullable = false, foreignKey = @ForeignKey(name = "declaracion_fk_tipo_operacion"))
    private TipoOperacion tipoOperacion;

    @ApiModelProperty(notes = "Número de aceptación es de 16 caracteres")
    @Size(min = 16, max = 16, message = "Número de aceptación es de 16 caracteres")
    @Column(name = "numero_aceptacion", length = 16)
    private String numeroAceptacion;

    @Column(name = "fecha_aceptacion")
    private Date fechaAceptacion;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "aduana", nullable = false, foreignKey = @ForeignKey(name = "declaracion_fk_aduana"))
    private Aduana aduana;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false, foreignKey = @ForeignKey(name = "declaracion_fk_cliente"))
    private Cliente cliente;

    @NotNull
    @Min(value = 0, message = "Valor factura mínimo 0")
    @Column(name = "valor_factura", nullable = false)
    private Double valorFactura;

    @NotNull
    @Min(value = 0, message = "Valor fob mínimo 0")
    @Column(name = "valor_fob", nullable = false)
    private Double valorFob;

    @NotNull
    @Min(value = 0, message = "Valor flete mínimo 0")
    @Column(name = "valor_flete", nullable = false)
    private Double valorFlete;

    @NotNull
    @Min(value = 0, message = "Valor seguro mínimo 0")
    @Column(name = "valor_seguro", nullable = false)
    private Double valorSeguro;

    @NotNull
    @Min(value = 0, message = "Valor cif mínimo 0")
    @Column(name = "valor_cif", nullable = false)
    private Double valorCif;

    @ApiModelProperty(notes = "Observaciones del Banco Central máximo 210 caracteres")
    @Size(min = 0, max = 210, message = "Observaciones del Banco Central máximo 210 caracteres")
    @Column(name = "observacion_banco_central")
    private String observacionBancoCentral;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pais_origen", nullable = false, foreignKey = @ForeignKey(name = "declaracion_fk_pais_origen"))
    private Pais paisOrigen;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "puerto_origen", nullable = false, foreignKey = @ForeignKey(name = "declaracion_fk_puerto_origen"))
    private Puerto puertoOrigen;

    @Column(name = "fecha_creado", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechaCreado;

    /*@OneToMany(mappedBy = "declaracion", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Item> items;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getNumeroAceptacion() {
        return numeroAceptacion;
    }

    public void setNumeroAceptacion(String numeroAceptacion) {
        this.numeroAceptacion = numeroAceptacion;
    }

    public Date getFechaAceptacion() {
        return fechaAceptacion;
    }

    public void setFechaAceptacion(Date fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
    }

    public Aduana getAduana() {
        return aduana;
    }

    public void setAduana(Aduana aduana) {
        this.aduana = aduana;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(Double valorFactura) {
        this.valorFactura = valorFactura;
    }

    public Double getValorFob() {
        return valorFob;
    }

    public void setValorFob(Double valorFob) {
        this.valorFob = valorFob;
    }

    public Double getValorFlete() {
        return valorFlete;
    }

    public void setValorFlete(Double valorFlete) {
        this.valorFlete = valorFlete;
    }

    public Double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(Double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public Double getValorCif() {
        return valorCif;
    }

    public void setValorCif(Double valorCif) {
        this.valorCif = valorCif;
    }

    public String getObservacionBancoCentral() {
        return observacionBancoCentral;
    }

    public void setObservacionBancoCentral(String observacionBancoCentral) {
        this.observacionBancoCentral = observacionBancoCentral;
    }

    public Pais getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(Pais paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public Puerto getPuertoOrigen() {
        return puertoOrigen;
    }

    public void setPuertoOrigen(Puerto puertoOrigen) {
        this.puertoOrigen = puertoOrigen;
    }

    public Date getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    /*public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }*/
}
