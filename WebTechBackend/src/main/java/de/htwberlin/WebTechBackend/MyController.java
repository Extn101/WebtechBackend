package de.htwberlin.WebTechBackend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @GetMapping("/watchlist")
    public List<Watchlist> greeting() {
        Watchlist entry = new Watchlist("Movie", "Marvel", false);
        Watchlist entry1 = new Watchlist("Movie", "Star Wars", false);
        Watchlist entry2 = new Watchlist("Serie", "Star Trek", false);
        Watchlist entry3 = new Watchlist("Serie", "Fallout", false);
        Watchlist entry4 = new Watchlist("Movie", "James Bond", false);
        return List.of(entry, entry1, entry2, entry3, entry4);
    }

}