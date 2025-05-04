package ua.opnu.organizing_exhibitions;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;

    @OneToMany(mappedBy = "location")
    private List<Exhibition> exhibitions;

    // Геттери та Сеттери
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public List<Exhibition> getExhibitions() { return exhibitions; }

    public void setExhibitions(List<Exhibition> exhibitions) { this.exhibitions = exhibitions; }
}
