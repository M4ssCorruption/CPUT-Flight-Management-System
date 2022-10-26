package za.ac.cput.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.FlightRoute;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.IFlightRouteRepository;


import java.util.List;

@Service
public class FlightRouteServiceImpl {
    private final IFlightRouteRepository repository;

    @Autowired
    public FlightRouteServiceImpl(IFlightRouteRepository repository) {
        this.repository = repository;
    }


    public FlightRoute addFlightRoute(FlightRoute flightRoute) {
        return repository.save(flightRoute);
    }

    public List<FlightRoute> findAllFlightRoutes() {
        return this.repository.findAll();
    }

    public FlightRoute updateFlightRoute(FlightRoute flightRoute) {
        return repository.save(flightRoute);
    }

    public void deleteFlightRoute(Long id) {
        repository.deleteById(id);
    }

    public FlightRoute findFlightRouteById(Long id) {
        return repository.findFlightRouteById(id).orElseThrow(
                () -> new NotFoundException("FlightRoute by id " + id + " was not found"));
    }

    public FlightRoute findFlightRouteByFlightRouteId(String flightRouteId) {
        return repository.findFlightRouteByRouteId(flightRouteId).orElseThrow(
                () -> new NotFoundException("FlightRoute by FlightRoute ID: " + flightRouteId + " was not found"));
    }
}