package za.ac.cput.flightmanagementsystem.repository;
/*
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 15 October 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.flightmanagementsystem.domain.Cabin_Crew;


import java.util.Optional;
@Repository
public interface ICabin_CrewRepository extends JpaRepository<Cabin_Crew, Long> {

    Optional<Cabin_Crew> findCabinCrewById(Long id);
}
