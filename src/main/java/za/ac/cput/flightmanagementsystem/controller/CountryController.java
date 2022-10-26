/*
 * Mary-Beth Agulhas
 * 219082367
 * CountryController
 */
package za.ac.cput.flightmanagementsystem.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.flightmanagementsystem.domain.Country;
import za.ac.cput.flightmanagementsystem.domain.Passenger;
import za.ac.cput.flightmanagementsystem.domain.Ticket;
import za.ac.cput.flightmanagementsystem.factory.CountryFactory;
import za.ac.cput.flightmanagementsystem.service.CountryServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/country")
@Slf4j
@CrossOrigin
public class CountryController {
    private final CountryServiceImpl countryService;

    @Autowired
    public CountryController(CountryServiceImpl countryService){
        this.countryService = countryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody Country country){
        Country newCountry= countryService.addCountry(country);
        return new ResponseEntity<>(newCountry, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Country>> findAll(){
        List<Country> countryList = this.countryService.findAllCountries();
        return ResponseEntity.ok(countryList);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Country> find(@PathVariable("id") Long id){
        Country country = countryService.findCountryById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
    @GetMapping("/findByCountryId/{countryId}")
    public ResponseEntity<Country> getCountryId(@PathVariable("countryId") String countryId){
        Country country= countryService.findCountryByCountryId(countryId);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Country> updateCountry(@RequestBody Country country){
        Country updateCountry=countryService.updateCountry(country);
        return new ResponseEntity<>(updateCountry,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
