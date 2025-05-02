package ua.opnu.organizing_exhibitions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT l FROM Location l LEFT JOIN l.exhibitions e GROUP BY l ORDER BY COUNT(e) DESC")
    List<Location> findTopLocationsByExhibitions(); // Ми обмежимо в сервісі
}
