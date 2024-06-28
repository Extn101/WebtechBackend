package de.htwberlin.WebTechBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {

    @Autowired
    private WatchlistRepository repo;

    public WatchlistEntry saveWatchlistEntry(WatchlistEntry entry) {
        return repo.save(entry);
    }

    public List<WatchlistEntry> getAll() {
        return (List<WatchlistEntry>) repo.findAll();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public boolean movieExistsInWatchlist(long filmId) {
        return repo.existsByFilmId(filmId);
    }
}
