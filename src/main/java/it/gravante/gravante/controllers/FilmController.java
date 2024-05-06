package it.gravante.gravante.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.gravante.gravante.domains.Film;
import it.gravante.gravante.services.FilmService;

@Controller
@RequestMapping("/films")
public class FilmController {
    @Autowired //service per db
    private FilmService filmService;
    
    @GetMapping()
    public ModelAndView example() {
        List<Film> films = filmService.findAll();
        return new ModelAndView("films").addObject("films", films);
    }
}


