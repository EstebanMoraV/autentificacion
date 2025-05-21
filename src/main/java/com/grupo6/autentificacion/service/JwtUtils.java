package com.grupo6.autentificacion.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.grupo6.autentificacion.model.Usuario; // Importa la anotación Component de Spring

import io.jsonwebtoken.Jwts; // Importa la biblioteca JJWT para crear y verificar JWTs
import io.jsonwebtoken.SignatureAlgorithm; // Importa el algoritmo de firma HS512 de JJWT

@Component // Indica que esta clase es un componente de Spring
public class JwtUtils {
    private final String SECRET_KEY = "Secreto123"; // Esta es la clave secreta para firmar el JWT

    @SuppressWarnings("deprecation") // Suprime advertencias de deprecación
    public String generarToken(Usuario usuario) {
        return Jwts.builder()                               // Construye el JWT
                   .setSubject(usuario.getNombreUsuario())  // Asigna el nombre de usuario como asunto
                   .setIssuedAt(new Date())                 // Fecha de emisión: ahora
                   .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // Expira en 1 hora
                   .signWith(SignatureAlgorithm.HS512, SECRET_KEY) // Firma el token con HS512 y la clave secreta (deprecada)
                   .compact();  
    }

}
