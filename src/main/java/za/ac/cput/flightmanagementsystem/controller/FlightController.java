package za.ac.cput.flightmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.flightmanagementsystem.domain.Flight;
import za.ac.cput.flightmanagementsystem.service.FlightServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/flight")
@Slf4j
public class FlightController {
    private final FlightServiceImpl flightService;

    @Autowired
    public FlightController(FlightServiceImpl flightService){
        this.flightService = flightService;
    }

    @PostMapping("/add")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        Flight newFlight= flightService.addFlight(flight);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Flight>> findAll(){
        List<Flight> flightList = this.flightService.findAllFlights();
        return ResponseEntity.ok(flightList);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Flight> find(@PathVariable("id") Long id){
        Flight flight = flightService.findFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }
    @GetMapping("/findByFlightId/{flightId}")
    public ResponseEntity<Flight> getFlightId(@PathVariable("flightId") String flightId){
        Flight flight= flightService.findFlightByFlightId(flightId);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight){
        Flight updateFlight=flightService.updateFlight(flight);
        return new ResponseEntity<>(updateFlight,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
