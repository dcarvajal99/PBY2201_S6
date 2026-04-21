package com.duoc.Semana6.controller;

import com.duoc.Semana6.dto.ApiResponse;
import com.duoc.Semana6.dto.VideojuegoDTO;
import com.duoc.Semana6.service.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping("/videojuegos")
    public ApiResponse<List<VideojuegoDTO>> listarVideojuegos() {
        List<VideojuegoDTO> videojuegos = videojuegoService.listarVideojuegos();
        return ApiResponse.ok("Listado de videojuegos obtenido correctamente", videojuegos);
    }

    @GetMapping("/videojuegos/{id}")
    public ApiResponse<VideojuegoDTO> buscarVideojuego(@PathVariable int id) {
        VideojuegoDTO videojuego = videojuegoService.buscarVideojuego(id);
        return ApiResponse.ok("Videojuego encontrado", videojuego);
    }

    @GetMapping("/videojuegos/titulo/{titulo}")
    public ApiResponse<VideojuegoDTO> buscarVideojuegoPorTitulo(@PathVariable String titulo) {
        VideojuegoDTO videojuego = videojuegoService.buscarVideojuegoPorTitulo(titulo);
        return ApiResponse.ok("Videojuego encontrado", videojuego);
    }

    @GetMapping("/videojuegos/plataforma/{plataforma}")
    public ApiResponse<List<VideojuegoDTO>> listarVideojuegosPorPlataforma(@PathVariable String plataforma) {
        List<VideojuegoDTO> videojuegos = videojuegoService.listarVideojuegosPorPlataforma(plataforma);
        return ApiResponse.ok("Videojuegos para la plataforma '" + plataforma + "'", videojuegos);
    }
}
