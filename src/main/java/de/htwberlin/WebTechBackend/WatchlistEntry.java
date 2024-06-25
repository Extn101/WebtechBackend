package de.htwberlin.WebTechBackend;

import jakarta.persistence.*;

@Entity
public class WatchlistEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titel;
    private int filmId;

    public WatchlistEntry() {
    }

    public WatchlistEntry(long id, String titel, int filmId) {
        this.id = id;
        this.titel = titel;
        this.filmId = filmId;
    }

    public String getTitel() {
        return titel;
    }

    public long getId() {
        return id;
    }

    public int getFilmId() {
        return filmId;
    }
}