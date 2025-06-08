package com.Usuarios.demo.service;

@FunctionalInterface
public interface ValidacionService<T> {
    boolean validar(T t);
}
