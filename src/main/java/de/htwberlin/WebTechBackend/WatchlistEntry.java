package de.htwberlin.WebTechBackend;

import jakarta.persistence.*;

@Entity
public class WatchlistEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int length;

    public WatchlistEntry() {
    }

    public WatchlistEntry(long id, String name, int length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public int getLength() {
        return length;
    }
}