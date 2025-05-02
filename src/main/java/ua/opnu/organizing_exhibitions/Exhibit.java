package ua.opnu.organizing_exhibitions;

import jakarta.persistence.*;

@Entity
public class Exhibit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int creationYear;

    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;  // Відношення з митцем

    @ManyToOne
    @JoinColumn(name = "exhibition_id", referencedColumnName = "id")
    private Exhibition exhibition; // Відношення з виставкою

    // Геттер для id
    public Long getId() {
        return id;
    }

    // Сеттер для id
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для name
    public String getName() {
        return name;
    }

    // Сеттер для name
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для description
    public String getDescription() {
        return description;
    }

    // Сеттер для description
    public void setDescription(String description) {
        this.description = description;
    }

    // Геттер для artist
    public Artist getArtist() {
        return artist;
    }

    // Сеттер для artist
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    // Геттер для exhibition
    public Exhibition getExhibition() {
        return exhibition;
    }

    // Сеттер для exhibition
    public void setExhibition(Exhibition exhibition) {
        this.exhibition = exhibition;

    }
    // Геттер для creationYear
    public int getCreationYear() {
        return creationYear;
    }

    // Сеттер для creationYear
    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }
}
