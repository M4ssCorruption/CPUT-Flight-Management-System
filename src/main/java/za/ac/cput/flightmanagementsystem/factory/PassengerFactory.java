package za.ac.cput.flightmanagementsystem.factory;

import za.ac.cput.flightmanagementsystem.Helper.helper;
import za.ac.cput.flightmanagementsystem.domain.Passenger;

public class PassengerFactory {
    public static Passenger build(String firstName, String lastName, String email){
        helper.checkStringParam("Email", email);
        helper.checkEmail(email);
        helper.checkStringParam("First Name", firstName);
        helper.checkStringParam("Last Name", lastName);
        return new Passenger.Builder().setFirstName(firstName).setLastName(lastName).setEmail(email).build();

    }
}