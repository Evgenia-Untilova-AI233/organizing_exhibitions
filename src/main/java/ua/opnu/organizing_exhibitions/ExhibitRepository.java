package ua.opnu.organizing_exhibitions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExhibitRepository extends JpaRepository<Exhibit, Long> {

    List<Exhibit> findByArtistId(Long artistId); // ← ДОДАЙТЕ ЦЕ

    List<Exhibit> findByExhibitionId(Long exhibitionId);

    List<Exhibit> findByCreationYearGreaterThan(int year);

    List<Exhibit> findByExhibitionIsNull();
    @Query("SELECT e.artist, COUNT(e) FROM Exhibit e GROUP BY e.artist")
    List<Object[]> countExhibitionsByArtist();
}
