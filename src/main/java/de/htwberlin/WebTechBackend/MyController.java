package de.htwberlin.WebTechBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/watchlist")
@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173", "https://webtechfrontend.onrender.com/"})
public class MyController {

    @Autowired
    private WatchlistService service;

    @PostMapping()
    public WatchlistEntry createWatchlistEntry(@RequestBody WatchlistEntry entry) {
        return service.saveWatchlistEntry(entry);
    }

    @GetMapping()
    public List<WatchlistEntry> greeting() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteWatchlistEntry(@PathVariable long id) {
        service.delete(id);
    }
}
