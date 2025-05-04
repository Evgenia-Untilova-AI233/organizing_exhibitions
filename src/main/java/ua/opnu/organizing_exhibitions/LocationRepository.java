package ua.opnu.organizing_exhibitions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findTop3ByOrderByExhibitionsCountDesc(); // Додайте поле exhibitionsCount або створіть кастомний запит при потребі
}
