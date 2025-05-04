package ua.opnu.organizing_exhibitions;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {
    List<Exhibition> findByStartDateBeforeAndEndDateAfter(LocalDate now1, LocalDate now2);
    List<Exhibition> findDistinctByExhibitsArtistId(Long artistId);
}
