package it.gravante.gravante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gravante.gravante.domains.Film;
import it.gravante.gravante.domains.FilmForm;
import it.gravante.gravante.repositories.FilmRepository;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepo;
    
    public List<Film> findAll() {
        return filmRepo.findAll();
    }

    public Optional<Film> findByCodice(int codice){
        return filmRepo.findById(codice);
    }

    public Film save(FilmForm filmForm){
        return filmRepo.save(map(filmForm));
    }

    public void deleteByCodice(int codice){
        filmRepo.deleteById(codice);
    }

    private Film map(FilmForm ff){
        Film film = new Film();

        film.setAnno(ff.getAnno());
        film.setGenere(ff.getGenere());
        film.setTitolo(ff.getTitolo());
        film.setVoto(ff.getVoto());

        return film;
    }
}
