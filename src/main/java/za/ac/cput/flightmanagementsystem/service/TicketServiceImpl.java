/*
Zaakirah Fakier
220461503
 */
package za.ac.cput.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.Ticket;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.ITicketRepository;

import java.util.List;

@Service
public class TicketServiceImpl {

    private final ITicketRepository ticketRepository;

    @Autowired

    public TicketServiceImpl(ITicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    public Ticket addTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    public List<Ticket> findAllTickets(){
        return ticketRepository.findAll();
    }
    public Ticket updateTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);

    }
    public Ticket findByTicketId(Long id){
        return ticketRepository.findTicketById(id).orElseThrow(
                ()->new NotFoundException("Ticket by id "+id+" was not found"));
    }
    public Ticket findTicketByTicketId(String ticketId){
        return ticketRepository.findTicketByTicketId(ticketId).orElseThrow(
                ()->new NotFoundException("Ticket by id "+ticketId+" was not found"));
    }
}

