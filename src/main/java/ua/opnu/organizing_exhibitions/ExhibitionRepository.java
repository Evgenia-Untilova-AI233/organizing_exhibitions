package ua.opnu.organizing_exhibitions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {
    List<Exhibition> findByLocationId(Long locationId);
}
