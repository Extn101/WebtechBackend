package de.htwberlin.WebTechBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequestMapping("/watchlist")
@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173", "https://webtechfrontend.onrender.com/"})
public class MyController {

    @Autowired
    private WatchlistService service;



    @GetMapping()
    public List<WatchlistEntry> greeting() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteWatchlistEntry(@PathVariable long id) {
        service.delete(id);
    }
    @PostMapping()
    public ResponseEntity<?> createWatchlistEntry(@RequestBody WatchlistEntry entry) {
        boolean exists = service.movieExistsInWatchlist(entry.getFilmId());
        if (exists) {
            // Return a 409 Conflict status with a message if the movie is already in the watchlist
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Movie already exists in the watchlist");
        }
        // Return a 200 OK status with the saved watchlist entry if it was successfully added
        return ResponseEntity.ok(service.saveWatchlistEntry(entry));
    }
}
