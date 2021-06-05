package cl.mgarcia.backend.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
@ApiModel(description = "Modelo del Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @ApiModelProperty(notes = "Nombre del cliente entre 5 y 100 caracteres")
    @Size(min = 5, max = 100, message = "Nombre del cliente entre 5 y 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotNull
    @Column(name = "rut", nullable = false)
    private Integer rut;

    @NotNull
    @ApiModelProperty(notes = "Dígito verificador del cliente es de 1 caracter")
    @Size(min = 1, max = 1, message = "Dígito verificador del cliente es de 1 caracter")
    @Column(name = "dv", nullable = false, length = 1)
    private String dv;

    @ApiModelProperty(notes = "Dirección del cliente es de máximo 200 caracteres")
    @Size(min = 0, max = 200, message = "Dirección del cliente es de máximo 200 caracteres")
    @Column(name = "direccion", length = 200)
    private String direccion;

    @ApiModelProperty(notes = "Teléfono del cliente es de máximo 20 caracteres")
    @Size(min = 0, max = 20, message = "Teléfono del cliente es de máximo 20 caracteres")
    @Column(name = "telefono", length = 20)
    private String telefono;

    @NotNull
    @ApiModelProperty(notes = "Email del cliente entre 5 y 100 caracteres")
    @Size(min = 5, max = 100, message = "Email del cliente entre 5 y 100 caracteres")
    @Column(name = "email", nullable = false, length = 100)
    private String email;

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

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
