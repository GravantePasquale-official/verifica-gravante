package it.gravante.gravante.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.gravante.gravante.domains.Film;
import it.gravante.gravante.domains.FilmForm;
import it.gravante.gravante.domains.Filtro;
import it.gravante.gravante.services.FilmService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/films")
public class FilmController {
    @Autowired //service per db
    private FilmService filmService;
    
    @GetMapping()
    public ModelAndView mostraFilm() {
        List<Film> films = filmService.findAll();
        return new ModelAndView("films").addAllObjects(Map.of("films", films, "filtro", new Filtro()));
    }

    @GetMapping("/nuovo")
    public ModelAndView aggiungiFilm() {
        return new ModelAndView("film-aggiungi").addObject(new FilmForm());
    }

    @PostMapping("/nuovo")
    public ModelAndView aggiungiFilm(
        @ModelAttribute @Validated FilmForm filmForm,
        BindingResult br
    ) {
        if (br.hasErrors())
            return new ModelAndView("film-aggiungi");
            
        Film film = filmService.save(filmForm);

        return new ModelAndView("redirect:/films/"+film.getCodice());
    }

    @GetMapping("/{codice}")
    public ModelAndView filmRecap(@PathVariable int codice) {
        Optional<Film> film = filmService.findByCodice(codice);

        if(!film.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trovato");
        
        return new ModelAndView("film-recap").addObject("film", film.get());
    }

    @GetMapping(params = "delete")
    public ModelAndView eliminaFilm(@RequestParam String delete) {
        if(delete!=null && !delete.isEmpty() && !delete.isBlank())
            filmService.deleteByCodice(Integer.parseInt(delete));

        return new ModelAndView("redirect:/films");
    }

    @GetMapping(params = "filtro")
    public ModelAndView filtraFilm(@RequestParam String filtro) {
        if(filtro==null || filtro.isEmpty() || filtro.isBlank())
            return new ModelAndView("redirect:/films");

        List<Film> films = filmService.findByTitolo(filtro);
        return new ModelAndView("films").addAllObjects(Map.of("films", films, "filtro", new Filtro()));

    }

    
    
    
    
}


