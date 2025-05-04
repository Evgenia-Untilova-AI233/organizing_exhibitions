package ua.opnu.organizing_exhibitions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exhibits")
public class ExhibitController {

    private final ExhibitService exhibitService;

    // Ін’єкція залежності через конструктор
    public ExhibitController(ExhibitService exhibitService) {
        this.exhibitService = exhibitService;
    }

    @PostMapping
    public ResponseEntity<Exhibit> addExhibit(@RequestBody Exhibit exhibit) {
        return new ResponseEntity<>(exhibitService.addExhibit(exhibit), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Exhibit>> getAllExhibits() {
        return ResponseEntity.ok(exhibitService.getAllExhibits());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exhibit> updateExhibit(@PathVariable Long id, @RequestBody Exhibit exhibit) {
        return ResponseEntity.ok(exhibitService.updateExhibit(id, exhibit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExhibit(@PathVariable Long id) {
        exhibitService.deleteExhibit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/artist/{artistId}")
    public ResponseEntity<List<Exhibit>> getExhibitsByArtist(@PathVariable Long artistId) {
        return ResponseEntity.ok(exhibitService.getExhibitsByArtist(artistId));
    }

    @GetMapping("/createdAfter/{year}")
    public ResponseEntity<List<Exhibit>> getExhibitsCreatedAfter(@PathVariable int year) {
        return ResponseEntity.ok(exhibitService.getExhibitsCreatedAfterYear(year));
    }

    @GetMapping("/notInExhibition")
    public ResponseEntity<List<Exhibit>> getExhibitsNotInExhibition() {
        return ResponseEntity.ok(exhibitService.getExhibitsNotInExhibition());
    }
}
