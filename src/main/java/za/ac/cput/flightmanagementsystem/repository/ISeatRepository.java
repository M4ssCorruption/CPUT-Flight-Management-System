/*
ISeatRepository.Java
Seat Repository
Author: Erin Rowan (215271157)
 */
package za.ac.cput.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.flightmanagementsystem.domain.Seat;

import java.util.Optional;

@Repository
public interface ISeatRepository extends JpaRepository<Seat, Long> {

    Optional<Seat> findSeatById(Long id);
    Optional<Seat> findSeatBySeatId(String SeatId);
    Optional<Seat> findSeatByPassengerId(String id);
}
