/*
 * Mary-Beth Agulhas
 * 219082367
 * AirportFactory
 */
package za.ac.cput.flightmanagementsystem.factory;

import za.ac.cput.flightmanagementsystem.domain.Airport;
import za.ac.cput.flightmanagementsystem.domain.City;
import za.ac.cput.flightmanagementsystem.Helper.helper;

public class AirportFactory {
    public static Airport build(String airportName,String cityId){

        helper.checkStringParam("Airport Name",airportName );

        helper.checkIfObjectNull("City",cityId);

        return new Airport.Builder()
                .airportName(airportName)
                .cityId(cityId)
                .build();

    }
}
