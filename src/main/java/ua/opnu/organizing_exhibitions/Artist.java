package ua.opnu.organizing_exhibitions;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @OneToMany(mappedBy = "artist")
    private List<Exhibit> exhibits;

    // Геттери та Сеттери
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public List<Exhibit> getExhibits() { return exhibits; }

    public void setExhibits(List<Exhibit> exhibits) { this.exhibits = exhibits; }
}
