package za.ac.cput.flightmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.flightmanagementsystem.domain.Passenger;
import za.ac.cput.flightmanagementsystem.service.PassengerServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/passenger")
@Slf4j
@CrossOrigin
public class PassengerController {
    private final PassengerServiceImpl passengerServiceImpl;

    public PassengerController(PassengerServiceImpl passengerServiceImpl) {
        this.passengerServiceImpl = passengerServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        List<Passenger> passengers= passengerServiceImpl.findAllPassengers();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }



    @GetMapping("/find/{id}")
    public ResponseEntity<Passenger> getPassengerId(@PathVariable("id") Long id){
        Passenger passenger= passengerServiceImpl.findPassengerById(id);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger){
        Passenger newPassenger= passengerServiceImpl.addPassenger(passenger);
        return new ResponseEntity<>(newPassenger, HttpStatus.CREATED);
    }



    @PutMapping("/update")
    public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger){
        Passenger updatePassenger= passengerServiceImpl.updatePassenger(passenger);
        return new ResponseEntity<>(updatePassenger,HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePassenger(@PathVariable("id") Long id){
        passengerServiceImpl.deletePassenger(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }



    @GetMapping("/email/{email}")
    public ResponseEntity<Passenger> findPassengerByEmail(@PathVariable String email) {
        Passenger passenger = passengerServiceImpl.findByEmail(email);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }



}