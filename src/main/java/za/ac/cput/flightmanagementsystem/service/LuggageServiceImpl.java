/*
LuggageServiceImpl.Java
Luggage Service
Author: Erin Rowan (215271157)
 */
package za.ac.cput.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.Luggage;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.ILuggageRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LuggageServiceImpl {
    private final ILuggageRepository luggageRepository;

    @Autowired
    public LuggageServiceImpl(ILuggageRepository luggageRepository) {
        this.luggageRepository = luggageRepository;
    }

    public Luggage addLuggage(Luggage luggage) {
        return luggageRepository.save(luggage);
    }

    public List<Luggage> findAllLuggage() {
        return luggageRepository.findAll();
    }

    public Luggage updateLuggage(Luggage luggage) {
        return luggageRepository.save(luggage);
    }

    public Luggage findLuggageById(Long id) {
        return luggageRepository.findLuggageById(id)
                .orElseThrow(() -> new NotFoundException("Luggage by id " + id + " was not found"));
    }

    public void deleteLuggage(Long id){
        luggageRepository.deleteById(id);
    }
}
