package za.ac.cput.flightmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.flightmanagementsystem.domain.Airline;
import za.ac.cput.flightmanagementsystem.service.AirlineServiceImpl;


import java.util.List;

@RestController
@RequestMapping("/airline")
@Slf4j
@CrossOrigin
public class AirlineController {
    private final AirlineServiceImpl airlineService;

    public AirlineController(AirlineServiceImpl airlineService)
    {
        this.airlineService =  airlineService;

    }

    @GetMapping("/all")
    public ResponseEntity<List<Airline>> getAllAirlines()
    {
        List<Airline> airlines = airlineService.findAllAirlines();
        return new ResponseEntity<>(airlines, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable("id")Long id)
    {
        Airline airline = airlineService.findAirlineById(id);
        return new ResponseEntity<>(airline, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Airline> addAirline(@RequestBody Airline airline)
    {
        Airline newAirline = airlineService.addAirline(airline);
        return new ResponseEntity<>(newAirline, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Airline> updateAirline(@RequestBody Airline airline)
    {
        Airline updateAirline = airlineService.updateAirline(airline);
        return new ResponseEntity<>(updateAirline, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAirline(@PathVariable("id")Long id)
    {
        airlineService.deleteAirline(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}