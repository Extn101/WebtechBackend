package de.htwberlin.WebTechBackend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepository extends CrudRepository<WatchlistEntry, Long>{
}
