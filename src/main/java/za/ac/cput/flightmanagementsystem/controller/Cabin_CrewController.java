package za.ac.cput.flightmanagementsystem.controller;
/*
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 15 October 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.flightmanagementsystem.domain.Cabin_Crew;
import za.ac.cput.flightmanagementsystem.service.Cabin_CrewServiceImpl;


import java.util.List;

@RestController
@RequestMapping("/cabinCrew")
@Slf4j
@CrossOrigin
public class Cabin_CrewController {
    private final Cabin_CrewServiceImpl cabinCabinService;

    public Cabin_CrewController(Cabin_CrewServiceImpl cabinCabinService) {
        this.cabinCabinService = cabinCabinService;
    }

    @GetMapping ("/all")
    public ResponseEntity<List<Cabin_Crew>> getAllCabin_Crew() {
        List<Cabin_Crew> crewList = cabinCabinService.findAllCabinCrew();
        return new ResponseEntity<>(crewList, HttpStatus.OK);
    }

    @GetMapping ("/find/{id}")
    public ResponseEntity<Cabin_Crew> getCabin_CrewById(@PathVariable("id") Long id){
        Cabin_Crew crewMember = cabinCabinService.findCabinCrewById(id);
        return new ResponseEntity<>(crewMember, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Cabin_Crew> addCabin_Crew(@RequestBody Cabin_Crew cabinCrew){
        Cabin_Crew newCabinCrew = cabinCabinService.addCabinCrew(cabinCrew);
        return new ResponseEntity<>(newCabinCrew, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Cabin_Crew> updateCabin_Crew(@RequestBody Cabin_Crew cabinCrew){
        Cabin_Crew updatedCabinCrew = cabinCabinService.updateCabin_Crew(cabinCrew);
        return new ResponseEntity<>(updatedCabinCrew, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCabin_Crew(@PathVariable("id") Long id){
        cabinCabinService.deleteCabinCrew(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
