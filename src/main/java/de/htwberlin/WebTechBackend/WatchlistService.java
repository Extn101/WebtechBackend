package de.htwberlin.WebTechBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
