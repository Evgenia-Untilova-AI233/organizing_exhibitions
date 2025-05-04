package ua.opnu.organizing_exhibitions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entries")
public class ExhibitionEntryController {

    private final ExhibitionEntryService entryService;

    public ExhibitionEntryController(ExhibitionEntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping
    public ResponseEntity<ExhibitionEntry> assignExhibitToExhibition(@RequestBody ExhibitionEntry entry) {
        return new ResponseEntity<>(entryService.addEntry(entry), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEntry(@PathVariable Long id) {
        entryService.removeEntry(id);
        return ResponseEntity.noContent().build();
    }
}
