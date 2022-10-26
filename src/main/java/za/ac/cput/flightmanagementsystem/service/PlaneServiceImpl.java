package za.ac.cput.flightmanagementsystem.service;
/*
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 15 October 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.Plane;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.IPlaneRepository;


import java.util.List;

@Service
public class PlaneServiceImpl {
    private final IPlaneRepository planeRepo;

    @Autowired
    public PlaneServiceImpl(IPlaneRepository planeRepository) {
        this.planeRepo = planeRepository;
    }

    public Plane addPlane(Plane plane){
        return planeRepo.save(plane);
    }

    public List<Plane> findAllPlanes(){
        return planeRepo.findAll();
    }

    public Plane updatePlane(Plane plane){
        return planeRepo.save(plane);
    }

    public Plane findPlaneById(Long id){
        return planeRepo.findPlaneById(id).
                orElseThrow(()-> new NotFoundException("Plane by id" +id+" not found" ));
    }

    public void deletePlane(Long id){
        planeRepo.deleteById(id);
    }
}