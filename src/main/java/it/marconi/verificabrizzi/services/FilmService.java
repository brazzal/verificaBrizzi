package it.marconi.verificabrizzi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
class FilmService {

    private List<FilmService> films = new ArrayList<>();

    public List<FilmService> stampaFilms() {
        return films;
    }

    public void aggiungiFilm(FilmService film) {
        films.add(film);
    }

    public void svuotaFilm() {
        films.clear();
    }
    
}



