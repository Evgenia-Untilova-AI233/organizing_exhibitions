package ua.opnu.organizing_exhibitions;

import jakarta.persistence.*;

@Entity
public class ExhibitionEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exhibition_id", referencedColumnName = "id")
    private Exhibition exhibition;

    @ManyToOne
    @JoinColumn(name = "exhibit_id", referencedColumnName = "id")
    private Exhibit exhibit;

    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;

    // Геттер для id
    public Long getId() {
        return id;
    }

    // Сеттер для id
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для exhibition
    public Exhibition getExhibition() {
        return exhibition;
    }

    // Сеттер для exhibition
    public void setExhibition(Exhibition exhibition) {
        this.exhibition = exhibition;
    }

    // Геттер для exhibit
    public Exhibit getExhibit() {
        return exhibit;
    }

    // Сеттер для exhibit
    public void setExhibit(Exhibit exhibit) {
        this.exhibit = exhibit;
    }

    // Геттер для artist
    public Artist getArtist() {
        return artist;
    }

    // Сеттер для artist
    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
