package com.duoc.Semana6.dto;

import com.duoc.Semana6.model.Videojuego;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VideojuegoMapper {

    public VideojuegoDTO toDTO(Videojuego videojuego) {
        return new VideojuegoDTO(
                videojuego.getId(),
                videojuego.getTitulo(),
                videojuego.getPrecio(),
                videojuego.getPlataforma(),
                videojuego.isDisponibilidad()
        );
    }

    public List<VideojuegoDTO> toDTOList(List<Videojuego> videojuegos) {
        return videojuegos.stream().map(this::toDTO).toList();
    }
}
