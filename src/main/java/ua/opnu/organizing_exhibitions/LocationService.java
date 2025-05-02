package ua.opnu.organizing_exhibitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location updateLocation(Long id, Location location) {
        if (locationRepository.existsById(id)) {
            location.setId(id);
            return locationRepository.save(location);
        }
        return null;
    }

    public boolean deleteLocation(Long id) {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Location> getTop3LocationsByExhibitions() {
        return locationRepository.findTopLocationsByExhibitions()
                .stream().limit(3).toList(); // обмеження до топ-3
    }
}
