package za.ac.cput.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.Flight;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.IFlightRepository;

import java.util.List;

@Service
public class FlightServiceImpl {
    private final IFlightRepository repository;

    @Autowired
    public FlightServiceImpl(IFlightRepository repository) {
        this.repository = repository;
    }


    public Flight addFlight(Flight flight) {
        return repository.save(flight);
    }

    public List<Flight> findAllFlights() {
        return this.repository.findAll();
    }

    public Flight updateFlight(Flight flight) {
        return repository.save(flight);
    }

    public void deleteFlight(Long id) {
        repository.deleteById(id);
    }

    public Flight findFlightById(Long id) {
        return repository.findFlightById(id).orElseThrow(
                () -> new NotFoundException("Flight by id " + id + " was not found"));
    }

    public Flight findFlightByFlightId(String flightId) {
        return repository.findByFlightId(flightId).orElseThrow(
                () -> new NotFoundException("Flight by Flight ID: " + flightId + " was not found"));
    }
}