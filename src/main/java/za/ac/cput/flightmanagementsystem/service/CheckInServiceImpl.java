/*
Zaakirah Fakier
220461503
 */
package za.ac.cput.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.CheckIn;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.ICheckInRepository;
import java.util.List;

@Service
public class CheckInServiceImpl {

    private final ICheckInRepository checkInRepository;

    @Autowired

    public CheckInServiceImpl(ICheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }
    public CheckIn addCheckIn(CheckIn checkIn){
        return checkInRepository.save(checkIn);
    }
    public List<CheckIn> findAllCheckIns(){
        return checkInRepository.findAll();
    }
    public CheckIn updateCheckIn(CheckIn checkIn){
        return checkInRepository.save(checkIn);
    }
    public void deleteCheckIn(Long id){
        checkInRepository.deleteById(id);

    }
    public CheckIn findCheckInById(Long id){
        return (CheckIn) checkInRepository.findCheckInById(id).orElseThrow(
                ()->new NotFoundException("Check in by reserve seat "+id+" was not found"));
    }
    public CheckIn findCheckInByTicketId(String ticketId){
        return (CheckIn) checkInRepository.findCheckInByTicketId(ticketId).orElseThrow(
                ()->new NotFoundException("Check in by ticket "+ticketId+" was not found"));
    }

}

