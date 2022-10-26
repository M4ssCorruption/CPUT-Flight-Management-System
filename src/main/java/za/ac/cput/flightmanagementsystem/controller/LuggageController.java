/*
LuggageController.Java
Luggage Controller
Author: Erin Rowan (215271157)
 */
package za.ac.cput.flightmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.flightmanagementsystem.domain.Luggage;
import za.ac.cput.flightmanagementsystem.service.LuggageServiceImpl;


import java.util.List;

@RestController
@RequestMapping("/luggage")
@Slf4j
@CrossOrigin
public class LuggageController {
    private final LuggageServiceImpl luggageService;

    public LuggageController(LuggageServiceImpl luggageService) {
        this.luggageService = luggageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Luggage>> getAllLuggage () {
        List<Luggage> luggage = luggageService.findAllLuggage();
        return new ResponseEntity<>(luggage, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Luggage> getLuggageById (@PathVariable("id") Long id) {
        Luggage luggage = luggageService.findLuggageById(id);
        return new ResponseEntity<>(luggage, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Luggage> addLuggage(@RequestBody Luggage luggage) {
        Luggage newLuggage = luggageService.addLuggage(luggage);
        return new ResponseEntity<>(newLuggage, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Luggage> updateLuggage(@RequestBody Luggage luggage) {
        Luggage updateLuggage = luggageService.updateLuggage(luggage);
        return new ResponseEntity<>(updateLuggage, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLuggage(@PathVariable("id") Long id) {
        luggageService.deleteLuggage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
