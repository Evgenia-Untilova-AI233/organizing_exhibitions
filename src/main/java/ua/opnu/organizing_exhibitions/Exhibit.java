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
    private Artist artist;

    @ManyToOne
    private Exhibition exhibition;

    // Геттери та Сеттери
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getCreationYear() { return creationYear; }

    public void setCreationYear(int creationYear) { this.creationYear = creationYear; }

    public Artist getArtist() { return artist; }

    public void setArtist(Artist artist) { this.artist = artist; }

    public Exhibition getExhibition() { return exhibition; }

    public void setExhibition(Exhibition exhibition) { this.exhibition = exhibition; }
}
