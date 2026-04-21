package com.duoc.Semana6.service;

import com.duoc.Semana6.dto.VideojuegoDTO;
import com.duoc.Semana6.dto.VideojuegoMapper;
import com.duoc.Semana6.exception.PlataformaNoValidaException;
import com.duoc.Semana6.exception.VideojuegoNotFoundException;
import com.duoc.Semana6.model.Videojuego;
import com.duoc.Semana6.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideojuegoService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @Autowired
    private VideojuegoMapper videojuegoMapper;

    public List<VideojuegoDTO> listarVideojuegos() {
        return videojuegoMapper.toDTOList(videojuegoRepository.findAll());
    }

    public VideojuegoDTO buscarVideojuego(int id) {
        Videojuego videojuego = videojuegoRepository.findById(id)
                .orElseThrow(() -> VideojuegoNotFoundException.porId(id));
        return videojuegoMapper.toDTO(videojuego);
    }

    public VideojuegoDTO buscarVideojuegoPorTitulo(String titulo) {
        Videojuego videojuego = videojuegoRepository.findByTituloIgnoreCase(titulo)
                .orElseThrow(() -> VideojuegoNotFoundException.porTitulo(titulo));
        return videojuegoMapper.toDTO(videojuego);
    }

    public List<VideojuegoDTO> listarVideojuegosPorPlataforma(String plataforma) {
        List<Videojuego> resultados = videojuegoRepository.findByPlataformaIgnoreCase(plataforma);
        if (resultados.isEmpty()) {
            throw new PlataformaNoValidaException(plataforma);
        }
        return videojuegoMapper.toDTOList(resultados);
    }
}
