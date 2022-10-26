package za.ac.cput.flightmanagementsystem.controller;
/*
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 15 October 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.flightmanagementsystem.domain.Plane;
import za.ac.cput.flightmanagementsystem.service.PlaneServiceImpl;


import java.util.List;

@RestController
@RequestMapping("/plane")
@Slf4j
@CrossOrigin
public class PlaneController {
    private final PlaneServiceImpl planeService;

    public PlaneController(PlaneServiceImpl planeService) {
        this.planeService = planeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Plane>> getAllPlanes(){
        List<Plane> planes = planeService.findAllPlanes();
        return new ResponseEntity<>(planes, HttpStatus.OK);
    }

    @GetMapping ("/find/{id}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable("id") Long id){
        Plane plane = planeService.findPlaneById(id);
        return new ResponseEntity<>(plane, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Plane> addPlane(@RequestBody Plane plane){
        Plane newPlane = planeService.addPlane(plane);
        return new ResponseEntity<>(newPlane, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Plane> updatePlane(@RequestBody Plane plane){
        Plane updatedPlane = planeService.updatePlane(plane);
        return new ResponseEntity<>(updatedPlane, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlane(@PathVariable("id") Long id){
        planeService.deletePlane(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

