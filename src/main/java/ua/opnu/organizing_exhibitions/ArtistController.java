package ua.opnu.organizing_exhibitions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    // Використовуємо конструктор для впровадження залежностей
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    // Додати митця
    @PostMapping
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
        Artist savedArtist = artistService.addArtist(artist);
        return new ResponseEntity<>(savedArtist, HttpStatus.CREATED);
    }

    // Отримати всіх митців
    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = artistService.getAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    // Оновити дані митця
    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        Artist updatedArtist = artistService.updateArtist(id, artist);
        return updatedArtist != null ?
                new ResponseEntity<>(updatedArtist, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Отримати митців за країною
    @GetMapping("/country/{country}")
    public ResponseEntity<List<Artist>> getArtistsByCountry(@PathVariable String country) {
        List<Artist> artists = artistService.getArtistsByCountry(country);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    // Видалити митця
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        if (artistService.deleteArtist(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
