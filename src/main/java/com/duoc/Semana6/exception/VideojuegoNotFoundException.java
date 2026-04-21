package com.duoc.Semana6.exception;

public class VideojuegoNotFoundException extends RuntimeException {

    public VideojuegoNotFoundException(String message) {
        super(message);
    }

    public static VideojuegoNotFoundException porId(int id) {
        return new VideojuegoNotFoundException("No se encontró el videojuego con id " + id);
    }

    public static VideojuegoNotFoundException porTitulo(String titulo) {
        return new VideojuegoNotFoundException("No se encontró el videojuego con título '" + titulo + "'");
    }
}
