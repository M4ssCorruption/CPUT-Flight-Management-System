/*
 * Mary-Beth Agulhas
 * 219082367
 * CityController
 */
package za.ac.cput.flightmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.flightmanagementsystem.domain.City;
import za.ac.cput.flightmanagementsystem.domain.Country;
import za.ac.cput.flightmanagementsystem.domain.Passenger;
import za.ac.cput.flightmanagementsystem.factory.CityFactory;
import za.ac.cput.flightmanagementsystem.factory.CountryFactory;
import za.ac.cput.flightmanagementsystem.service.CityServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/city")
@Slf4j
@CrossOrigin
public class CityController {
    private final CityServiceImpl cityService;


    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;

    }

    @GetMapping("/all")
    public ResponseEntity<List<City>> findAll() {
        List<City> cityList = this.cityService.findAllCities();
        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<City> read(@PathVariable("id") Long id) {
        City city = this.cityService.findCityById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<City> AddCity(@RequestBody City city){
        City newCity= cityService.addCity(city);
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<City> updateCity(@RequestBody City city){
        City updateCity= cityService.updateCity(city);
        return new ResponseEntity<>(updateCity,HttpStatus.OK);
    }

    @GetMapping("/findByCountry/{countryId}")
    public ResponseEntity<City> findV(@PathVariable("countryId") String countryId) {
        City city = cityService.findCitiesByCountry(countryId);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}


