package it.marconi.verificabrizzi.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import it.marconi.verificabrizzi.domains.Film;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/films")
public class FilmController {

    private List<Film> catalogo = new ArrayList<>();

    @GetMapping
    public String mostraCatalogo(Model model) {
        model.addAttribute("films", catalogo);
        return "catalogo";
    }

  /*   @GetMapping("/nuovo")
    public String mostraFormNuovoFilm(Model model) {
        model.addAttribute("film", new Film("inserisci codice","inserisci titolo","inserisci genere",0,0));
        return "addFilm";
    }  */


    @GetMapping("/nuovo")
    public ModelAndView mostraFormNuovoFilm(Model model) {
     //   model.addAttribute("film", new Film("inserisci codice","inserisci titolo","inserisci genere",0,0));
      return new ModelAndView("addFilm").addObject(new Film("a", "a", "a", 0, 0));
        return "addFilm";
    }  

    // @PostMapping("/aggiungi")
    // public String aggiungiFilm(@ModelAttribute Film film) {
    //     catalogo.add(film);
    //     return "redirect:/films";
    // }

    @GetMapping("/{codice}")
    public String mostraDettaglioFilm(@PathVariable String codice, Model model) {
        Film film = catalogo.stream().filter(f -> f.getCodice().equals(codice)).findFirst().orElse(null);
        if (film != null) {
            model.addAttribute("film", film);
            return "dettaglioFilm";
        } else {
            return "redirect:/films";
        }
    }


    @GetMapping("/svuota")
    public String svuotaCatalogo() {
        catalogo.clear();
        return "redirect:/films";
    }
}




