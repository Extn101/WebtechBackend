package de.htwberlin.WebTechBackend;

import jakarta.persistence.*;

@Entity
public class WatchlistEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titel;
    private int film_id;

    public WatchlistEntry() {
    }

    public WatchlistEntry(long id, String titel, int film_id) {
        this.id = id;
        this.titel = titel;
        this.film_id = film_id;
    }

    public String getTitel() {
        return titel;
    }

    public long getId() {
        return id;
    }

    public int getFilm_id() {
        return film_id;
    }
}