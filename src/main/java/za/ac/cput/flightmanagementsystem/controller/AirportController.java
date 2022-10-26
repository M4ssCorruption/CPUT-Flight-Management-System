/*
* Mary-Beth Agulhas
* 219082367
* AirportController
 */
package za.ac.cput.flightmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.flightmanagementsystem.domain.Airport;
import za.ac.cput.flightmanagementsystem.domain.CheckIn;
import za.ac.cput.flightmanagementsystem.domain.City;
import za.ac.cput.flightmanagementsystem.factory.AirportFactory;
import za.ac.cput.flightmanagementsystem.factory.CityFactory;
import za.ac.cput.flightmanagementsystem.service.AirportServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/airport")
@Slf4j
@CrossOrigin
public class AirportController {
    private final AirportServiceImpl airportService;

    @Autowired
    public AirportController(AirportServiceImpl airportService){
        this.airportService=airportService;
    }

    @PostMapping("/add")
    public ResponseEntity<Airport> save(@RequestBody Airport airport){
        Airport save= airportService.addAirport(airport);
        return new ResponseEntity<>(save,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = airportService.findAllAirports();
        return new ResponseEntity<>(airports,HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Airport> findAirport(@PathVariable("id") Long id){
        Airport airport= airportService.findAirportById(id);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }
    @GetMapping("/findByCity/{cityId}")
    public ResponseEntity<Airport> findAirportByCityId(@PathVariable("cityId") String cityId){
        Airport airport= airportService.findAirportByCiyId(cityId);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Airport> updateAirport(@RequestBody Airport airport){
        Airport updateAirport= airportService.updateAirport(airport);
        return new ResponseEntity<>(updateAirport,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.airportService.deleteAirport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
