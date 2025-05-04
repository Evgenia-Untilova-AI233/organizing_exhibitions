package ua.opnu.organizing_exhibitions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exhibitions")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    // Ін’єкція залежності через конструктор
    public ExhibitionController(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @PostMapping
    public ResponseEntity<Exhibition> addExhibition(@RequestBody Exhibition exhibition) {
        return new ResponseEntity<>(exhibitionService.addExhibition(exhibition), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Exhibition>> getAllExhibitions() {
        return ResponseEntity.ok(exhibitionService.getAllExhibitions());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exhibition> updateExhibition(@PathVariable Long id, @RequestBody Exhibition exhibition) {
        return ResponseEntity.ok(exhibitionService.updateExhibition(id, exhibition));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExhibition(@PathVariable Long id) {
        exhibitionService.deleteExhibition(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/current")
    public ResponseEntity<List<Exhibition>> getCurrentExhibitions() {
        return ResponseEntity.ok(exhibitionService.getCurrentExhibitions());
    }

    @GetMapping("/artist/{artistId}")
    public ResponseEntity<List<Exhibition>> getExhibitionsByArtist(@PathVariable Long artistId) {
        return ResponseEntity.ok(exhibitionService.getExhibitionsByArtist(artistId));
    }
}
