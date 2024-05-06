package it.gravante.gravante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.gravante.gravante.domains.Film;

public interface FilmRepository extends JpaRepository<Film, Integer>{
}
