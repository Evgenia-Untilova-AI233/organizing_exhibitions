package ua.opnu.organizing_exhibitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExhibitService {

    private final ExhibitRepository exhibitRepository;

    @Autowired
    public ExhibitService(ExhibitRepository exhibitRepository) {
        this.exhibitRepository = exhibitRepository;
    }

    public Exhibit addExhibit(Exhibit exhibit) {
        return exhibitRepository.save(exhibit);
    }

    public List<Exhibit> getAllExhibits() {
        return exhibitRepository.findAll();
    }

    public Exhibit updateExhibit(Long id, Exhibit exhibit) {
        Optional<Exhibit> existingExhibit = exhibitRepository.findById(id);
        if (existingExhibit.isPresent()) {
            exhibit.setId(id);
            return exhibitRepository.save(exhibit);
        } else {
            return null;
        }
    }

    public boolean deleteExhibit(Long id) {
        if (exhibitRepository.existsById(id)) {
            exhibitRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Exhibit> getExhibitsByArtist(Long artistId) {
        return exhibitRepository.findByArtistId(artistId);
    }

    public List<Exhibit> getExhibitsByExhibition(Long exhibitionId) {
        return exhibitRepository.findByExhibitionId(exhibitionId);
    }
}
