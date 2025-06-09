package com.Usuarios.demo.service;

import com.Usuarios.demo.model.Usuario;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioService {
    private final List<Usuario> usuarios = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    private final ValidacionService<String> validadorCorreo =
            correo -> correo != null && correo.contains("@");

    public List<Usuario> obtenerTodos() {
        return usuarios;
    }

    public Usuario guardar(Usuario usuario) {
        if (!validadorCorreo.validar(usuario.getCorreo())) {
            throw new IllegalArgumentException("Correo inválido");
        }

        usuario.setId(idGenerator.getAndIncrement());
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario buscarPorCorreo(String correo) {
        return usuarios.stream()
                .filter(u -> u.getCorreo().equalsIgnoreCase(correo))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
