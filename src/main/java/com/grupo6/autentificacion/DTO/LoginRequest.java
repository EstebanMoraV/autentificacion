package com.grupo6.autentificacion.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String nombreUsuario;
    private String contrasena;

}
