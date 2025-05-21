package com.grupo6.autentificacion.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo6.autentificacion.DTO.LoginRequest;
import com.grupo6.autentificacion.model.Usuario;
import com.grupo6.autentificacion.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/autenticacion")
public class AutenticacionController {

    /*@Autowired
    private AutenticacionService autenticacionService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        
        String token = autenticacionService.login(request.getNombreUsuario(), request.getContrasena());
        return ResponseEntity.ok(new AuthResponse(token)); // Devuelve el token en la respuesta
    }*/


    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login2")
    public ResponseEntity<String> login2(@RequestBody LoginRequest request) {

        Optional<Usuario> usuarioOpt = usuarioRepository.findByNombreUsuario(request.getNombreUsuario());
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Usuario no encontrado"); // Devuelve un error si el usuario no existe
        }

        Usuario usuario = usuarioOpt.get();
        if (!usuario.getContrasena().equals(request.getContrasena())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta"); // Devuelve un error si la contraseña no coincide
        }

        return ResponseEntity.ok("Login exitoso"); // Devuelve una respuesta de éxito
    }

}

    /*@Data // Genera getters/setters en la clase
    class LoginRequest {
    private String nombreUsuario; // Nombre de usuario enviado desde cliente
    private String contrasena;    // Contraseña enviada desde cliente
    }

    @Data
    class AuthResponse {
    private final String token; // Token que recibe el cliente
    }*/