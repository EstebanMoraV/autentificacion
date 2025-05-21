package com.grupo6.autentificacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo6.autentificacion.model.Usuario;
import com.grupo6.autentificacion.repository.UsuarioRepository;

@Service
public class ImplementacionService implements AutenticacionService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    // Buscará el usuario por nombre de usuario
    public String login(String nombreUsuario, String contrasena) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        //Valida la contraseña
        if(!usuario.getContrasena().equals(contrasena)){
            throw new RuntimeException("Contraseña incorrecta");
        }

        //Genera el token
        return jwtUtils.generarToken(usuario);
    }
        

}
