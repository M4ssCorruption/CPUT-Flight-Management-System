package za.ac.cput.flightmanagementsystem.service;
/*
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 15 October 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.Cabin_Crew;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.ICabin_CrewRepository;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Cabin_CrewServiceImpl {
    private final ICabin_CrewRepository cabinCrewRepo;

    @Autowired
    public Cabin_CrewServiceImpl(ICabin_CrewRepository cabinCrewRepo) {
        this.cabinCrewRepo = cabinCrewRepo;
    }

    public Cabin_Crew addCabinCrew(Cabin_Crew cabinCrew){
        return cabinCrewRepo.save(cabinCrew);
    }

    public List<Cabin_Crew> findAllCabinCrew(){
        return cabinCrewRepo.findAll();
    }

    public Cabin_Crew updateCabin_Crew(Cabin_Crew cabinCrew){
        return cabinCrewRepo.save(cabinCrew);
    }

    public Cabin_Crew findCabinCrewById(Long id){
        return cabinCrewRepo.findCabinCrewById(id)
                .orElseThrow(()-> new NotFoundException("Crew by id" +id+" not found" ));
    }

    public void deleteCabinCrew(Long id){
        cabinCrewRepo.deleteById(id);
    }
}

