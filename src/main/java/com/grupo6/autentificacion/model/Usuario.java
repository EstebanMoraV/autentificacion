package com.grupo6.autentificacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data // Genera automáticamente los métodos getters, setters, equals, hashCode y toString
@Entity // Indica que esta clase es una entidad JPA
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombreUsuario;
    private String contrasena;

}
