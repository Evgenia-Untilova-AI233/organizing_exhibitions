package ua.opnu.organizing_exhibitions;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitService {

    private final ExhibitRepository exhibitRepository;

    public ExhibitService(ExhibitRepository exhibitRepository) {
        this.exhibitRepository = exhibitRepository;
    }

    public Exhibit addExhibit(Exhibit exhibit) {
        return exhibitRepository.save(exhibit);
    }

    public List<Exhibit> getAllExhibits() {
        return exhibitRepository.findAll();
    }

    public Exhibit updateExhibit(Long id, Exhibit updatedExhibit) {
        Exhibit exhibit = exhibitRepository.findById(id).orElseThrow();
        exhibit.setName(updatedExhibit.getName());
        exhibit.setDescription(updatedExhibit.getDescription());
        exhibit.setCreationYear(updatedExhibit.getCreationYear()); // Перевірте чи є цей метод в Exhibit
        exhibit.setArtist(updatedExhibit.getArtist());
        exhibit.setExhibition(updatedExhibit.getExhibition());
        return exhibitRepository.save(exhibit);
    }

    public void deleteExhibit(Long id) {
        exhibitRepository.deleteById(id);
    }

    public List<Exhibit> getExhibitsByArtist(Long artistId) {
        return exhibitRepository.findByArtistId(artistId);
    }

    public List<Exhibit> getExhibitsCreatedAfterYear(int year) {
        return exhibitRepository.findByCreationYearGreaterThan(year);
    }

    public List<Exhibit> getExhibitsNotInExhibition() {
        return exhibitRepository.findByExhibitionIsNull();
    }
}
