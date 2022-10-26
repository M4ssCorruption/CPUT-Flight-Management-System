/*
 * Mary-Beth Agulhas
 * 219082367
 * ICountryRepository
 */
package za.ac.cput.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.flightmanagementsystem.domain.Country;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICountryRepository extends JpaRepository<Country, Long> {


    Optional<Country> findCountryById(Long id);


    Optional<Country> findCountriesByCountryId(String countryId);
}
