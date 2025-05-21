package com.grupo6.autentificacion.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data // Genera automáticamente los métodos getters, setters, equals, hashCode y toString
@Entity // Indica que esta clase es una entidad JPA
@Table(name = "usuarios") // Especifica el nombre de la tabla en la base de datos
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 50)
    private String nombreUsuario;

    @JsonIgnore
    @Column(nullable = false, length = 50)
    private String contrasena;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Santiago")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(nullable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Santiago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

}
