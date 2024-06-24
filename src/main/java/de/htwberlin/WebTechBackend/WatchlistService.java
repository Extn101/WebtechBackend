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

    public WatchlistEntry get(long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("No entry found with id " + id));
    }

    public List<WatchlistEntry> getAll() {
        return (List<WatchlistEntry>) repo.findAll();
    }
    public void delete(long id) {repo.deleteById(id);
    }
    public boolean movieExistsInWatchlist(long film_id) {
        return repo.existsByFilm_id(film_id);
    }
}
