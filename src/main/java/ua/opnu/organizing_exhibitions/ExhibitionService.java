package ua.opnu.organizing_exhibitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    @Autowired
    public ExhibitionService(ExhibitionRepository exhibitionRepository) {
        this.exhibitionRepository = exhibitionRepository;
    }

    public Exhibition addExhibition(Exhibition exhibition) {
        return exhibitionRepository.save(exhibition);
    }

    public List<Exhibition> getAllExhibitions() {
        return exhibitionRepository.findAll();
    }

    public Exhibition updateExhibition(Long id, Exhibition exhibition) {
        Optional<Exhibition> existingExhibition = exhibitionRepository.findById(id);
        if (existingExhibition.isPresent()) {
            exhibition.setId(id);
            return exhibitionRepository.save(exhibition);
        } else {
            return null;
        }
    }

    public boolean deleteExhibition(Long id) {
        if (exhibitionRepository.existsById(id)) {
            exhibitionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Exhibition> getExhibitionsByLocation(Long locationId) {
        return exhibitionRepository.findByLocationId(locationId);
    }
}
