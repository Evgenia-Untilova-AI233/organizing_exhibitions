package ua.opnu.organizing_exhibitions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExhibitRepository extends JpaRepository<Exhibit, Long> {
    List<Exhibit> findByArtistId(Long artistId);
    List<Exhibit> findByCreationYearGreaterThan(int year);
    List<Exhibit> findByExhibitionIsNull();
}
