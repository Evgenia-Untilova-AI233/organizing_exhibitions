package ua.opnu.organizing_exhibitions;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Artist updateArtist(Long id, Artist updatedArtist) {
        Artist artist = artistRepository.findById(id).orElseThrow();
        artist.setName(updatedArtist.getName());
        artist.setCountry(updatedArtist.getCountry());
        return artistRepository.save(artist);
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }

    public List<Artist> getArtistsByCountry(String country) {
        return artistRepository.findByCountryIgnoreCase(country);
    }
}
