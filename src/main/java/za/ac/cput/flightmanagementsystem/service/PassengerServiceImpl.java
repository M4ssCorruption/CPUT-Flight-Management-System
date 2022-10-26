package za.ac.cput.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.Passenger;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.IPassengerRepository;

import java.util.List;

@Service
public class PassengerServiceImpl {
    private final IPassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl(IPassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger addPassenger(Passenger passenger){
        return  passengerRepository.save(passenger);
    }
    public List<Passenger> findAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger updatePassenger(Passenger passenger){
        return passengerRepository.save(passenger);

    }
    public void deletePassenger(Long id){
        passengerRepository.deleteById(id);
    }

    public Passenger findPassengerById(Long id){
        return passengerRepository.findPassengerById(id).orElseThrow(
                ()-> new NotFoundException("Passenger by id "+id+" was not found"));
    }

    public  Passenger findByEmail(String email){
        return passengerRepository.findByEmail(email).orElseThrow(
                ()-> new NotFoundException("Passenger by email "+email+ " was not found"));
    }
}
