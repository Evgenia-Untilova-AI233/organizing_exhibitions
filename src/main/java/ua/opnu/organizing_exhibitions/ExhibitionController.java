package ua.opnu.organizing_exhibitions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exhibitions")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    public ExhibitionController(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @PostMapping
    public ResponseEntity<Exhibition> addExhibition(@RequestBody Exhibition exhibition) {
        Exhibition savedExhibition = exhibitionService.addExhibition(exhibition);
        return new ResponseEntity<>(savedExhibition, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Exhibition>> getAllExhibitions() {
        List<Exhibition> exhibitions = exhibitionService.getAllExhibitions();
        return new ResponseEntity<>(exhibitions, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exhibition> updateExhibition(@PathVariable Long id, @RequestBody Exhibition exhibition) {
        Exhibition updatedExhibition = exhibitionService.updateExhibition(id, exhibition);
        return updatedExhibition != null ?
                new ResponseEntity<>(updatedExhibition, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExhibition(@PathVariable Long id) {
        if (exhibitionService.deleteExhibition(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/location/{locationId}")
    public ResponseEntity<List<Exhibition>> getExhibitionsByLocation(@PathVariable Long locationId) {
        List<Exhibition> exhibitions = exhibitionService.getExhibitionsByLocation(locationId);
        return new ResponseEntity<>(exhibitions, HttpStatus.OK);
    }
}
