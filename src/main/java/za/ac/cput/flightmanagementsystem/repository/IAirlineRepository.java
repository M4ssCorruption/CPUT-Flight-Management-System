
package za.ac.cput.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.flightmanagementsystem.domain.Airline;


import java.util.Optional;

@Repository
public interface IAirlineRepository extends JpaRepository<Airline, Long> {

    Optional<Airline> findAirlineByAirlineId(Long id);
}