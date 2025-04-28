package ua.opnu.organizing_exhibitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExhibitionEntryService {

    private final ExhibitionEntryRepository exhibitionEntryRepository;

    @Autowired
    public ExhibitionEntryService(ExhibitionEntryRepository exhibitionEntryRepository) {
        this.exhibitionEntryRepository = exhibitionEntryRepository;
    }

    // Додати запис до виставки
    public ExhibitionEntry addExhibitionEntry(ExhibitionEntry exhibitionEntry) {
        return exhibitionEntryRepository.save(exhibitionEntry);
    }

    // Оновити запис
    public ExhibitionEntry updateExhibitionEntry(Long id, ExhibitionEntry exhibitionEntry) {
        Optional<ExhibitionEntry> existingEntry = exhibitionEntryRepository.findById(id);
        if (existingEntry.isPresent()) {
            exhibitionEntry.setId(id); // Призначаємо id з шляху URL
            return exhibitionEntryRepository.save(exhibitionEntry);
        } else {
            return null;
        }
    }

    // Видалити запис
    public boolean deleteExhibitionEntry(Long id) {
        if (exhibitionEntryRepository.existsById(id)) {
            exhibitionEntryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Отримати всі записи по виставці
    public List<ExhibitionEntry> getExhibitionEntriesByExhibition(Exhibition exhibition) {
        return exhibitionEntryRepository.findByExhibition(exhibition);
    }

    // Отримати всі записи по художнику
    public List<ExhibitionEntry> getExhibitionEntriesByArtist(Artist artist) {
        return exhibitionEntryRepository.findByArtist(artist);
    }

    // Отримати всі записи по експонату
    public List<ExhibitionEntry> getExhibitionEntriesByExhibit(Exhibit exhibit) {
        return exhibitionEntryRepository.findByExhibit(exhibit);
    }
}
