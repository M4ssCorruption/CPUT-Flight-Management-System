/*
Zaakirah Fakier
220461503
 */
package za.ac.cput.flightmanagementsystem.factory;

import za.ac.cput.flightmanagementsystem.domain.Ticket;
import za.ac.cput.flightmanagementsystem.Helper.helper;

public class TicketFactory {
    public static Ticket build(String ticketId, String passengerId, String flightId){
        helper.checkIfObjectNull("Ticket ID",ticketId);
        helper.checkIfObjectNull("Flight ID",flightId);
        helper.checkIfObjectNull("Passenger ID",passengerId);
        return new Ticket.Builder().setTicketId(ticketId).setPassengerId(passengerId).setFlightId(flightId).build();
    }
}
