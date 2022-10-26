package za.ac.cput.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.flightmanagementsystem.domain.FlightRoute;


import java.util.Optional;

@Repository
public interface IFlightRouteRepository extends JpaRepository<FlightRoute,Long> {
    Optional<FlightRoute> findFlightRouteById(Long id);
    Optional<FlightRoute> findFlightRouteByRouteId(String routeId);
}