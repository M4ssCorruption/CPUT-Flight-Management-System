package za.ac.cput.flightmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.flightmanagementsystem.domain.FlightRoute;
import za.ac.cput.flightmanagementsystem.service.FlightRouteServiceImpl;


import java.util.List;

@RestController
@RequestMapping("/flightRoute")
@Slf4j
@CrossOrigin
public class FlightRouteController {

    private final FlightRouteServiceImpl flightRouteService;

    @Autowired
    public FlightRouteController(FlightRouteServiceImpl flightRouteService){
        this.flightRouteService = flightRouteService;
    }

    @PostMapping("/add")
    public ResponseEntity<FlightRoute> addFlightRoute(@RequestBody FlightRoute flightRoute){
        FlightRoute newFlightRoute= flightRouteService.addFlightRoute(flightRoute);
        return new ResponseEntity<>(newFlightRoute, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<FlightRoute>> findAll(){
        List<FlightRoute> flightRouteList = this.flightRouteService.findAllFlightRoutes();
        return ResponseEntity.ok(flightRouteList);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<FlightRoute> find(@PathVariable("id") Long id){
        FlightRoute flightRoute = flightRouteService.findFlightRouteById(id);
        return new ResponseEntity<>(flightRoute, HttpStatus.OK);
    }
    @GetMapping("/findByFlightRouteId/{flightRouteId}")
    public ResponseEntity<FlightRoute> getFlightRouteId(@PathVariable("flightRouteId") String flightRouteId){
        FlightRoute flightRoute= flightRouteService.findFlightRouteByFlightRouteId(flightRouteId);
        return new ResponseEntity<>(flightRoute, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<FlightRoute> updateFlightRoute(@RequestBody FlightRoute flightRoute){
        FlightRoute updateFlightRoute=flightRouteService.updateFlightRoute(flightRoute);
        return new ResponseEntity<>(updateFlightRoute,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.flightRouteService.deleteFlightRoute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}