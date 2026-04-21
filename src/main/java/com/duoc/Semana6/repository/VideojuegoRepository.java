package com.duoc.Semana6.repository;

import com.duoc.Semana6.model.Videojuego;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VideojuegoRepository {

    private final List<Videojuego> videojuegos = new ArrayList<>();

    @PostConstruct
    public void init() {
        videojuegos.add(new Videojuego(1, "The Legend of Zelda: Breath of the Wild", 45000, "Nintendo Switch", true));
        videojuegos.add(new Videojuego(2, "God of War Ragnarok", 55000, "PlayStation 5", true));
        videojuegos.add(new Videojuego(3, "Halo Infinite", 40000, "Xbox Series X", false));
        videojuegos.add(new Videojuego(4, "Elden Ring", 50000, "PC", true));
        videojuegos.add(new Videojuego(5, "Super Mario Odyssey", 35000, "Nintendo Switch", true));
        videojuegos.add(new Videojuego(6, "Cyberpunk 2077", 30000, "PC", true));
        videojuegos.add(new Videojuego(7, "Spider-Man 2", 60000, "PlayStation 5", false));
    }

    public List<Videojuego> findAll() {
        return videojuegos;
    }

    public Optional<Videojuego> findById(int id) {
        return videojuegos.stream()
                .filter(v -> v.getId() == id)
                .findFirst();
    }

    public Optional<Videojuego> findByTitulo(String titulo) {
        return videojuegos.stream()
                .filter(v -> v.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }

    public List<Videojuego> findByPlataforma(String plataforma) {
        return videojuegos.stream()
                .filter(v -> v.getPlataforma().equalsIgnoreCase(plataforma))
                .toList();
    }
}
