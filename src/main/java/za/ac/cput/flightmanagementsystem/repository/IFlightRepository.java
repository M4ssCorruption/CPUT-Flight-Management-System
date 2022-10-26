package za.ac.cput.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.flightmanagementsystem.domain.Flight;

import java.util.Optional;

@Repository
public interface IFlightRepository extends JpaRepository<Flight,Long> {


    Optional<Flight> findFlightById(Long id);
    Optional<Flight> findByFlightId(String flightId);


}
