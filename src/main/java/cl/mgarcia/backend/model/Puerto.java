package cl.mgarcia.backend.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "puerto", uniqueConstraints = {@UniqueConstraint(name = "puerto_uk_pais", columnNames = {"nombre", "pais"})})
@ApiModel(description = "Modelo de Puerto")
public class Puerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @ApiModelProperty(notes = "Nombre es entre 1 y 100 caracteres")
    @Size(min = 1, max = 100, message = "Nombre es entre 1 y 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pais", nullable = false, foreignKey = @ForeignKey(name = "puerto_fk_pais"))
    private Pais pais;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
