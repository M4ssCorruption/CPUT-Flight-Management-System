/*
Zaakirah Fakier
220461503
 */
package za.ac.cput.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.flightmanagementsystem.domain.Ticket;
import java.util.Optional;

@Repository

public interface ITicketRepository  extends JpaRepository<Ticket, Long> {


    Optional<Ticket> findTicketById(Long id);
    Optional<Ticket> findTicketByTicketId(String ticketId);

}
