package ua.opnu.organizing_exhibitions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExhibitionEntryRepository extends JpaRepository<ExhibitionEntry, Long> {
    List<ExhibitionEntry> findByExhibition(Exhibition exhibition);
    List<ExhibitionEntry> findByArtist(Artist artist);
    List<ExhibitionEntry> findByExhibit(Exhibit exhibit);
}
