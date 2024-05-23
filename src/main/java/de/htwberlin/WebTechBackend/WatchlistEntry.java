package de.htwberlin.WebTechBackend;

public class WatchlistEntry {
    private String name;
    private int id;
    private int length;

    public WatchlistEntry(int id, String name, int length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }
}