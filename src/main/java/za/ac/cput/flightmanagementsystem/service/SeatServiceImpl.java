/*
SeatServiceImpl.Java
Seat Service
Author: Erin Rowan (215271157)
 */
package za.ac.cput.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.Seat;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.ISeatRepository;

import java.util.List;

@Service
public class SeatServiceImpl {
    private final ISeatRepository repository;

    @Autowired
    public SeatServiceImpl(ISeatRepository repository)
    {this.repository=repository;}


    public Seat addSeat(Seat seat){
        return repository.save(seat);}

    public List<Seat> findAllSeats(){ return this.repository.findAll(); }

    public Seat updateSeat(Seat seat){
        return repository.save(seat);
    }
    public void deleteSeat(Long id){repository.deleteById(id);}

    public Seat findSeatById(Long id){return repository.findSeatById(id).orElseThrow(
            ()->new NotFoundException("Seat by id "+id+" was not found"));
    }
    public Seat findSeatBySeatId(String seatId){
        return repository.findSeatBySeatId(seatId).orElseThrow(
                ()->new NotFoundException("Seat by Seat ID: "+seatId+" was not found"));
    }
}

