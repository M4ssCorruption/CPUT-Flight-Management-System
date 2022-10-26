/*
 * Mary-Beth Agulhas
 * 219082367
 * IAirportRepository
 */
package za.ac.cput.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.flightmanagementsystem.domain.Airport;
import za.ac.cput.flightmanagementsystem.domain.CheckIn;
import za.ac.cput.flightmanagementsystem.domain.Passenger;

import java.util.Optional;
@Repository

public interface IAirportRepository extends JpaRepository<Airport,Long> {

    Optional<Airport> findAirportByCityId(String cityId);
    Optional<Airport> findAirportById(Long id);

}