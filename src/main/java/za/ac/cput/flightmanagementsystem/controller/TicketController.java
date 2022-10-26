/*
Zaakirah Fakier
220461503
 */
package za.ac.cput.flightmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.flightmanagementsystem.domain.Ticket;
import za.ac.cput.flightmanagementsystem.service.TicketServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@Slf4j
@CrossOrigin
public class TicketController {
    public final TicketServiceImpl ticketService;

    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> ticket= ticketService.findAllTickets();
        return ResponseEntity.ok(ticket);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Ticket> getId(@PathVariable("id") Long id){
        Ticket ticket= ticketService.findByTicketId(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
    @GetMapping("/findByTicketId/{ticketId}")
    public ResponseEntity<Ticket> getCountryId(@PathVariable("ticketId") String ticketId){
        Ticket ticket= ticketService.findTicketByTicketId(ticketId);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
        Ticket newTicket= ticketService.addTicket(ticket);
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket){
        Ticket updateTicket= ticketService.updateTicket(ticket);
        return new ResponseEntity<>(updateTicket,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id){
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


