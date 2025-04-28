package ua.opnu.organizing_exhibitions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exhibits")
public class ExhibitController {

    private final ExhibitService exhibitService;

    public ExhibitController(ExhibitService exhibitService) {
        this.exhibitService = exhibitService;
    }

    @PostMapping
    public ResponseEntity<Exhibit> addExhibit(@RequestBody Exhibit exhibit) {
        Exhibit savedExhibit = exhibitService.addExhibit(exhibit);
        return new ResponseEntity<>(savedExhibit, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Exhibit>> getAllExhibits() {
        List<Exhibit> exhibits = exhibitService.getAllExhibits();
        return new ResponseEntity<>(exhibits, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exhibit> updateExhibit(@PathVariable Long id, @RequestBody Exhibit exhibit) {
        Exhibit updatedExhibit = exhibitService.updateExhibit(id, exhibit);
        return updatedExhibit != null ?
                new ResponseEntity<>(updatedExhibit, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExhibit(@PathVariable Long id) {
        if (exhibitService.deleteExhibit(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/artist/{artistId}")
    public ResponseEntity<List<Exhibit>> getExhibitsByArtist(@PathVariable Long artistId) {
        List<Exhibit> exhibits = exhibitService.getExhibitsByArtist(artistId);
        return new ResponseEntity<>(exhibits, HttpStatus.OK);
    }

    @GetMapping("/exhibition/{exhibitionId}")
    public ResponseEntity<List<Exhibit>> getExhibitsByExhibition(@PathVariable Long exhibitionId) {
        List<Exhibit> exhibits = exhibitService.getExhibitsByExhibition(exhibitionId);
        return new ResponseEntity<>(exhibits, HttpStatus.OK);
    }
}
