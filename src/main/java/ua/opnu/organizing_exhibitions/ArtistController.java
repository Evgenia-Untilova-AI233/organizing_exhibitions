package ua.opnu.organizing_exhibitions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    // Constructor Injection
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.addArtist(artist), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists() {
        return ResponseEntity.ok(artistService.getAllArtists());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        return ResponseEntity.ok(artistService.updateArtist(id, artist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Artist>> getArtistsByCountry(@PathVariable String country) {
        return ResponseEntity.ok(artistService.getArtistsByCountry(country));
    }
}
