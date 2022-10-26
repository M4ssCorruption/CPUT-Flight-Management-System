/*
 * Mary-Beth Agulhas
 * 219082367
 * AirportServiceImpl
 */
package za.ac.cput.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.Airport;
import za.ac.cput.flightmanagementsystem.domain.CheckIn;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.IAirportRepository;
//import za.ac.cput.flightsystemmanager.repository.IAirportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl {

    private final IAirportRepository repository;

    @Autowired
    public AirportServiceImpl(IAirportRepository repository) {
        this.repository = repository;
    }


    public Airport addAirport(Airport airport) {
        return repository.save(airport);
    }

    public List<Airport> findAllAirports() {
        return repository.findAll();
    }

    public Airport updateAirport(Airport airport){return repository.save(airport);}

    public void deleteAirport(Long id) {
        repository.deleteById(id);

    }
    public Airport findAirportById(Long id){
        return (Airport) repository.findAirportById(id).orElseThrow(
                ()->new NotFoundException("Airport by ID: "+id+" was not found"));
    }

    public Airport findAirportByCiyId(String cityId) {
        return (Airport) repository.findAirportByCityId(cityId).orElseThrow(
                () -> new NotFoundException("Airport by City: " + cityId + " was not found"));
    }


}
