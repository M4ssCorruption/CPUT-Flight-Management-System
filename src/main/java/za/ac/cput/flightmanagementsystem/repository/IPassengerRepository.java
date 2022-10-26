package za.ac.cput.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.flightmanagementsystem.domain.Passenger;

import java.util.Optional;

@Repository
public interface IPassengerRepository extends JpaRepository<Passenger,Long> {

    Optional<Passenger> findPassengerById(Long id);
    Optional<Passenger> findPassengerByPassengerId(String passengerId);
    Optional<Passenger> findByEmail(String email);


}
