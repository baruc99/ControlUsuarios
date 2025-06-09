package com.Usuarios.demo.controller;


import com.Usuarios.demo.model.Usuario;
import com.Usuarios.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerTodos();
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    @GetMapping("/buscar")
    public Usuario buscarPorCorreo(@RequestParam String correo) {
        return usuarioService.buscarPorCorreo(correo);
    }
}
