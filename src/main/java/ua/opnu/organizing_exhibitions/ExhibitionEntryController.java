package ua.opnu.organizing_exhibitions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/exhibitionEntries")
public class ExhibitionEntryController {

    private final ExhibitionEntryService exhibitionEntryService;

    @Autowired
    public ExhibitionEntryController(ExhibitionEntryService exhibitionEntryService) {
        this.exhibitionEntryService = exhibitionEntryService;
    }

    // Додати запис до виставки
    @PostMapping
    public ResponseEntity<ExhibitionEntry> addExhibitionEntry(@RequestBody ExhibitionEntry exhibitionEntry) {
        ExhibitionEntry savedEntry = exhibitionEntryService.addExhibitionEntry(exhibitionEntry);
        return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
    }

    // Отримати записи по виставці
    @GetMapping("/exhibition/{exhibitionId}")
    public ResponseEntity<List<ExhibitionEntry>> getExhibitionEntriesByExhibition(@PathVariable Long exhibitionId) {
        Exhibition exhibition = new Exhibition();
        exhibition.setId(exhibitionId);
        List<ExhibitionEntry> entries = exhibitionEntryService.getExhibitionEntriesByExhibition(exhibition);
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    // Отримати записи по художнику
    @GetMapping("/artist/{artistId}")
    public ResponseEntity<List<ExhibitionEntry>> getExhibitionEntriesByArtist(@PathVariable Long artistId) {
        Artist artist = new Artist();
        artist.setId(artistId);
        List<ExhibitionEntry> entries = exhibitionEntryService.getExhibitionEntriesByArtist(artist);
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    // Отримати записи по експонату
    @GetMapping("/exhibit/{exhibitId}")
    public ResponseEntity<List<ExhibitionEntry>> getExhibitionEntriesByExhibit(@PathVariable Long exhibitId) {
        Exhibit exhibit = new Exhibit();
        exhibit.setId(exhibitId);
        List<ExhibitionEntry> entries = exhibitionEntryService.getExhibitionEntriesByExhibit(exhibit);
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    // Оновити запис
    @PutMapping("/{id}")
    public ResponseEntity<ExhibitionEntry> updateExhibitionEntry(@PathVariable Long id, @RequestBody ExhibitionEntry exhibitionEntry) {
        ExhibitionEntry updatedEntry = exhibitionEntryService.updateExhibitionEntry(id, exhibitionEntry);
        return updatedEntry != null ?
                new ResponseEntity<>(updatedEntry, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Видалити запис
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExhibitionEntry(@PathVariable Long id) {
        if (exhibitionEntryService.deleteExhibitionEntry(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
