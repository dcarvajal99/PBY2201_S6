package com.duoc.Semana6.repository;

import com.duoc.Semana6.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {

    Optional<Videojuego> findByTituloIgnoreCase(String titulo);

    List<Videojuego> findByPlataformaIgnoreCase(String plataforma);
}
