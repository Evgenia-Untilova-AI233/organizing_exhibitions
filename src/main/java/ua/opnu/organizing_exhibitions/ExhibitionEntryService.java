package ua.opnu.organizing_exhibitions;

import org.springframework.stereotype.Service;

@Service
public class ExhibitionEntryService {

    private final ExhibitionEntryRepository entryRepository;

    // 🔧 Ін’єкція через конструктор
    public ExhibitionEntryService(ExhibitionEntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public ExhibitionEntry addEntry(ExhibitionEntry entry) {
        return entryRepository.save(entry);
    }

    public void removeEntry(Long id) {
        entryRepository.deleteById(id);
    }
}
