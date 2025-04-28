package ua.opnu.organizing_exhibitions;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Exhibition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;  // Відношення з місцем

    @OneToMany(mappedBy = "exhibition")
    private List<Exhibit> exhibits; // Відношення до експонатів

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

    // Геттер для location
    public Location getLocation() {
        return location;
    }

    // Сеттер для location
    public void setLocation(Location location) {
        this.location = location;
    }

    // Геттер для exhibits
    public List<Exhibit> getExhibits() {
        return exhibits;
    }

    // Сеттер для exhibits
    public void setExhibits(List<Exhibit> exhibits) {
        this.exhibits = exhibits;
    }
}
