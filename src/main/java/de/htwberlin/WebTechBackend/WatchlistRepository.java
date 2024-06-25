package de.htwberlin.WebTechBackend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepository extends JpaRepository<WatchlistEntry, Long> {
    boolean existsByFilmId(long filmId);

}
