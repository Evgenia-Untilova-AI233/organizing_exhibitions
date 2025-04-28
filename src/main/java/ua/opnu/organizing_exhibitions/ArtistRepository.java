package ua.opnu.organizing_exhibitions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByCountry(String country);
}
