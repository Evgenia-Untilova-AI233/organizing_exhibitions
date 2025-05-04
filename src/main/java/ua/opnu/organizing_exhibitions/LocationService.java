package ua.opnu.organizing_exhibitions;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    // Ін’єкція залежності через конструктор
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location updateLocation(Long id, Location updatedLocation) {
        Location location = locationRepository.findById(id).orElseThrow();
        location.setName(updatedLocation.getName());
        location.setCity(updatedLocation.getCity());
        return locationRepository.save(location);
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    public List<Location> getTop3LocationsByExhibitions() {
        return locationRepository.findTop3ByOrderByExhibitionsCountDesc();
    }
}
