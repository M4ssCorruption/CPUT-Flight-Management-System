/*
 * Mary-Beth Agulhas
 * 219082367
 * ICityRepository
 */
package za.ac.cput.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.flightmanagementsystem.domain.City;
import za.ac.cput.flightmanagementsystem.domain.Country;
import za.ac.cput.flightmanagementsystem.domain.Passenger;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICityRepository extends JpaRepository<City, Long> {
    Optional<City> findCityByCountryId(String countryId);
    Optional<City> findCityById(Long id);

}
