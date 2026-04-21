package com.duoc.Semana6.exception;

public class PlataformaNoValidaException extends RuntimeException {

    public PlataformaNoValidaException(String plataforma) {
        super("La plataforma '" + plataforma + "' no es válida o no tiene videojuegos registrados");
    }
}
