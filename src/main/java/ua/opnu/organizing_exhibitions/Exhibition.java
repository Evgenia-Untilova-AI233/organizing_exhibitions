package ua.opnu.organizing_exhibitions;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Exhibition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    private Location location;

    @OneToMany(mappedBy = "exhibition", cascade = CascadeType.ALL)
    private List<Exhibit> exhibits;

    // Геттери та Сеттери
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public LocalDate getStartDate() { return startDate; }

    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }

    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }

    public List<Exhibit> getExhibits() { return exhibits; }

    public void setExhibits(List<Exhibit> exhibits) { this.exhibits = exhibits; }
}
