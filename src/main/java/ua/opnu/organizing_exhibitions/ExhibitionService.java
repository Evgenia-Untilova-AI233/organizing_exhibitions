package ua.opnu.organizing_exhibitions;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    public ExhibitionService(ExhibitionRepository exhibitionRepository) {
        this.exhibitionRepository = exhibitionRepository;
    }

    public Exhibition addExhibition(Exhibition exhibition) {
        return exhibitionRepository.save(exhibition);
    }

    public List<Exhibition> getAllExhibitions() {
        return exhibitionRepository.findAll();
    }

    public Exhibition updateExhibition(Long id, Exhibition updatedExhibition) {
        Exhibition exhibition = exhibitionRepository.findById(id).orElseThrow();
        exhibition.setTitle(updatedExhibition.getTitle());
        exhibition.setStartDate(updatedExhibition.getStartDate());
        exhibition.setEndDate(updatedExhibition.getEndDate());
        exhibition.setLocation(updatedExhibition.getLocation());
        return exhibitionRepository.save(exhibition);
    }

    public void deleteExhibition(Long id) {
        exhibitionRepository.deleteById(id);
    }

    public List<Exhibition> getCurrentExhibitions() {
        LocalDate now = LocalDate.now();
        return exhibitionRepository.findByStartDateBeforeAndEndDateAfter(now, now);
    }

    public List<Exhibition> getExhibitionsByArtist(Long artistId) {
        return exhibitionRepository.findDistinctByExhibitsArtistId(artistId);
    }
}
