package ua.opnu.organizing_exhibitions;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "location")
    private List<Exhibition> exhibitions; // Відношення до виставок

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

    // Геттер для address
    public String getAddress() {
        return address;
    }

    // Сеттер для address
    public void setAddress(String address) {
        this.address = address;
    }

    // Геттер для exhibitions
    public List<Exhibition> getExhibitions() {
        return exhibitions;
    }

    // Сеттер для exhibitions
    public void setExhibitions(List<Exhibition> exhibitions) {
        this.exhibitions = exhibitions;
    }
}
