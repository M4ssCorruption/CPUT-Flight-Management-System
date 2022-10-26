package za.ac.cput.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.Airline;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.IAirlineRepository;


import java.util.List;

@Service
public class AirlineServiceImpl {

    private final IAirlineRepository airlineRepo;

    @Autowired
    public AirlineServiceImpl(IAirlineRepository airlineRepo) {
        this.airlineRepo = airlineRepo;
    }

    public Airline addAirline(Airline airline)
    {
        return airlineRepo.save(airline);
    }

    public List<Airline> findAllAirlines()
    {
        return airlineRepo.findAll();
    }

    public Airline findAirlineById(Long airlineId)
    {
        return airlineRepo.findAirlineByAirlineId(airlineId).orElseThrow(() -> new NotFoundException("User by id" + airlineId + "was not found"));
    }

    public Airline updateAirline(Airline passenger) {
        return airlineRepo.save(passenger);
    }
    public void deleteAirline(Long airlineId)
    {
        airlineRepo.deleteById(airlineId);
    }


}