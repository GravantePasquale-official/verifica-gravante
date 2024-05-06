package it.gravante.gravante.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gravante.gravante.domains.Film;
import it.gravante.gravante.repositories.FilmRepository;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepo;
    
    public List<Film> findAll() {
        return filmRepo.findAll();
    }
}
