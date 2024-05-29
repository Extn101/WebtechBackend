package de.htwberlin.WebTechBackend;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/watchlist")
@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173", "https://webtechfrontend.onrender.com/"})
public class MyController {

    WatchlistService service;

    @PostMapping()
    public WatchlistEntry createWatchlistEntry(@RequestBody WatchlistEntry entry) {
        return service.saveWatchlistEntry(entry);
    }

    @GetMapping()
    public List<WatchlistEntry> greeting() {
        WatchlistEntry entry = new WatchlistEntry(1, "Interstellar", 169);
        WatchlistEntry entry1 = new WatchlistEntry(2, "Marley und Ich", 120);
        WatchlistEntry entry2 = new WatchlistEntry(3, "No Time to Die", 163);
        WatchlistEntry entry3 = new WatchlistEntry(4, "Skyfall", 143);
        WatchlistEntry entry4 = new WatchlistEntry(5, "Dune", 155);

        return List.of(entry, entry1, entry2, entry3, entry4);
    }

}