package ua.opnu.organizing_exhibitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    // Додати митця
    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    // Отримати всіх митців
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    // Отримати митців за країною
    public List<Artist> getArtistsByCountry(String country) {
        return artistRepository.findByCountry(country);
    }

    // Оновити дані митця
    public Artist updateArtist(Long id, Artist artist) {
        Optional<Artist> existingArtist = artistRepository.findById(id);
        if (existingArtist.isPresent()) {
            artist.setId(id); // Призначаємо id з шляху URL
            return artistRepository.save(artist);
        } else {
            return null; // Якщо артист не знайдений
        }
    }

    // Видалити митця
    public boolean deleteArtist(Long id) {
        if (artistRepository.existsById(id)) {
            artistRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
