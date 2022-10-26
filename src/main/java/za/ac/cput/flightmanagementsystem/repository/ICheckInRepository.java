/*
Zaakirah Fakier
220461503
 */
package za.ac.cput.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.flightmanagementsystem.domain.CheckIn;

import java.util.Optional;

@Repository
public interface ICheckInRepository extends JpaRepository<CheckIn,Long> {
    Optional<CheckIn> findCheckInById(Long id);
    Optional<CheckIn> findCheckInByTicketId(String ticketId);

}

