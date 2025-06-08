package com.Usuarios.demo.model;

@Data // genera getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Long id;
    private String nombre;
    private String correo;
}
