/*
SeatController.Java
Seat Controller
Author: Erin Rowan (215271157)
 */
package za.ac.cput.flightmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.flightmanagementsystem.domain.Seat;
import za.ac.cput.flightmanagementsystem.service.SeatServiceImpl;


import java.util.List;

@RestController
@RequestMapping("/seat")
@Slf4j
@CrossOrigin
public class SeatController {
    private final SeatServiceImpl seatService;

    @Autowired
    public SeatController(SeatServiceImpl seatService){
        this.seatService = seatService;
    }

    @PostMapping("/add")
    public ResponseEntity<Seat> addSeat(@RequestBody Seat seat){
        Seat newSeat= seatService.addSeat(seat);
        return new ResponseEntity<>(newSeat, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Seat>> findAll(){
        List<Seat> seatList = this.seatService.findAllSeats();
        return ResponseEntity.ok(seatList);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Seat> find(@PathVariable("id") Long id){
        Seat seat = seatService.findSeatById(id);
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }
    @GetMapping("/findBySeatId/{seatId}")
    public ResponseEntity<Seat> getSeatId(@PathVariable("seatId") String seatId){
        Seat seat= seatService.findSeatBySeatId(seatId);
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Seat> updateSeat(@RequestBody Seat seat){
        Seat updateSeat=seatService.updateSeat(seat);
        return new ResponseEntity<>(updateSeat,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.seatService.deleteSeat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}



