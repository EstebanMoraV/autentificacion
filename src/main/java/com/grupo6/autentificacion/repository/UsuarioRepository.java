package com.grupo6.autentificacion.repository;

import java.util.Optional; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo6.autentificacion.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    // Esto es un método que busca un usuario por su nombre de usuario en la base de datos.
}
