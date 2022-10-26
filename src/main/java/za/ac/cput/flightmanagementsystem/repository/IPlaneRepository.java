package za.ac.cput.flightmanagementsystem.repository;
/*
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 15 October 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.flightmanagementsystem.domain.Plane;


import java.util.Optional;

@Repository
public interface IPlaneRepository extends JpaRepository<Plane, Long> {

    Optional<Plane> findPlaneById(Long planeId);

}


