package za.ac.cput.flightmanagementsystem.factory;

import za.ac.cput.flightmanagementsystem.Helper.helper;
import za.ac.cput.flightmanagementsystem.domain.Flight;

public class FlightFactory {
    public static Flight build(String planeId, String flightId,String crewId, int seatsAvailable){
        helper.checkStringParam("Plane", planeId);
        helper.checkIfObjectNull("Cabin Crew", crewId);
        helper.checkIfObjectNull("Seats Available", seatsAvailable);
        return new Flight.Builder().setPlaneId(planeId).setFlightId(flightId).setCrewId(crewId).setSeatsAvailable(seatsAvailable).build();
    }


}