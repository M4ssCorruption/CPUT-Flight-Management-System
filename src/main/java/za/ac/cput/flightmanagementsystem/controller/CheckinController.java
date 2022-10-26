
/*
Zaakirah Fakier
220461503
 */
package za.ac.cput.flightmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.flightmanagementsystem.domain.CheckIn;
import za.ac.cput.flightmanagementsystem.service.CheckInServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/checkin")
@Slf4j
@CrossOrigin
public class CheckinController {
    public final CheckInServiceImpl checkInService;

    public CheckinController(CheckInServiceImpl checkInService) {
        this.checkInService = checkInService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<CheckIn>> getAllCheckIns(){
        List<CheckIn> checkIn= checkInService.findAllCheckIns();
        return ResponseEntity.ok(checkIn);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CheckIn> findCheckIn(@PathVariable("id") Long id){
        CheckIn checkIn= checkInService.findCheckInById(id);
        return new ResponseEntity<>(checkIn, HttpStatus.OK);
    }
    @GetMapping("/findByTicketId/{ticketId}")
    public ResponseEntity<CheckIn> findCheckIn(@PathVariable("ticketId") String ticketId){
        CheckIn checkIn= checkInService.findCheckInByTicketId(ticketId);
        return new ResponseEntity<>(checkIn, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<CheckIn> addCheckIn(@RequestBody CheckIn checkIn){
        CheckIn newCheckIn= checkInService.addCheckIn(checkIn);
        return new ResponseEntity<>(newCheckIn, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<CheckIn> updateCheckIn(@RequestBody CheckIn checkIn){
        CheckIn updateCheckIn= checkInService.updateCheckIn(checkIn);
        return new ResponseEntity<>(updateCheckIn,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCheckIn(@PathVariable("id") Long id){
        checkInService.deleteCheckIn(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


